import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { clearCart } from "../redux/cartSlice";
import { useNavigate } from "react-router-dom";

const PaymentPage = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const cartItems = useSelector((state) => state.cart.cartItems);

  const totalAmount = cartItems.reduce(
    (acc, item) => acc + item.itemPrice * item.quantity,
    0
  );

  const [loading, setLoading] = useState(false);
  const [orderData, setOrderData] = useState(null);

  const createOrder = async () => {
    const orderItemsList = cartItems.map((item) => ({
      items: {
        itemId: item.itemId,
      },
      quantity: item.quantity,
    }));

    const token = localStorage.getItem("token");

    const response = await fetch(import.meta.env.VITE_API_URL + "/order/add", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify({
        user: {
          userId: JSON.parse(localStorage.getItem("user")).userId,
        },
        orderDateTime: new Date().toISOString(),
        orderStatus: "PLACED",
        orderItemsList: orderItemsList,
      }),
    });

    if (response.ok) {
      const orderData = await response.json();
      return orderData;
    } else {
      console.error("Failed to create order:", response.status);
      return null;
    }
  };

  const createOrderItems = async (orderId) => {
    const orderItemsList = cartItems.map((item) => ({
      items: {
        itemId: item.itemId,
      },
      quantity: item.quantity,
      order: {
        orderId,
      },
    }));

    const token = localStorage.getItem("token");

    const response = await fetch(
      import.meta.env.VITE_API_URL + "/u/orderitems/addList",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
        body: JSON.stringify(orderItemsList),
      }
    );

    if (response.ok) {
      const orderItemsList = await response.json();
      return orderItemsList;
    } else {
      console.error("Failed to create order:", response.status);
      return null;
    }
  };

  const createPayment = async (orderId) => {
    try {
      const token = localStorage.getItem("token");

      const response = await fetch(
        import.meta.env.VITE_API_URL + "/payments/create",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`,
          },
          body: JSON.stringify({
            orderId,
            amount: totalAmount.toFixed(2),
          }),
        }
      );

      const payment = await response.json();
      return payment;
    } catch (error) {
      console.error("Error creating payment:", error);
      return null;
    }
  };

  const handlePayment = async (e) => {
    e.preventDefault();
    setLoading(true);

    const orderData = await createOrder();
    if (orderData) {
      setOrderData(orderData);
      const orderItemsList = await createOrderItems(orderData.orderId);

      const payment = await createPayment(orderData.orderId);
      if (payment) {
        const options = {
          key: "rzp_test_BLuYvjyR58WQhz",
          amount: payment.amount * 100,
          currency: "INR",
          name: "OrderEase",
          description: "Payment for cart items",
          order_id: payment.razorpayOrderId,
          callback_url: "http://localhost:8080/payments/callback",
          handler: function (response) {
            if (response.razorpay_payment_id) {
              dispatch(clearCart());
              navigate("/order-confirmation");
            }
          },
          prefill: {
            name: "Customer",
            email: "customer@example.com",
          },
          theme: {
            color: "#F37254",
          },
        };

        const paymentObject = new window.Razorpay(options);
        paymentObject.open();
      }
    }

    setLoading(false);
  };

  return (
    <div className="container mx-auto p-4">
      <h1 className="text-3xl font-bold text-center text-primary mb-6">
        Payment
      </h1>

      <div className="space-y-4 mb-6">
        <div className="flex justify-between items-center text-lg text-primary">
          <span>Total Amount</span>
          <span className="font-semibold">Rs.{totalAmount.toFixed(2)}</span>
        </div>
      </div>

      <div className="flex justify-center">
        <button
          onClick={handlePayment}
          className="py-3 px-6 text-white bg-primary rounded-full hover:bg-secondary"
          disabled={loading}
        >
          {loading ? "Processing..." : "Pay Now"}
        </button>
      </div>
    </div>
  );
};

export default PaymentPage;
