import React, { useState } from "react";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";

const Signup = () => {
  const [username, setUsername] = useState("");
  const [userEmail, setUserEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [phoneNo, setPhoneNo] = useState("");
  const [role, setrole] = useState("USER");
  const [error, setError] = useState("");

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (password !== confirmPassword) {
      setError("Passwords don't match!");
      return;
    }

    if (!username || !userEmail || !phoneNo || !role) {
      setError("All fields are required!");
      return;
    }

    try {
      const response = await fetch(
        import.meta.env.VITE_API_URL + "/auth/register",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            username,
            userEmail,
            password,
            phoneNo,
            role,
          }),
        }
      );

      if (response.ok) {
        navigate("/login");
      } else {
        const errorData = await response.json();
        setError(
          errorData.message || "Something went wrong, please try again."
        );
      }
    } catch (error) {
      setError("An error occurred while registering. Please try again.");
    }
  };

  return (
    <div className="min-h-screen md:min-h-[70vh] bg-base flex items-center justify-center">
      <div className="w-5/6 md:w-2/3 bg-white p-8 rounded-lg shadow-lg border-2 border-secondary border-opacity-30">
        <h2 className="text-2xl font-bold text-primary mb-6">Sign Up</h2>
        {error && <p className="text-red-500 text-sm mb-4">{error}</p>}{" "}
        <form
          onSubmit={handleSubmit}
          className="md:grid md:grid-flow-row md:grid-cols-3 md:gap-4 grid"
        >
          <div className="mb-4">
            <label htmlFor="username" className="block text-primary">
              Username
            </label>
            <input
              type="text"
              id="username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              className="w-full mt-2 p-3 border border-secondary rounded-md focus:outline-none focus:ring-2 focus:ring-primary"
              placeholder="Enter your username"
              required
            />
          </div>
          <div className="mb-4">
            <label htmlFor="userEmail" className="block text-primary">
              Email
            </label>
            <input
              type="email"
              id="userEmail"
              value={userEmail}
              onChange={(e) => setUserEmail(e.target.value)}
              className="w-full mt-2 p-3 border border-secondary rounded-md focus:outline-none focus:ring-2 focus:ring-primary"
              placeholder="Enter your email"
              required
            />
          </div>
          <div className="mb-4">
            <label htmlFor="password" className="block text-primary">
              Password
            </label>
            <input
              type="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              className="w-full mt-2 p-3 border border-secondary rounded-md focus:outline-none focus:ring-2 focus:ring-primary"
              placeholder="Enter your password"
              required
            />
          </div>
          <div className="mb-4">
            <label htmlFor="confirmPassword" className="block text-primary">
              Confirm Password
            </label>
            <input
              type="password"
              id="confirmPassword"
              value={confirmPassword}
              onChange={(e) => setConfirmPassword(e.target.value)}
              className="w-full mt-2 p-3 border border-secondary rounded-md focus:outline-none focus:ring-2 focus:ring-primary"
              placeholder="Confirm your password"
              required
            />
          </div>
          <div className="mb-4">
            <label htmlFor="phoneNo" className="block text-primary">
              Phone Number
            </label>
            <input
              type="text"
              id="phoneNo"
              value={phoneNo}
              onChange={(e) => setPhoneNo(e.target.value)}
              className="w-full mt-2 p-3 border border-secondary rounded-md focus:outline-none focus:ring-2 focus:ring-primary"
              placeholder="Enter your phone number"
              required
            />
          </div>
          <div className="mb-4">
            <label htmlFor="role" className="block text-primary">
              Role
            </label>
            <select
              id="role"
              value={role}
              onChange={(e) => setrole(e.target.value)}
              className="w-full mt-2 p-3 border border-secondary rounded-md focus:outline-none focus:ring-2 focus:ring-primary"
            >
              <option value="USER">User</option>
              <option value="ADMIN">Admin</option>
              <option value="STAFF">Staff</option>
            </select>
          </div>
          <button
            type="submit"
            className="w-full bg-primary text-white py-3 rounded-md hover:bg-secondary focus:outline-none focus:ring-2 focus:ring-primary md:col-span-3"
          >
            Sign Up
          </button>
        </form>
        <div className="mt-6 text-center">
          <p className="text-sm text-primary">
            Already have an account?{" "}
            <Link
              to="/login"
              className="text-secondary font-semibold hover:text-primary"
            >
              Log in
            </Link>
          </p>
        </div>
      </div>
    </div>
  );
};

export default Signup;
