import React, { useEffect, useState } from "react";

const UserOrderCard = ({ order }) => {
  const [orderItems, setOrderItems] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    console.log(order);
    setOrderItems(order.orderItemList);
    setLoading(false);
  }, []);

  const totalAmount = orderItems.reduce(
    (acc, item) => acc + item.quantity * item.items.itemPrice,
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
        <div className="flex justify-between items-center">
          <div className="flex flex-col">
            <h3 className="text-xl font-semibold text-primary">
              Order #{order.orderId}
            </h3>
            <div className="text-sm text-secondary">
              <p>{new Date(order.orderDateTime).toLocaleString()}</p>
            </div>
          </div>
          <div
            className={`text-center p-2 rounded-md ${
              order.orderStatus === "PLACED"
                ? "bg-yellow-100 text-yellow-500"
                : order.orderStatus === "PREPARING"
                ? "bg-orange-100 text-orange-500"
                : "bg-green-100 text-green-500"
            }`}
          >
            {order.orderStatus}
          </div>
        </div>

        <div className="mt-4 space-y-2">
          {orderItems.map((item) => (
            <div
              key={item.orderItemId}
              className="flex justify-between text-primary"
            >
              <span>
                {item.items.itemName} (x{item.quantity})
              </span>
              <span>
                Rs.{(item.items.itemPrice * item.quantity).toFixed(2)}
              </span>
            </div>
          ))}
        </div>

        <div className="mt-4 flex justify-between text-xl font-semibold text-primary">
          <span>Total</span>
          <span>Rs.{totalAmount.toFixed(2)}</span>
        </div>
      </div>
    </div>
  );
};

export default UserOrderCard;
