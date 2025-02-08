import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const ProtectedRoute = ({ children, allowedRoles }) => {
  const navigate = useNavigate();
  const user = JSON.parse(localStorage.getItem("user"));
  const token = localStorage.getItem("token");

  useEffect(() => {
    if (!token) {
      navigate("/login");
    } else if (!allowedRoles.includes(user?.role)) {
      navigate("/unauthorised");
    }
  }, [navigate, token, user, allowedRoles]);

  // Return null while navigating, to avoid rendering children before navigation occurs
  return token && allowedRoles.includes(user?.role) ? children : null;
};

export default ProtectedRoute;
