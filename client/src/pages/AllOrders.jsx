import React, { useState } from "react";
import { FaSearch } from "react-icons/fa";

const orders = [
  {
    orderId: "ORD12345",
    amount: "₹500",
    date: "2025-02-06",
    items: ["Burger", "Fries", "Coke"],
  },
  {
    orderId: "ORD67890",
    amount: "₹350",
    date: "2025-02-05",
    items: ["Pizza", "Garlic Bread", "Burger"],
  },
  {
    orderId: "ORD54321",
    amount: "₹750",
    date: "2025-02-04",
    items: ["Pasta", "Salad", "Lemonade", "Fries", "Burger"],
  },
  {
    orderId: "ORD98765",
    amount: "₹600",
    date: "2025-02-03",
    items: ["Burger", "Fries", "Pizza"],
  },
];

const calculateTotal = (filteredOrders) => {
  return filteredOrders.reduce(
    (total, order) => total + parseInt(order.amount.replace("₹", ""), 10),
    0
  );
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
  const [sortedOrders, setSortedOrders] = useState(orders);
  const [sortType, setSortType] = useState("");
  const [selectedDate, setSelectedDate] = useState("");

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
          (a, b) =>
            parseInt(a.amount.replace("₹", ""), 10) -
            parseInt(b.amount.replace("₹", ""), 10)
        );
        break;
      case "price-desc":
        sorted.sort(
          (a, b) =>
            parseInt(b.amount.replace("₹", ""), 10) -
            parseInt(a.amount.replace("₹", ""), 10)
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
                      {order.items.map((item, index) => (
                        <li key={index}>{item}</li>
                      ))}
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