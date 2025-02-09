import React, { useState } from "react";
import AdminEditForm from "./AdminEditForm";

function EditModal({closeModal,ele}) {
  return (
    <div className="w-full fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center">
      <div className="bg-white rounded-lg m-3 shadow-lg p-7 w-full md:w-1/3">
        <AdminEditForm ele={ele}/>
        <button
          onClick={closeModal}
          className="bg-primary text-white p-2 mt-4 rounded-lg hover:bg-red-600 transition"
        >
          Close
        </button>
      </div>
    </div>
  )
}

export default EditModal;