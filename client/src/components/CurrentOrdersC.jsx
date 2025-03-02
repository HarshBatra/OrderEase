import React, { useState } from "react";

const CurrentOrdersC = ({ ele, removeOrderFromUI }) => {
  const [editedOrder, setEditedOrder] = useState(ele);

  const orderStatusHandler = async (id) => {
    const updatedOrder = { ...editedOrder, orderStatus: id };
    
    try {
      const token = localStorage.getItem("token");
      if (!token) {
        console.error("No authentication token found.");
        return;
      }

      const response = await fetch(
        import.meta.env.VITE_API_URL + `/staff/order/${ele?.orderId}`,
        {
          method: "PUT",
          body: JSON.stringify(updatedOrder),
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`,
          },
        }
      );

      if (response.ok) {
        setEditedOrder(updatedOrder);
        if (id === "DONE") {
          removeOrderFromUI(ele?.orderId);
        }
      }
    } catch (error) {
      console.error("Error updating order status:", error);
    }
  };

  return (
    <div className="flex justify-center">
      <div className="grid md:grid-cols-2 rounded-lg bg-white shadow-lg w-full m-5 p-2 md:w-2/3 md:m-5 md:p-5">
        <div>
          <p className="font-semibold">OrderId: #{ele?.orderId ?? "N/A"}</p>
          <ol className="mt-3 list-decimal">
            <div className="flex space-x-4">
              <div className="font-medium">
                <ul>
                  {(ele?.orderItemList || []).map((item, index) => (
                    <li key={item?.items?.itemId ?? index}>
                      {item?.items?.itemName ?? "Unknown Item"}
                    </li>
                  ))}
                </ul>
              </div>
              <div>
                <ul>
                  {(ele?.orderItemList || []).map((item, index) => (
                    <li key={item?.items?.itemId ?? index}>
                      {item?.quantity ?? 0}
                    </li>
                  ))}
                </ul>
              </div>
            </div>
          </ol>
          <div className="mt-5">
            <span className="font-semibold">Total Amount: </span>
            <span className="ml-2">
              Rs.
              {(ele?.orderItemList || [])
                .reduce((total, orderItem) => {
                  const price = parseFloat(orderItem?.items?.itemPrice ?? 0);
                  const quantity = orderItem?.quantity ?? 0;
                  return total + price * quantity;
                }, 0)
                .toFixed(2)}
            </span>
          </div>
        </div>
        <div className="flex flex-col md:mt-0 mt-6">
          <p className="font-semibold">Status:</p>
          <form className="mt-2">
            {["PLACED", "PREPARING", "READY"].map((status) => (
              <div key={status}>
                <input
                  className="m-1"
                  type="radio"
                  id={status}
                  name="orderStatus"
                  defaultChecked={ele?.orderStatus === status}
                  onChange={(e) => orderStatusHandler(e.target.id)}
                />
                <label htmlFor={status}>{status}</label>
              </div>
            ))}
          </form>
          <div className="mt-3">
            <button
              className="bg-primary text-white p-2 border rounded-lg font-medium"
              onClick={() => orderStatusHandler("DONE")}
            >
              Done
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CurrentOrdersC;
