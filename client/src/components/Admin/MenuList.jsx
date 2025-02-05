import React, { useEffect, useState } from 'react'
import MenuCard from './MenuCard'

function MenuList() {
    const [menuItems, setMenuItems] = useState([]);

    useEffect(() => {
        setTimeout(() => {
            const dummyData = [
                {
                    itemId: 1,
                    itemName: "Veg Burger",
                    itemDescription: "A delicious vegetarian burger.",
                    itemPrice: 5.99,
                    itemType: "veg",
                    itemIsAvailable: true,
                    itemImage: "veg_burger",
                    itemImageUrl:
                        "https://www.foodandwine.com/thmb/DI29Houjc_ccAtFKly0BbVsusHc=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/crispy-comte-cheesburgers-FT-RECIPE0921-6166c6552b7148e8a8561f7765ddf20b.jpg",
                },
                {
                    itemId: 2,
                    itemName: "Chicken Wings",
                    itemDescription: "Crispy and spicy chicken wings.",
                    itemPrice: 7.99,
                    itemType: "nonveg",
                    itemIsAvailable: true,
                    itemImage: "chicken_wings",
                    itemImageUrl:
                        "https://www.recipetineats.com/tachyon/2024/11/New-Oreleans-chicken-wings_1.jpg?resize=500%2C375",
                },
                {
                    itemId: 3,
                    itemName: "Veg Pizza",
                    itemDescription: "Cheesy pizza with fresh veggies.",
                    itemPrice: 118.99,
                    itemType: "veg",
                    itemIsAvailable: true,
                    itemImage: "veg_pizza",
                    itemImageUrl:
                        "https://www.allrecipes.com/thmb/aefJMDXKqs42oAP71dQuYf_-Qdc=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/6776_Pizza-Dough_ddmfs_4x3_1724-fd91f26e0bd6400a9e89c6866336532b.jpg",
                },
                {
                    itemId: 4,
                    itemName: "Beef Steak",
                    itemDescription: "Juicy beef steak grilled to perfection.",
                    itemPrice: 12.99,
                    itemType: "nonveg",
                    itemIsAvailable: true,
                    itemImage: "beef_steak",
                    itemImageUrl:
                        "https://img.hellofresh.com/f_auto,fl_lossy,q_auto,w_1200/hellofresh_s3/image/thyme-balsamic-beef-rump-c1ba3100.jpg",
                },
            ];

            setMenuItems(dummyData); // Update the state with dummyData
        }, 1000);
    }, []);

    return (
        <div>
            <h1 className="text-3xl font-bold mb-5 text-center ">Current Menu</h1>
                {menuItems.map((ele, index) => {
                    return <MenuCard key={index} ele={ele} />
                })}
        </div>
    )
}

export default MenuList