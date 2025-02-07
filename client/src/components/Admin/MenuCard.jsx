import React, { useState } from "react";
import { RiDeleteBin6Line } from "react-icons/ri";
import { MdModeEdit } from "react-icons/md";
import EditModal from "./EditModal";

function MenuCard({ ele }) {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const openModal = () => setIsModalOpen(true);
  const closeModal = () => setIsModalOpen(false);

  return (
    <div className="ml-4 bg-white mr-3 md:p-4 mt-3 items-center border-opacity-30 rounded-lg shadow-lg grid grid-cols-6 gap-1">
      <div className="md:p-2 ">
        <img
          className="md:w-20 md:h-20 h-16 w-16 object-cover rounded-md p-1"
          src={ele.itemImageUrl}
          alt={ele.itemDescription}
        />
      </div>
      <div className="col-span-3">
        <p className="md:p-1 m-1 font-semibold md:text-xl">{ele.itemName}</p>
        <p className="text-xs text-secondary m-1 md:text-lg">
          {ele.itemDescription}
        </p>
      </div>
      <div className="m-3 md:p-4">Rs.{ele.itemPrice}</div>
      <div className="flex items-center justify-center">
        <button>
          <RiDeleteBin6Line className="ml-3" />
        </button>
        <button onClick={openModal}>
          <MdModeEdit className="mr-1 md:ml-5" />
        </button>
      </div>
      {isModalOpen && <EditModal closeModal={closeModal} ele={ele} />}
    </div>
  );
}

export default MenuCard;
