import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { clearCart } from "../redux/cartSlice"; // action to clear the cart after payment
import Razorpay from "razorpay";
import { useNavigate } from "react-router-dom";

const PaymentPage = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const cartItems = useSelector((state) => state.cart.cartItems);

  // Calculate the total amount
  const totalAmount = cartItems.reduce(
    (acc, item) => acc + item.itemPrice * item.quantity,
    0
  );

  const [loading, setLoading] = useState(false);

  // const createOrder = async () => {
  //   const response = await fetch("http://localhost:5000/create-order", {
  //     method: "POST",
  //     headers: {
  //       "Content-Type": "application/json",
  //     },
  //     body: JSON.stringify({
  //       amount: totalAmount, // Pass the total amount here
  //     }),
  //   });
  //   const orderData = await response.json();
  //   return orderData;
  // };

  const createOrder = async (totalAmount, userId) => {
    // Generate a dummy orderId (for example, using a random number or timestamp)
    const orderId = `ORD${Math.floor(Math.random() * 1000000)}`;

    // Get the current date and time
    const orderDateTime = new Date().toISOString(); // Use ISO format for date-time

    // Define status as "PLACED" initially
    const status = "PLACED";

    // Construct the dummy order data
    const orderData = {
      orderId,
      orderDateTime,
      status,
      userId,
    };

    // Return the dummy orderData as if it came from the server
    return orderData;
  };

  const handlePayment = async () => {
    setLoading(true);

    // Create order here with Razorpay - Ideally this should come from your server
    // const orderData = {
    //   amount: totalAmount * 100, // Razorpay requires the amount in paise (i.e., 100 paise = 1 INR)
    //   currency: "INR",
    //   receipt: `order_${new Date().getTime()}`,
    // };

    const orderData = await createOrder(); // Get the order data from backend

    // Initialize Razorpay options
    const options = {
      key: "YOUR_RAZORPAY_KEY_ID", // Replace with your Razorpay key ID
      amount: orderData.amount,
      currency: "INR",
      name: "Your Store",
      description: "Payment for cart items",
      order_id: orderData.id, // Use the order ID from the backend
      handler: function (response) {
        // Handle the payment success
        if (response.razorpay_payment_id) {
          dispatch(clearCart()); // Empty the cart after successful payment
          navigate("/order-confirmation"); // Navigate to order confirmed page
        }
      },
      prefill: {
        name: "Customer",
        email: "customer@example.com",
        contact: "1234567890",
      },
      theme: {
        color: "#F37254",
      },
    };

    const paymentObject = new Razorpay(options);
    paymentObject.open();
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
          <span className="font-semibold">${totalAmount.toFixed(2)}</span>
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
