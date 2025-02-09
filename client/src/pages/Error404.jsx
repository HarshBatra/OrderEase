import React from "react";

const Error404 = () => {
  return (
    <div className="text-primary flex flex-col font-bold w-screen justify-center items-center p-4 h-[70vh] bg-base">
      <div className="flex justify-center">
        <img
          className="w-1/3 mb-4 drop-shadow-lg rounded-2xl"
          src="../../public/assets/error404.webp"
        />
      </div>
      <div className="text-2xl">ERROR 404</div>
      <div className="font-normal">Page Not Found.</div>
    </div>
  );
};

export default Error404;
