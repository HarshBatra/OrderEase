import React, { useEffect, useState } from "react";
import UserOrderCard from "../components/UserOrderCard";
import { Spinner } from "../components/Spinner";

const UserOrders = () => {
  const [orders, setOrders] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const fetchOrders = async () => {
    try {
      const token = localStorage.getItem("token");
      const user = localStorage.getItem("user");

      const response = await fetch(
        import.meta.env.VITE_API_URL + `/order/user/${user.userId}```,
        {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`,
          },
        }
      );

      if (!response.ok) {
        throw new Error(`HTTP Error: ${response.status}`);
      }
      const contentType = response.headers.get("Content-Type");
      if (!contentType || !contentType.includes("application/json")) {
        throw new Error("Response is not JSON");
      }
      const data = await response.json();
      setOrders(data);
      setLoading(false);
    } catch (err) {
      setError(err.message); // Show error message
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchOrders();
  }, []);

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
