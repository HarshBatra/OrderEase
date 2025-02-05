import React from 'react';
import { useLocation } from 'react-router-dom';

function AdminEditForm() {
    const location = useLocation();
    const itemData = location.state || {};

    return (
        <div className="w-full">
            <h1 className="text-3xl mt-3 font-bold mb-5 text-center">Edit Menu Item</h1>
            <div className="md:w-full border-2 border-secondary border-opacity-30 rounded-lg shadow-lg">
                <form className="w-full bg-white p-5">
                    <div className="mb-4">
                        <label className="block text-xl font-medium mb-2" htmlFor="mname">Item Name</label>
                        <input
                            className="w-full p-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
                            type="text"
                            name="mname"
                            id="mname"
                            placeholder="Enter item name"
                            defaultValue={itemData.itemName}
                        />
                    </div>

                    <div className="mb-4">
                        <label className="block text-xl font-medium mb-2" htmlFor="desc">Item Description</label>
                        <input
                            className="w-full p-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
                            type="text"
                            name="desc"
                            id="desc"
                            placeholder="Enter item description"
                            defaultValue={itemData.itemDescription}
                        />
                    </div>

                    <div className="mb-4">
                        <label className="block text-xl font-medium mb-2" htmlFor="image">Image URL</label>
                        <input
                            className="w-full p-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
                            type="text"
                            name="image"
                            id="image"
                            placeholder="Enter item image url"
                            defaultValue={itemData.itemImageUrl}
                        />
                    </div>

                    <div className="mb-4">
                        <label className="block text-xl font-medium mb-2" htmlFor="usp">Price</label>
                        <input
                            className="w-full p-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
                            type="number"
                            name="usp"
                            id="usp"
                            placeholder="Enter item price"
                            defaultValue={itemData.itemPrice}
                        />
                    </div>

                    <div className="text-center">
                        <button
                            type="submit"
                            className="w-full bg-primary text-white py-2 px-4 rounded-lg hover:bg-primary-dark transition">
                            Submit
                        </button>
                    </div>
                    <div class="flex items-center justify-center w-full my-8">
                        <span class="text-xs mx-5">Toggle me!</span>
                        <label for="toggle" class="flex items-center cursor-pointer">
                            <input type="checkbox" id="toggle" name="isAvailale" class="sr-only peer"/>
                                <div class="block relative bg-blue-900 w-16 h-9 p-1 rounded-full before:absolute before:bg-blue-600 before:w-7 before:h-7 before:p-1 before:rounded-full before:transition-all before:duration-500 before:left-1 peer-checked:before:left-8 peer-checked:before:bg-white"></div>
                        </label>
                    </div>
                    <p class="text-center">PS: you can use margin left classes too (e.g. <i>"before:ml-0.5 peer-checked:before:ml-7"</i>)</p>
                    <script src="https://cdn.tailwindcss.com/"></script>
                </form>
            </div>
        </div>
    );
}

export default AdminEditForm;