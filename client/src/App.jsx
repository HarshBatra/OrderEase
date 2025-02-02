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
import OrderConfirmation from "./pages/OrderConfirmation";
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
              <Route path="/" element={<Home />} />
              <Route path="/login" element={<Login />} />
              <Route path="/signup" element={<Signup />} />
              <Route path="/contact" element={<Contact />} />
              <Route path="/menu" element={<Menu />} />
              <Route path="/cart" element={<Cart />} />
              <Route
                path="/order-confirmation"
                element={<OrderConfirmation />}
              />
              <Route path="/current-orders" element={<CurrentOrders />} />
              <Route path="/admin" element={<Admin />} />
              <Route path="/all-orders" element={<AllOrders />} />
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
