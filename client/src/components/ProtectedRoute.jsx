import { useNavigate } from "react-router-dom";

const ProtectedRoute = ({ children, allowedRoles }) => {
  const navigate = useNavigate();
  const user = JSON.parse(localStorage.getItem("user"));
  const token = localStorage.getItem("token");

  if (!token) {
    navigate("/login");
    return null;
  }

  if (!allowedRoles.includes(user?.roles)) {
    navigate("/unauthorized");
    return null;
  }

  return children;
};

export default ProtectedRoute;
