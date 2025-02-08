import React, { useEffect, useState } from "react";
import CurrentOrdersC from "../components/CurrentOrdersC";

const CurrentOrders = () => {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    fetchOrders();
  }, []);

  const fetchOrders = async () => {
    const token = localStorage.getItem("token");

    const response = await fetch(import.meta.env.VITE_API_URL + "/staff/order", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
    });
    const data = await response.json();
    setOrders(
      data.filter((order) =>
        ["PLACED", "PREPARING", "READY"].includes(order.orderStatus)
      )
    );
  };

  const removeOrderFromUI = (orderId) => {
    setOrders((prevOrders) =>
      prevOrders.filter((order) => order.orderId !== orderId)
    );
  };

  return (
    <div>
      {orders.length > 0 ? (
        orders.map((order) => (
          <CurrentOrdersC
            key={order.orderId}
            ele={order}
            removeOrderFromUI={removeOrderFromUI}
          />
        ))
      ) : (
        <p className="text-center mt-10">No current orders available.</p>
      )}
    </div>
  );
};

export default CurrentOrders;
