import React, { useEffect, useState } from "react";
import MenuItem from "../components/MenuItem";
import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router";

const Menu = () => {
  const dispatch = useDispatch();
  const cartItems = useSelector((state) => state.cart.cartItems);
  const [menuItems, setMenuItems] = useState([]);
  const [filter, setFilter] = useState("all");
  const [sort, setSort] = useState("lowToHigh");

  useEffect(() => {
    const fetchMenuItems = async () => {
      const token = localStorage.getItem("token");

      const response = await fetch(import.meta.env.VITE_API_URL + "/menu/isAvailable", {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
      });
      const data = await response.json();
      setMenuItems(data);
    };
    fetchMenuItems();
  }, []);

  const filteredItems = menuItems.filter(
    (item) => filter === "all" || item.itemType === filter
  );

  const sortedItems = filteredItems.sort((a, b) => {
    if (sort === "lowToHigh") return a.itemPrice - b.itemPrice;
    if (sort === "highToLow") return b.itemPrice - a.itemPrice;
    return 0;
  });

  return (
    <div className="container mx-auto p-4">
      <div className="flex justify-between items-center mb-4">
        <div className="flex gap-2">
          <button
            onClick={() => setFilter("all")}
            className="md:px-4 px-2 md:py-2 py-1 text-primary bg-secondary rounded-full focus:bg-primary focus:text-secondary"
          >
            All
          </button>
          <button
            onClick={() => setFilter("Veg")}
            className="md:px-4 px-2 md:py-2 py-1 text-primary bg-secondary rounded-full focus:bg-primary focus:text-secondary"
          >
            Veg
          </button>
          <button
            onClick={() => setFilter("Non-Veg")}
            className="md:px-4 px-2 md:py-2 py-1 text-primary bg-secondary rounded-full focus:bg-primary focus:text-secondary"
          >
            Non-Veg
          </button>
        </div>
        <div>
          <select
            value={sort}
            onChange={(e) => setSort(e.target.value)}
            className="px-4 py-2 text-primary bg-white border border-secondary rounded-md"
          >
            <option value="lowToHigh">Price: Low to High</option>
            <option value="highToLow">Price: High to Low</option>
          </select>
        </div>
      </div>
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
        {sortedItems.map((item) => {
          const cartItem = cartItems.find(
            (cartItem) => cartItem.itemId === item.itemId
          );
          const quantity = cartItem ? cartItem.quantity : 0;

          return <MenuItem key={item.itemId} item={item} quantity={quantity} />;
        })}
      </div>
      <div
        onClick={() => setFilter("all")}
        className="px-8 py-2 my-4 w-fit cursor-pointer mx-auto text-base text-center hover:text-primary bg-primary hover:bg-secondary rounded-full"
      >
        <Link to="/cart" className="px-8 py-2">
          Proceed to Cart
        </Link>
      </div>
    </div>
  );
};

export default Menu;
