import React, { useState, useEffect } from "react";
import { FaSearch } from "react-icons/fa";

const API_URL = "http://localhost:8080/order";

const fetchOrders = async (setOrders, setSortedOrders) => {
  try {
    const response = await fetch(API_URL);
    const data = await response.json();

    const transformedOrders = data.map((order) => ({
      orderId: `ORD${order.orderId}`,
      amount: `₹${order.orderItemList.reduce(
        (total, item) => total + parseFloat(item.items.itemPrice) * item.quantity,
        0
      ).toFixed(2)}`,
      date: order.orderDateTime.split("T")[0], // Extract YYYY-MM-DD
      items: order.orderItemList.map((item) => item.items.itemName),
    }));

    setOrders(transformedOrders);
    setSortedOrders(transformedOrders);
  } catch (error) {
    console.error("Error fetching orders:", error);
  }
};

const calculateTotal = (filteredOrders) => {
  return filteredOrders.reduce(
    (total, order) => total + parseFloat(order.amount.replace("₹", "")),
    0
  ).toFixed(2);
};

const countItemsSold = (filteredOrders) => {
  const itemCounts = {};
  filteredOrders.forEach((order) => {
    order.items.forEach((item) => {
      itemCounts[item] = (itemCounts[item] || 0) + 1;
    });
  });
  return itemCounts;
};

const AllOrders = () => {
  const [orders, setOrders] = useState([]);
  const [sortedOrders, setSortedOrders] = useState([]);
  const [sortType, setSortType] = useState("");
  const [selectedDate, setSelectedDate] = useState("");

  useEffect(() => {
    fetchOrders(setOrders, setSortedOrders);
  }, []);

  const sortOrders = (type) => {
    let sorted = [...sortedOrders];
    switch (type) {
      case "date-asc":
        sorted.sort((a, b) => new Date(a.date) - new Date(b.date));
        break;
      case "date-desc":
        sorted.sort((a, b) => new Date(b.date) - new Date(a.date));
        break;
      case "price-asc":
        sorted.sort(
          (a, b) => parseFloat(a.amount.replace("₹", "")) - parseFloat(b.amount.replace("₹", ""))
        );
        break;
      case "price-desc":
        sorted.sort(
          (a, b) => parseFloat(b.amount.replace("₹", "")) - parseFloat(a.amount.replace("₹", ""))
        );
        break;
      default:
        sorted = orders;
    }
    setSortedOrders(sorted);
  };

  const filterOrdersByDate = () => {
    if (!selectedDate) {
      setSortedOrders(orders);
      return;
    }
    const filteredOrders = orders.filter((order) => order.date === selectedDate);
    setSortedOrders(filteredOrders);
  };

  const resetFilters = () => {
    setSortedOrders(orders);
    setSelectedDate("");
  };

  const itemCounts = countItemsSold(sortedOrders);

  return (
    <>
      <section className="pt-20 px-6 bg-base">
        <h2 className="text-4xl font-bold text-center text-primary mb-12">
          All Orders
        </h2>
      </section>
      <section>
        <div className="grid grid-cols-3 gap-4">
          <div className="col-span-2">
            <div className="flex items-center space-x-2 p-4">
              <input
                type="date"
                name="date"
                id="date"
                className="p-2 border rounded-md shadow-sm"
                value={selectedDate}
                onChange={(e) => setSelectedDate(e.target.value)}
              />
              <button
                className="px-2 py-1 border rounded-md bg-blue-500 text-white"
                onClick={filterOrdersByDate}
              >
                <FaSearch className="inline mr-1" /> Search
              </button>
              <button
                className="px-2 py-1 border rounded-md bg-gray-300"
                onClick={resetFilters}
              >
                All Dates
              </button>
            </div>
            <div className="p-4 space-y-4">
              {sortedOrders.length > 0 ? (
                sortedOrders.map((order) => (
                  <div
                    key={order.orderId}
                    className="w-full bg-white shadow-lg rounded-lg p-4 border"
                  >
                    <div className="flex justify-between">
                      <span className="font-semibold">
                        OrderId: {order.orderId}
                      </span>
                      <span className="font-semibold">Amount: {order.amount}</span>
                    </div>
                    <p className="text-gray-600">Date: {order.date}</p>
                    <ul className="list-disc list-inside text-gray-700">
                      {order.items.length > 0 ? (
                        order.items.map((item, index) => <li key={index}>{item}</li>)
                      ) : (
                        <li>No items in this order</li>
                      )}
                    </ul>
                  </div>
                ))
              ) : (
                <p className="text-center text-gray-600">No orders found for selected date.</p>
              )}
            </div>
          </div>
          <div className="">
            <div className="pt-4 pl-4">
              <select
                className="border rounded-md shadow-sm mb-4"
                onChange={(e) => {
                  setSortType(e.target.value);
                  sortOrders(e.target.value);
                }}
                value={sortType}
              >
                <option value="">Sort Orders</option>
                <option value="date-asc">Sort by Date Asc</option>
                <option value="date-desc">Sort by Date Desc</option>
                <option value="price-asc">Sort by Price Asc</option>
                <option value="price-desc">Sort by Price Desc</option>
              </select>
            </div>
            <div className="pl-4 space-y-4">
              <div className="h-40 bg-white shadow-lg rounded-lg p-4 border flex items-center justify-center">
                <h2 className="text-xl font-semibold">
                  Total Balance: ₹{calculateTotal(sortedOrders)}
                </h2>
              </div>
              <div className="w-full bg-white shadow-lg rounded-lg p-4 border">
                <h3 className="text-lg font-semibold mb-2">Items Sold:</h3>
                <ul className="space-y-1">
                  {Object.entries(itemCounts).map(([item, count]) => (
                    <li key={item} className="text-gray-700">
                      {item} <span className="font-semibold">x {count}</span>
                    </li>
                  ))}
                </ul>
              </div>
            </div>
          </div>
        </div>
      </section>
    </>
  );
};

export default AllOrders;
