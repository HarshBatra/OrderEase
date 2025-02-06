import React from "react";
import { Link } from "react-router-dom";

const OrderConfirmation = () => {
  return (
    <div className="flex flex-col justify-center mx-auto h-[70vh] p-4 text-center">
      <p className="text-8xl ml-4 mb-4">🎉</p>
      <h1 className="text-4xl font-bold text-primary mb-6">Order Confirmed</h1>
      <p className="text-lg text-secondary mb-6">
        Your payment was successful, and your order is being processed.
      </p>
      <div className="flex gap-2 justify-center">
        <Link to="/menu">
          <button className="py-3 px-6 text-primary bg-base rounded-full hover:bg-primary hover:text-base border-2 border-primary">
            Go Back to Menu
          </button>
        </Link>
        <Link to="/user-orders">
          <button className="py-3 px-6 text-white border-primary bg-primary rounded-full hover:bg-secondary">
            View Your Orders
          </button>
        </Link>
      </div>
    </div>
  );
};

export default OrderConfirmation;
