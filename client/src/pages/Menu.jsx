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

  // useEffect(() => {
  //   const fetchMenuItems = async () => {
  //     const response = await fetch(import.meta.env.VITE_API_URL + "/menu");
  //     const data = await response.json();
  //     setMenuItems(data);
  //   };
  //   fetchMenuItems();
  // }, []);

  // Simulate fetching data with a timeout
  useEffect(() => {
    setTimeout(() => {
      const dummyData = [
        {
          itemId: 1,
          itemName: "Veg Burger",
          itemDescription: "A delicious vegetarian burger.",
          itemPrice: 5.99,
          itemType: "veg",
          itemIsAvailable: true,
          itemImage: "veg_burger",
          itemImageUrl:
            "https://www.foodandwine.com/thmb/DI29Houjc_ccAtFKly0BbVsusHc=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/crispy-comte-cheesburgers-FT-RECIPE0921-6166c6552b7148e8a8561f7765ddf20b.jpg",
        },
        {
          itemId: 2,
          itemName: "Chicken Wings",
          itemDescription: "Crispy and spicy chicken wings.",
          itemPrice: 7.99,
          itemType: "nonveg",
          itemIsAvailable: true,
          itemImage: "chicken_wings",
          itemImageUrl: "/assets/chicken.jpg",
        },
        {
          itemId: 3,
          itemName: "Veg Pizza",
          itemDescription: "Cheesy pizza with fresh veggies.",
          itemPrice: 8.99,
          itemType: "veg",
          itemIsAvailable: true,
          itemImage: "veg_pizza",
          itemImageUrl:
            "https://www.allrecipes.com/thmb/aefJMDXKqs42oAP71dQuYf_-Qdc=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/6776_Pizza-Dough_ddmfs_4x3_1724-fd91f26e0bd6400a9e89c6866336532b.jpg",
        },
        {
          itemId: 4,
          itemName: "Beef Steak",
          itemDescription: "Juicy beef steak grilled to perfection.",
          itemPrice: 12.99,
          itemType: "nonveg",
          itemIsAvailable: true,
          itemImage: "beef_steak",
          itemImageUrl:
            "https://img.hellofresh.com/f_auto,fl_lossy,q_auto,w_1200/hellofresh_s3/image/thyme-balsamic-beef-rump-c1ba3100.jpg",
        },
      ];

      setMenuItems(dummyData);
    }, 1000);
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
            onClick={() => setFilter("veg")}
            className="md:px-4 px-2 md:py-2 py-1 text-primary bg-secondary rounded-full focus:bg-primary focus:text-secondary"
          >
            Veg
          </button>
          <button
            onClick={() => setFilter("nonveg")}
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
