import React, { useState } from 'react';

function MenuForm() {
    const [formData, setFormData] = useState({
        itemName: "",
        itemDescription: "",
        itemImageUrl: "",
        itemImage: "",
        itemPrice: "",
        itemType: "Veg",
        itemIsAvailable: false,
    });

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: type === "checkbox" ? checked : value,
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log("Submitting Data:", formData);

        const requestData = {
            ...formData,
            itemPrice: parseFloat(formData.itemPrice),
        };

        try {
            const token = localStorage.getItem("token")
            const response = await fetch(import.meta.env.VITE_API_URL + "/admin/menu/add", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                    "Accept": "application/json",
                    Authorization : `Bearer ${token}`
                },
                body: JSON.stringify(requestData),
                mode: "cors"
            });

            if (response.ok) {
                const responseData = await response.json();
                console.log("Response:", responseData);
            } else {
                const errorData = await response.json();
                console.error("Error Response:", errorData);
            }
        } catch (error) {
            console.error("Fetch Error:", error);
        }
    };

    return (
        <div className="w-full">
            <h1 className="text-3xl font-bold mb-5 text-center">Add Menu Item</h1>
            <div className="md:w-full border-2 border-secondary border-opacity-30 rounded-lg shadow-lg">
                <form className="w-full bg-white p-5" onSubmit={handleSubmit}>
                    <div className="mb-4">
                        <label className="block text-xl font-medium mb-2" htmlFor="itemName">Item Name</label>
                        <input
                            className="w-full p-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500"
                            type="text"
                            name="itemName"
                            id="itemName"
                            placeholder="Enter item name"
                            value={formData.itemName}
                            onChange={handleChange}
                            required
                        />
                    </div>

                    <div className="mb-4">
                        <label className="block text-xl font-medium mb-2" htmlFor="itemDescription">Item Description</label>
                        <input
                            className="w-full p-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500"
                            type="text"
                            name="itemDescription"
                            id="itemDescription"
                            placeholder="Enter item description"
                            value={formData.itemDescription}
                            onChange={handleChange}
                            required
                        />
                    </div>

                    <div className="mb-4">
                        <label className="block text-xl font-medium mb-2" htmlFor="itemImageUrl">Image URL</label>
                        <input
                            className="w-full p-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500"
                            type="text"
                            name="itemImageUrl"
                            id="itemImageUrl"
                            placeholder="Enter item image url"
                            value={formData.itemImageUrl}
                            onChange={handleChange}
                        />
                    </div>

                    <div className="mb-4">
                        <label className="block text-xl font-medium mb-2" htmlFor="itemImage">Image Name</label>
                        <input
                            className="w-full p-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500"
                            type="text"
                            name="itemImage"
                            id="itemImage"
                            placeholder="Enter item image name"
                            value={formData.itemImage}
                            onChange={handleChange}
                        />
                    </div>

                    <div className="mb-4">
                        <label className="block text-xl font-medium mb-2" htmlFor="itemPrice">Price</label>
                        <input
                            className="w-full p-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500"
                            type="number"
                            name="itemPrice"
                            id="itemPrice"
                            placeholder="Enter item price"
                            value={formData.itemPrice}
                            onChange={handleChange}
                            required
                        />
                    </div>

                    <div className="mb-4">
                        <label className="block text-xl font-medium mb-2">Category</label>
                        <div className="flex items-center">
                            <label className="mr-4 flex items-center">
                                <input
                                    className="mr-2"
                                    type="radio"
                                    name="itemType"
                                    value="Veg"
                                    checked={formData.itemType === "Veg"}
                                    onChange={handleChange}
                                />
                                Veg
                            </label>
                            <label className="flex items-center">
                                <input
                                    className="mr-2"
                                    type="radio"
                                    name="itemType"
                                    value="NonVeg"
                                    checked={formData.itemType === "NonVeg"}
                                    onChange={handleChange}
                                />
                                Non-Veg
                            </label>
                        </div>
                    </div>
                    <div className="flex items-center justify-center mt-4 mb-4">
                        <span className="text-xs font-medium mx-2">Item Available</span>
                        <label htmlFor="toggle" className="relative inline-flex items-center cursor-pointer">
                            <input
                                type="checkbox"
                                id="toggle"
                                name="itemIsAvailable"
                                className="sr-only peer"
                                checked={formData.itemIsAvailable}
                                onChange={handleChange}
                            />
                            <div className="w-14 h-7 bg-gray-300 peer-focus:outline-none peer-focus:ring-2 
            peer-focus:ring-blue-500 dark:peer-focus:ring-blue-600 rounded-full peer 
            peer-checked:bg-green-500 transition-all duration-300">
                            </div>
                            <div className="absolute left-1 top-1 w-5 h-5 bg-white rounded-full transition-transform 
            duration-300 peer-checked:translate-x-7">
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

export default MenuForm;