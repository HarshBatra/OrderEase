import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  cartItems: [], // Array to store items in the cart
};

const cartSlice = createSlice({
  name: "cart",
  initialState,
  reducers: {
    // Add item to cart
    addItemToCart(state, action) {
      const existingItem = state.cartItems.find(
        (item) => item.itemId === action.payload.itemId
      );
      if (existingItem) {
        existingItem.quantity += 1; // Increment quantity if item exists
      } else {
        state.cartItems.push({ ...action.payload, quantity: 1 }); // Add new item with quantity 1
      }
    },

    // Remove item from cart
    removeItemFromCart(state, action) {
      state.cartItems = state.cartItems.filter(
        (item) => item.itemId !== action.payload.itemId
      );
    },

    // Update item quantity
    updateQuantity(state, action) {
      const { itemId, quantity } = action.payload;
      const item = state.cartItems.find((item) => item.itemId === itemId);

      if (item) {
        if (quantity === 0) {
          // Remove item from cart if quantity is 0
          state.cartItems = state.cartItems.filter(
            (item) => item.itemId !== itemId
          );
        } else {
          // Otherwise, update the quantity
          item.quantity = quantity;
        }
      }
    },

    // Clear all items in the cart
    clearCart(state) {
      state.cartItems = []; // Reset the cartItems array to an empty array
    },
  },
});

export const { addItemToCart, removeItemFromCart, updateQuantity, clearCart } =
  cartSlice.actions;
export default cartSlice.reducer;
