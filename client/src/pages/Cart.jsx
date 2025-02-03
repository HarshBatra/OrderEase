import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router-dom";
import CartItem from "../components/CartItem";

const Cart = () => {
  const dispatch = useDispatch();
  const cartItems = useSelector((state) => state.cart.cartItems);

  const totalAmount = cartItems.reduce(
    (acc, item) => acc + item.itemPrice * item.quantity,
    0
  );

  return (
    <div className="container mx-auto p-4">
      <h1 className="text-3xl font-bold text-center text-primary mb-6">
        Your Cart
      </h1>
      <div className="space-y-4">
        {cartItems.length === 0 ? (
          <p className="text-center text-secondary">Your cart is empty</p>
        ) : (
          cartItems.map((item) => <CartItem key={item.itemId} item={item} />)
        )}
      </div>

      <div className="mt-6 border-t-2 pt-4">
        <div className="flex justify-between items-center text-lg text-primary">
          <span>Total Amount</span>
          <span className="font-semibold">Rs.{totalAmount.toFixed(2)}</span>
        </div>
        <div className="mx-auto w-fit mt-4 py-2 px-8 text-center text-white bg-primary rounded-full hover:bg-secondary">
          <Link to="/payment" className="py-2 px-8">
            Proceed to Payment
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Cart;
