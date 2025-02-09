import React from "react";

const Unauthorised = () => {
  return (
    <div className="items-center flex flex-col">
      <div className="font-bold text-xl text-red-600 my-10">Unauthorised</div>
      <img
        src="https://media0.giphy.com/media/v1.Y2lkPTc5MGI3NjExN2J2ejJtcndmdXFraTBvejFiMjY5d2R4eHRhOG4wMm56Nm51andpaCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/l0ErQ2UfBNFEIlqjC/giphy.gif"
        alt=""
        className="w-1/2"
      />
    </div>
  );
};

export default Unauthorised;
