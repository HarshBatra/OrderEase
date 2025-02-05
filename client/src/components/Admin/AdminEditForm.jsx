import React from 'react';

function AdminEditForm({ele}) {
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
                            defaultValue={ele.itemName}
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
                            defaultValue={ele.itemDescription}
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
                            defaultValue={ele.itemImageUrl}
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
                            defaultValue={ele.itemPrice}
                        />
                    </div>
                    <div className="flex items-center justify-center mt-4 mb-4">
                        <span className="text-xs font-medium mx-2">Item Available</span>
                        <label htmlFor="toggle" className="flex items-center cursor-pointer">
                            <input type="checkbox" id="toggle" name="isAvailable" className="sr-only peer" />
                            <div className="block bg-primary w-16 h-7 p-0.5 rounded-full relative peer-checked:bg-green-500">
                                <div className="absolute bg-white w-6 h-6 rounded-full transition-all duration-300 left-1 top-0.5 peer-checked:left-8"></div>
                            </div>
                        </label>
                    </div>
                    <div className="text-center">
                        <button
                            type="submit"
                            className="w-full bg-primary text-white py-2 px-4 rounded-lg hover:bg-primary-dark transition">
                            Submit
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default AdminEditForm;