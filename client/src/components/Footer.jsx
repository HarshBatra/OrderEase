import React from "react";
import { Link } from "react-router-dom";

const Footer = () => {
  return (
    <footer className="bg-primary text-base py-6 px-4">
      <div className="container mx-auto flex flex-col items-center md:flex-row justify-between space-y-6 md:space-y-0">
        <div className="flex items-center space-x-3">
          <p className="text-lg font-semibold">OrderEase</p>
        </div>

        <div className="flex space-x-6">
          <Link to="/" className="hover:text-white text-secondary">
            Home
          </Link>
          <Link to="login" className="hover:text-white text-secondary">
            Login
          </Link>
          <Link to="menu" className="hover:text-white text-secondary">
            Menu
          </Link>
          <Link to="contact" className="hover:text-white text-secondary">
            Contact
          </Link>
        </div>

        <div className="flex items-center">
          <span className="mr-2 text-sm text-secondary">Give us a ⭐ on </span>
          <a
            href="https://github.com/HarshBatra/OrderEase"
            target="_blank"
            rel="noopener noreferrer"
            className="hover:text-white text-secondary text-lg drop-shadow-lg"
          >
            GitHub
          </a>
        </div>
      </div>

      {/* Made with ❤️ */}
      <div className="text-center mt-6 text-sm">
        <p>Made with ❤️</p>
      </div>
    </footer>
  );
};

export default Footer;
