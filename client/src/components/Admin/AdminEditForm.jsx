import React, { useState } from 'react';

function AdminEditForm({ ele }) {
  // Use optional chaining and default values to ensure defined values
  const initialFormData = {
    itemName: ele?.itemName || '',
    itemDescription: ele?.itemDescription || '',
    itemImageUrl: ele?.itemImageUrl || '',
    itemPrice: ele?.itemPrice || '',
    category: ele?.category || '', // You might set a default like 'veg' if appropriate
    itemIsAvailable: ele?.itemIsAvailable ?? false, // Note: using itemIsAvailable to match the input name
  };

  const [formData, setFormData] = useState(initialFormData);

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: type === 'checkbox' ? checked : value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const token = localStorage.getItem("token");
      console.log("Submitting Data:", formData); // Debugging

      const response = await fetch(`${import.meta.env.VITE_API_URL}/admin/menu/${ele.itemId}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
          Authorization: `Bearer ${token}`
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        const updatedItem = await response.json();
        console.log("Response:", updatedItem); // Debugging
      } else {
        const errorText = await response.text();
        console.error('Failed to update item:', errorText);
      }
    } catch (error) {
      console.error('Error updating item:', error);
    }
  };

  return (
    <div className="w-full">
      <h1 className="text-3xl mt-3 font-bold mb-5 text-center">Edit Menu Item</h1>
      <div className="md:w-full border-2 border-secondary border-opacity-30 rounded-lg shadow-lg">
        <form className="w-full bg-white p-5" onSubmit={handleSubmit}>
          <div className="mb-4">
            <label className="block text-xl font-medium mb-2" htmlFor="mname">Item Name</label>
            <input
              className="w-full p-2 border rounded-lg"
              type="text"
              name="itemName"
              id="mname"
              value={formData.itemName}
              onChange={handleChange}
            />
          </div>
          <div className="mb-4">
            <label className="block text-xl font-medium mb-2" htmlFor="desc">Item Description</label>
            <input
              className="w-full p-2 border rounded-lg"
              type="text"
              name="itemDescription"
              id="desc"
              value={formData.itemDescription}
              onChange={handleChange}
            />
          </div>
          <div className="mb-4">
            <label className="block text-xl font-medium mb-2" htmlFor="image">Image URL</label>
            <input
              className="w-full p-2 border rounded-lg"
              type="text"
              name="itemImageUrl"
              id="image"
              value={formData.itemImageUrl}
              onChange={handleChange}
            />
          </div>
          <div className="mb-4">
            <label className="block text-xl font-medium mb-2" htmlFor="usp">Price</label>
            <input
              className="w-full p-2 border rounded-lg"
              type="number"
              name="itemPrice"
              id="usp"
              value={formData.itemPrice}
              onChange={handleChange}
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
                  checked={formData.category === 'veg'}
                  onChange={handleChange}
                />
                Veg
              </label>
              <label className="flex items-center">
                <input
                  className="mr-2"
                  type="radio"
                  name="category"
                  value="nonveg"
                  checked={formData.category === 'nonveg'}
                  onChange={handleChange}
                />
                Non-Veg
              </label>
            </div>
          </div>

          <div className="flex items-center justify-center mt-4 mb-4">
            <span className="text-xs font-medium mx-2">Item Available</span>
            <label htmlFor="toggle2" className="relative inline-flex items-center cursor-pointer">
              <input
                type="checkbox"
                id="toggle2"
                name="itemIsAvailable"  // matches state key
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
              className="w-full bg-primary text-white py-2 px-4 rounded-lg hover:bg-primary-dark transition"
            >
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default AdminEditForm;
