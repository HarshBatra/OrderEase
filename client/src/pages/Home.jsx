import React from "react";

const Home = () => {
  return (
    <div className="text-blue-600 flex flex-col font-bold w-screen h-screen justify-center items-center p-4 drop-shadow-lg bg-blue-200">
      <div className="text-2xl">OrderEase</div>
      <div className="font-normal">Where Convenience Meets Deliciousness.</div>
      <div className="font-light text-black w-1/2 mt-4">
        OrderEase is a modern canteen order management system designed to
        simplify food ordering and streamline operations. From placing orders to
        tracking status in real time, it ensures a hassle-free experience for
        customers, staff, and admins alike.
      </div>
    </div>
  );
};

export default Home;
