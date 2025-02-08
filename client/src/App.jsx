import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Signup from "./pages/Signup";
import Contact from "./pages/Contact";
import Menu from "./pages/Menu";
import Cart from "./pages/Cart";
import Payment from "./pages/Payment";
import OrderConfirmation from "./pages/OrderConfirmation";
import UserOrders from "./pages/UserOrders";
import CurrentOrders from "./pages/CurrentOrders";
import Admin from "./pages/Admin";
import AllOrders from "./pages/AllOrders.jsx";
import Error404 from "./pages/Error404";

const App = () => {
  return (
    <>
      <Router>
        <div className="flex flex-col min-h-screen text-primary bg-base">
          <Navbar />
          <div className="flex-grow">
            <Routes>
              <Route
                path="/"
                element={
                  <ProtectedRoute allowedRoles={["USER"]}>
                    <Home />
                  </ProtectedRoute>
                }
              />
              <Route path="/login" element={<Login />} />
              <Route path="/signup" element={<Signup />} />
              <Route
                path="/contact"
                element={
                  <ProtectedRoute allowedRoles={["USER"]}>
                    <Contact />
                  </ProtectedRoute>
                }
              />
              <Route
                path="/menu"
                element={
                  <ProtectedRoute allowedRoles={["USER"]}>
                    <Menu />
                  </ProtectedRoute>
                }
              />
              <Route
                path="/cart"
                element={
                  <ProtectedRoute allowedRoles={["USER"]}>
                    <Cart />
                  </ProtectedRoute>
                }
              />
              <Route
                path="/payment"
                element={
                  <ProtectedRoute allowedRoles={["USER"]}>
                    <Payment />
                  </ProtectedRoute>
                }
              />
              <Route
                path="/order-confirmation"
                element={
                  <ProtectedRoute allowedRoles={["USER"]}>
                    <OrderConfirmation />
                  </ProtectedRoute>
                }
              />
              <Route
                path="/user-orders"
                element={
                  <ProtectedRoute allowedRoles={["USER"]}>
                    <UserOrders />
                  </ProtectedRoute>
                }
              />
              <Route
                path="/current-orders"
                element={
                  <ProtectedRoute allowedRoles={["STAFF"]}>
                    <CurrentOrders />
                  </ProtectedRoute>
                }
              />
              <Route
                path="/admin"
                element={
                  <ProtectedRoute allowedRoles={["ADMIN"]}>
                    <Admin />
                  </ProtectedRoute>
                }
              />
              <Route
                path="/all-orders"
                element={
                  <ProtectedRoute allowedRoles={["ADMIN"]}>
                    <AllOrders />
                  </ProtectedRoute>
                }
              />
              <Route path="*" element={<Error404 />} />
            </Routes>
          </div>
          <Footer />
        </div>
      </Router>
    </>
  );
};

export default App;
