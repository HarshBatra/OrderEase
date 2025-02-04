import React, { useEffect, useState } from "react";
import UserOrderCard from "../components/UserOrderCard"; // Import UserOrderCard
import { Spinner } from "../components/Spinner"; // You can add a spinner for loading state

const UserOrders = () => {
  const [orders, setOrders] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // Dummy data for testing
  const dummyOrders = [
    {
      orderId: "ORD123456",
      orderDateTime: "2025-02-04T10:00:00Z",
      status: "PLACED",
      userId: "USER1",
    },
    {
      orderId: "ORD1234567",
      orderDateTime: "2025-02-03T14:30:00Z",
      status: "PREPARING",
      userId: "USER1",
    },
    {
      orderId: "ORD12345678",
      orderDateTime: "2025-02-03T14:30:00Z",
      status: "READY",
      userId: "USER1",
    },
  ];

  const fetchOrders = async () => {
    try {
      // Commented out the real API call
      // const response = await fetch(`/order/${userId}`);
      // if (!response.ok) throw new Error("Failed to fetch orders.");
      // const data = await response.json();

      // Using dummy data for testing
      await setTimeout(() => {
        setOrders(dummyOrders);
        setLoading(false);
      }, 3000);
    } catch (err) {
      setError(err.message);
    }
  };

  useEffect(() => {
    fetchOrders();
  }, []);

  if (loading) {
    return <Spinner />;
  }

  if (error) {
    return <div className="text-center text-red-500">{error}</div>;
  }

  return (
    <div className="container mx-auto px-4 py-8 md:p-8 md:w-1/2">
      <h1 className="text-3xl font-bold text-center text-primary mb-6">
        Your Orders
      </h1>

      {loading ? (
        <Spinner />
      ) : (
        <div className="space-y-4">
          {orders.map((order) => (
            <UserOrderCard key={order.orderId} order={order} />
          ))}
        </div>
      )}
    </div>
  );
};

export default UserOrders;
