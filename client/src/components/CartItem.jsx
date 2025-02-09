import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { updateQuantity, removeItemFromCart } from "../redux/cartSlice";

const CartItem = ({ item }) => {
  const dispatch = useDispatch();

  const handleIncrement = () => {
    dispatch(
      updateQuantity({ itemId: item.itemId, quantity: item.quantity + 1 })
    );
  };

  const handleDecrement = () => {
    if (item.quantity > 1) {
      dispatch(
        updateQuantity({ itemId: item.itemId, quantity: item.quantity - 1 })
      );
    } else {
      dispatch(removeItemFromCart({ itemId: item.itemId }));
    }
  };

  return (
    <div className="bg-white shadow-md rounded-lg p-4 mb-4">
      <div className="flex justify-between items-center">
        <div className="flex items-center gap-4">
          <img
            src={item.itemImageUrl}
            alt={item.itemName}
            className="w-16 h-16 object-cover rounded"
          />
          <div>
            <h4 className="font-semibold text-lg text-primary">
              {item.itemName}
            </h4>
            <p className="text-base text-secondary hidden md:block">
              {item.itemDescription}
            </p>
          </div>
        </div>
        <div className="flex md:gap-20 gap-2">
          <div className="flex items-center gap-2">
            <button
              onClick={handleDecrement}
              className="md:px-4 md:py-2 px-3 py-1 text-white bg-secondary rounded-full hover:bg-primary"
            >
              -
            </button>
            <span className="text-lg text-primary">{item.quantity}</span>
            <button
              onClick={handleIncrement}
              className="md:px-4 md:py-2 px-3 py-1 text-white bg-secondary rounded-full hover:bg-primary"
            >
              +
            </button>
          </div>
          <div className="text-lg text-primary font-semibold">
            Rs.{(item.itemPrice * item.quantity).toFixed(2)}
          </div>
        </div>
      </div>
    </div>
  );
};

export default CartItem;
