import React from 'react';
import {AiOutlineMenu} from "react-icons/ai";
import {IoSearchOutline} from "react-icons/io5";
import {FiUser} from "react-icons/fi";
import {HiOutlineShoppingCart} from "react-icons/hi";

const Navbar = () => {
    return (
        <div className={"p-5"}>
            <div className={"grid grid-cols-5"}>
                <div className={"col-span-1"}>
                    <AiOutlineMenu
                        className={"size-5"}
                    />
                </div>
                <div className={"col-span-1"}>
                    <IoSearchOutline
                        className={"size-5"}
                    />
                </div>
                <div className={"border-2 w-max"}>
                    SW SHOP
                </div>
                <div className={"flex justify-end"}>
                    <FiUser
                        className={"size-5"}
                    />
                </div>
                <div className={"flex justify-end"}>
                    <HiOutlineShoppingCart
                        className={"size-5"}
                    />
                </div>
            </div>
        </div>
    );
};

export default Navbar;