import React from "react";
import { FaGithub } from "react-icons/fa";

const Contact = ({ name, image, github }) => {
  return (
    <div className="flex flex-col items-center space-y-2 p-4">
      <img
        src={image}
        alt={name}
        className="md:w-48 md:h-48 h-24 w-24 rounded-full border-4 border-primary shadow-xl mb-4"
      />
      <div className="text-center flex items-center flex-col">
        <h3 className="text-xl font-bold text-primary">{name}</h3>
        <div className="flex items-center gap-2">
          <FaGithub />
          <a
            href={github}
            target="_blank"
            rel="noopener noreferrer"
            className="text-sm text-secondary hover:underline"
          >
            GitHub Profile
          </a>
        </div>
      </div>
    </div>
  );
};

export default Contact;
