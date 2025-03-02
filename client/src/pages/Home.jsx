import React from "react";
import { FaCheckCircle, FaUtensils, FaTruck, FaUsers } from "react-icons/fa";
import { Link } from "react-router-dom";

function Home() {
  return (
    <div className="bg-base text-gray-900 min-h-screen">
      <section
        className="text-center py-20 bg-cover bg-center relative text-base"
        style={{ backgroundImage: "url(/assets/cafe2.jpg)" }}
      >
        <div className="absolute inset-0 bg-black opacity-40"></div>
        <h1 className="text-5xl font-bold mb-2 relative drop-shadow-lg">
          OrderEase
        </h1>
        <p className="text-xl mb-4 relative drop-shadow-lg">
          "Where Convenience Meets Deliciousness"
        </p>
        <p className="max-w-3xl mx-auto text-lg relative drop-shadow-lg">
          OrderEase is a modern canteen order management system designed to
          simplify food ordering and streamline operations. From placing orders
          to tracking status in real time, it ensures a hassle-free experience
          for customers, staff, and admins alike.
        </p>
        <button className="mt-8 py-2 px-6 bg-secondary text-base text-lg font-semibold rounded-full hover:bg-primary transition duration-300 relative">
          <Link to="/menu">Get Started</Link>
        </button>
      </section>

      <section className="py-20 px-6 bg-base">
        <h2 className="text-4xl font-bold text-center text-secondary mb-12">
          Features
        </h2>
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-12">
          <div className="flex flex-col items-center text-center">
            <div className="bg-primary text-white rounded-full p-6 mb-4 hover:scale-110 hover:transition-transform">
              <FaCheckCircle size={36} />
            </div>
            <h3 className="text-2xl font-semibold">Easy Ordering</h3>
            <p className="text-secondary mt-2">
              Place orders seamlessly with a user-friendly interface.
            </p>
          </div>

          <div className="flex flex-col items-center text-center">
            <div className="bg-primary text-white rounded-full p-6 mb-4 hover:scale-110 hover:transition-transform">
              <FaUtensils size={36} />
            </div>
            <h3 className="text-2xl font-semibold">Menu Variety</h3>
            <p className="text-secondary mt-2">
              Choose from a diverse range of tasty and healthy options.
            </p>
          </div>

          <div className="flex flex-col items-center text-center">
            <div className="bg-primary text-white rounded-full p-6 mb-4 hover:scale-110 hover:transition-transform">
              <FaTruck size={36} />
            </div>
            <h3 className="text-2xl font-semibold">Real-Time Tracking</h3>
            <p className="text-secondary mt-2">
              Track your order status in real-time from kitchen to delivery.
            </p>
          </div>

          <div className="flex flex-col items-center text-center">
            <div className="bg-primary text-white rounded-full p-6 mb-4 hover:scale-110 hover:transition-transform">
              <FaUsers size={36} />
            </div>
            <h3 className="text-2xl font-semibold text-primary">
              For Everyone
            </h3>
            <p className="text-secondary mt-2">
              Whether you're a customer, staff, or admin, the experience is
              seamless.
            </p>
          </div>
        </div>
      </section>

      <section className="py-10 px-6 text-center md:text-left items-center bg-white flex flex-col md:flex-row space-y-4">
        <img
          src="/assets/cafe.jpg"
          alt="Canteen Image"
          className="rounded-lg shadow-xl md:w-1/3 mx-auto border-white border-4 drop-shadow-xl"
        />
        <div className="flex flex-col ">
          <h2 className="text-4xl font-bold text-primary mb-6">
            Streamline Your Ordering Process
          </h2>
          <p className="max-w-3xl mx-auto text-lg text-secondary mb-6">
            With OrderEase, you can enhance customer experience, simplify the
            ordering workflow, and improve operational efficiency.
          </p>
        </div>
      </section>
    </div>
  );
}

export default Home;
