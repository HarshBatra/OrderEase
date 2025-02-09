import React from "react";
import MenuForm from "./MenuForm";
import MenuList from "./MenuList";
import { Link } from "react-router";

export const AdminHome = () => {
  return (
    <div>
      <div className="flex items-center justify-between mt-10 mb-10">
        <div className="flex-1 flex justify-center">
          <h1 className="font-bold text-4xl">Menu Update</h1>
        </div>
        <div className="flex justify-center md:mr-10">
          <Link
            to="/all-orders"
            className="bg-primary border rounded-lg text-white p-2 mt-3 mb-5 md:mr-10"
          >
            Show All Orders
          </Link>
        </div>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 gap-2">
        <div className="p-5">
          <div className="flex md:m-5 justify-center ">
            <MenuForm />
          </div>
        </div>
        <div className="p-3">
          <div className="flex justify-center">
            <MenuList />
          </div>
        </div>
      </div>
    </div>
  );
};
