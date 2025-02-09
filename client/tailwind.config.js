/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {
      colors: {
        primary: "#561F37",
        secondary: "#C3979F",
        base: "#FCFFF7",
      },
    },
  },
  plugins: [],
};
