import React, { useEffect, useState } from "react";

// Dummy data for order items (replace with real API fetching logic)
const dummyOrderItems = [
  {
    orderItemId: "ITEM1",
    itemId: "ITEM1",
    orderId: "ORD123456",
    quantity: 2,
    itemPrice: 10.0,
    itemName: "Product A",
  },
  {
    orderItemId: "ITEM2",
    itemId: "ITEM2",
    orderId: "ORD123456",
    quantity: 1,
    itemPrice: 20.0,
    itemName: "Product B",
  },
  {
    orderItemId: "ITEM3",
    itemId: "ITEM1",
    orderId: "ORD1234567",
    quantity: 2,
    itemPrice: 10.0,
    itemName: "Product A",
  },
  {
    orderItemId: "ITEM4",
    itemId: "ITEM2",
    orderId: "ORD12345678",
    quantity: 1,
    itemPrice: 20.0,
    itemName: "Product B",
  },
];

const UserOrderCard = ({ order }) => {
  const [orderItems, setOrderItems] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const fetchOrderItems = async () => {
    try {
      // Commented out the real API call
      // const response = await fetch(`/orderitems/${order.orderId}`);
      // if (!response.ok) throw new Error("Failed to fetch order items.");
      // const data = await response.json();

      // Using dummy data for testing
      setOrderItems(
        dummyOrderItems.filter((item) => item.orderId === order.orderId)
      );
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchOrderItems();
  }, [order.orderId]);

  const totalAmount = orderItems.reduce(
    (acc, item) => acc + item.quantity * item.itemPrice, // Assuming each order item has itemPrice
    0
  );

  if (loading) {
    return (
      <div className="p-4 mb-4 bg-white rounded-lg shadow-md text-center">
        <div className="text-primary">Loading Order Details...</div>
      </div>
    );
  }

  if (error) {
    return (
      <div className="p-4 mb-4 bg-white rounded-lg shadow-md text-center text-red-500">
        {error}
      </div>
    );
  }

  return (
    <div className="p-4 mb-4 bg-white rounded-lg shadow-md flex justify-between items-start">
      <div className="flex-1">
        <h3 className="text-xl font-semibold text-primary">
          Order #{order.orderId}
        </h3>
        <div className="text-sm text-secondary">
          <p>{new Date(order.orderDateTime).toLocaleString()}</p>
        </div>

        <div className="mt-4 space-y-2">
          {orderItems.map((item) => (
            <div
              key={item.orderItemId}
              className="flex justify-between text-primary"
            >
              <span>
                {item.itemName} (x{item.quantity})
              </span>
              <span>${(item.itemPrice * item.quantity).toFixed(2)}</span>
            </div>
          ))}
        </div>

        <div className="mt-4 flex justify-between text-xl font-semibold text-primary">
          <span>Total</span>
          <span>${totalAmount.toFixed(2)}</span>
        </div>
      </div>

      <div className="flex">
        <div
          className={`text-center p-2 rounded-md ${
            order.status === "PLACED"
              ? "bg-yellow-100 text-yellow-500"
              : order.status === "PREPARING"
              ? "bg-orange-100 text-orange-500"
              : "bg-green-100 text-green-500"
          }`}
        >
          {order.status}
        </div>
      </div>
    </div>
  );
};

export default UserOrderCard;
