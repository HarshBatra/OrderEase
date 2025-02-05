import React from 'react';
import { RiDeleteBin6Line } from "react-icons/ri";
import { MdModeEdit } from "react-icons/md";
import { useNavigate } from "react-router-dom";

function MenuCard({ ele }) {
    const navigate = useNavigate();

    const handleEdit = () => {
        navigate("/admin/edit", { state: ele });
    };

    return (
        <div className="ml-4 bg-white mr-3 md:p-4 mt-3 items-center border-opacity-30 rounded-lg shadow-lg grid grid-cols-6 gap-1">
            <div className='md:p-2 '>
                <img className='object-cover rounded max-h-36 w-20' src={ele.itemImageUrl} alt={ele.itemDescription} />
            </div>
            <div className='col-span-3'>
                <p className='md:p-1 m-1 font-semibold text-lg md:text-xl'>{ele.itemName}</p>
                <p className='text-sm m-1 md:text-lg'>{ele.itemDescription}</p>
            </div>
            <div className='m-3 md:p-4'>
                ${ele.itemPrice}
            </div>
            <div className='flex items-center justify-center'>
                <button>
                    <RiDeleteBin6Line className='ml-3' />
                </button>
                <button onClick={handleEdit}>
                    <MdModeEdit className='mr-1 md:ml-5' />
                </button>
            </div>
        </div>
    );
}

export default MenuCard;