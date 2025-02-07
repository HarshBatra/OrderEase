import React, { useEffect, useState } from "react";
import MenuCard from "./MenuCard";

function MenuList() {
  const [menuItems, setMenuItems] = useState([]);

  useEffect(() => {
    const fetchMenuItems = async () => {
      const response = await fetch(import.meta.env.VITE_API_URL + "/menu");
      const data = await response.json();
      setMenuItems(data);
    };
    fetchMenuItems();
  }, []);

  return (
    <div>
      <h1 className="text-3xl font-bold mb-5 text-center ">Current Menu</h1>
      {menuItems.map((ele, index) => {
        return <MenuCard key={index} ele={ele} />;
      })}
    </div>
  );
}

export default MenuList;
