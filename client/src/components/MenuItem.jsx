import React from "react";
import { useDispatch } from "react-redux";
import { addItemToCart, updateQuantity } from "../redux/cartSlice";

const MenuItem = ({ item, quantity }) => {
  const dispatch = useDispatch();

  const handleAddToCart = () => {
    dispatch(addItemToCart(item));
  };

  const handleIncrease = () => {
    dispatch(updateQuantity({ itemId: item.itemId, quantity: quantity + 1 }));
  };

  const handleDecrease = () => {
    if (quantity > 0) {
      dispatch(updateQuantity({ itemId: item.itemId, quantity: quantity - 1 }));
    }
  };

  const circleColor = item.itemType === "Veg" ? "bg-green-500" : "bg-red-500";

  return (
    <div className="flex bg-white p-4 rounded-lg shadow-lg md:my-4 my-2 relative">
      <div
        className={`w-4 h-4 rounded-full absolute top-2 right-2 ${circleColor}`}
      />

      <img
        src={item.itemImageUrl}
        alt={item.itemImage}
        className="w-32 h-32 object-cover rounded-md mr-4"
      />

      <div className="flex-1">
        <h3 className="text-lg font-semibold text-primary">{item.itemName}</h3>
        <p className="text-sm text-secondary">{item.itemDescription}</p>
        <div className="flex justify-between items-center mt-2">
          <span className="text-xl text-primary font-bold">
            Rs.{item.itemPrice}
          </span>
          <div className="flex items-center space-x-2">
            {quantity === 0 ? (
              <button
                onClick={handleAddToCart}
                className="px-4 py-2 bg-primary text-white rounded-md"
              >
                Add to Cart
              </button>
            ) : (
              <div className="flex items-center space-x-2">
                <button
                  onClick={handleDecrease}
                  className="px-2 py-1 bg-secondary text-white rounded-md"
                >
                  -
                </button>
                <span>{quantity}</span>
                <button
                  onClick={handleIncrease}
                  className="px-2 py-1 bg-secondary text-white rounded-md"
                >
                  +
                </button>
              </div>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};

export default MenuItem;
