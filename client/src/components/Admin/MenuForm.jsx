import React from 'react';

function MenuForm() {
    return (
        <div className="w-full">
            <h1 className="text-3xl font-bold mb-5 text-center">Add Menu Item</h1>
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
                        />
                    </div>

                    <div className="mb-4">
                        <label className="block text-xl font-medium mb-2">Category</label>
                        <div className="flex items-center">
                            <label className="mr-4 flex items-center">
                                <input
                                    className="mr-2"
                                    type="radio"
                                    name="category"
                                    value="veg"
                                />
                                Veg
                            </label>
                            <label className="flex items-center">
                                <input
                                    className="mr-2"
                                    type="radio"
                                    name="category"
                                    value="nonveg"
                                />
                                Non-Veg
                            </label>
                        </div>
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

export default MenuForm;