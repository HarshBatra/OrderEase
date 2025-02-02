import { useState } from "react";
import { Link } from "react-router";

const Navbar = () => {
  const [isOpen, setIsOpen] = useState(false);

  const toggleMenu = () => setIsOpen(!isOpen);
  const closeMenu = () => setIsOpen(false);

  return (
    <nav className="bg-primary shadow-md w-full">
      <div className="max-w-screen-xl mx-auto px-4 py-3 flex items-center justify-between">
        <div className="flex items-center">
          <h1 className="text-lg font-bold text-base">OrderEase</h1>
        </div>

        <div className="hidden md:flex space-x-6">
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

        <button onClick={toggleMenu} className="md:hidden focus:outline-none">
          <svg
            fill="none"
            stroke="#FCFFF7"
            viewBox="0 0 24 24"
            strokeWidth="2"
            className="h-6 w-6"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              d="M4 6h16M4 12h16M4 18h16"
            />
          </svg>
        </button>
      </div>

      <div
        className={`md:hidden bg-primary px-4 space-y-4 transition-all duration-300 ease-in-out ${
          isOpen ? "max-h-screen py-3" : "max-h-0 overflow-hidden"
        }`}
      >
        <Link
          to="/"
          className="hover:text-white text-secondary block"
          onClick={closeMenu}
        >
          Home
        </Link>
        <Link
          to="login"
          className="hover:text-white text-secondary block"
          onClick={closeMenu}
        >
          Login
        </Link>
        <Link
          to="menu"
          className="hover:text-white text-secondary block"
          onClick={closeMenu}
        >
          Menu
        </Link>
        <Link
          to="contact"
          className="hover:text-white text-secondary block"
          onClick={closeMenu}
        >
          Contact
        </Link>
      </div>
    </nav>
  );
};

export default Navbar;
