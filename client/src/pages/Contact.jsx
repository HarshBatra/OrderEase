import React, { useState, useEffect } from "react";
import Contact from "../components/Contact";
import contactData from "../constants/developers.json";

const App = () => {
  const [contacts, setContacts] = useState([]);

  useEffect(() => {
    setContacts(contactData);
  }, []);

  return (
    <div className="min-h-[70vh] bg-base p-10">
      <h1 className="text-3xl font-bold text-center text-primary mb-2">
        Contact Us
      </h1>
      <h1 className="text-xl font-bold text-center text-secondary mb-10">
        OrderEase Developer Team
      </h1>
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-8">
        {contacts.map((contact) => (
          <Contact
            key={contact.id}
            name={contact.name}
            image={contact.image}
            github={contact.github}
          />
        ))}
      </div>
    </div>
  );
};

export default App;
