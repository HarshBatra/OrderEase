import React, { useState } from "react";

const CurrentOrdersC = ({ ele, removeOrderFromUI }) => {
  const [editedOrder, setEditedOrder] = useState(ele);

  const orderStatusHandler = async (id) => {
    const updatedOrder = { ...editedOrder, orderStatus: id };
    setEditedOrder(updatedOrder);

    try {
      const response = await fetch(import.meta.env.VITE_API_URL + `/order/${ele.orderId}`, {
        method: "PUT",
        body: JSON.stringify(updatedOrder),
        headers: {
          "Content-Type": "application/json",
        },
      });

      if (response.ok) {
        if (id === "DONE") {
          removeOrderFromUI(ele.orderId);
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
          <p className="font-semibold">OrderId: #{ele.orderId}</p>
          <ol className="mt-3 list-decimal">
            <div className="flex space-x-4">
              <div className="font-medium">
                <ul>
                  {ele.orderItemList.map((item, index) => (
                    <li key={index}>{item.items.itemName}</li>
                  ))}
                </ul>
              </div>
              <div>
                <ul>
                  {ele.orderItemList.map((item, index) => (
                    <li key={index}>{item.quantity}</li>
                  ))}
                </ul>
              </div>
            </div>
          </ol>
          <div className="mt-5">
            <span className="font-semibold">Total Amount: </span>
            <span className="ml-2">
              ${ele.orderItemList.reduce((total, orderItem) => total + parseFloat(orderItem.items.itemPrice) * orderItem.quantity, 0)}
            </span>
          </div>
        </div>
        <div className="flex flex-col md:mt-0 mt-6">
          <p className="font-semibold">Status:</p>
          <form className="mt-2">
            <input className="m-1" type="radio" id="PLACED" name="orderStatus" defaultChecked={ele.orderStatus === "PLACED"} onInput={(e) => orderStatusHandler(e.target.id)} />
            <label htmlFor="PLACED">Placed</label>

            <input className="m-1" type="radio" id="PREPARING" name="orderStatus" defaultChecked={ele.orderStatus === "PREPARING"} onInput={(e) => orderStatusHandler(e.target.id)} />
            <label htmlFor="PREPARING">Preparing</label>

            <input className="m-1" type="radio" id="READY" name="orderStatus" defaultChecked={ele.orderStatus === "READY"} onInput={(e) => orderStatusHandler(e.target.id)} />
            <label htmlFor="READY">Ready</label>
          </form>
          <div className="mt-3">
            <button id="DONE" className="bg-primary text-white p-2 border rounded-lg font-medium" onClick={(e) => orderStatusHandler(e.target.id)}>
              Done
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CurrentOrdersC;