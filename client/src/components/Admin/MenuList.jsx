import React, { useEffect, useState } from "react";
import MenuCard from "./MenuCard";

function MenuList() {
  const [menuItems, setMenuItems] = useState([]);
  const [refresh, setRefresh] = useState(false); // New state for refresh

  useEffect(() => {
    const token = localStorage.getItem("token");

    const fetchMenuItems = async () => {
      const response = await fetch(
        import.meta.env.VITE_API_URL + "/admin/menu",
        {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`,
          },
        }
      );
      const data = await response.json();
      setMenuItems(data);
    };
    fetchMenuItems();
  }, [refresh]); // use refresh as dependency

  // Function to trigger refresh
  const triggerRefresh = () => setRefresh(prev => !prev);

  return (
    <div>
      <h1 className="text-3xl font-bold mb-5 text-center">Current Menu</h1>
      {menuItems.map((ele, index) => (
        <MenuCard key={index} ele={ele} triggerRefresh={triggerRefresh} />
      ))}
    </div>
  );
}

export default MenuList;
