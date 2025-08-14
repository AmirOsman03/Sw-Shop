import React, { useState } from 'react';
import { AiOutlineMenu, AiOutlineClose } from "react-icons/ai";
import { IoSearchOutline } from "react-icons/io5";
import { FiUser } from "react-icons/fi";
import { HiOutlineShoppingCart } from "react-icons/hi";
import { motion, AnimatePresence } from 'framer-motion';
import {Link} from "react-router";  // Fixed spelling

const pages = [
    {
        name: 'Sale',
        href: "/products"
    },
    {
        name: 'Bras',
        href: '/products',
    },
    {
        name: 'Panties',
        href: '/products',
    },
    {
        name: 'Lingerie',
        href: '/products',
    },
    {
        name: 'Knitwear',
        href: '/products',
    },
    {
        name: 'Pajamas',
        href: '/products',
    },
]

const Navbar = () => {
    const [isMenuOpen, setIsMenuOpen] = useState(false);

    const toggleMenu = () => {
        setIsMenuOpen(!isMenuOpen);
    };

    // Animation variants
    const overlayVariants = {
        hidden: { opacity: 0, backdropFilter: 'blur(0px)' },
        visible: {
            opacity: 1,
            backdropFilter: 'blur(8px)',
            transition: { duration: 0.3 }
        }
    };

    const menuVariants = {
        hidden: { x: '-100%' },
        visible: {
            x: 0,
            transition: { type: 'spring', stiffness: 300, damping: 30 }
        },
        exit: { x: '-100%', transition: { duration: 0.3 } }
    };

    return (
        <div className={`p-5 relative ${isMenuOpen ? 'overflow-hidden h-screen' : ''}`}>
            <div className="grid grid-cols-3 items-center">
                <div className="flex">
                    <motion.button
                        onClick={toggleMenu}
                        className="focus:outline-none"
                        whileTap={{ scale: 0.9 }}
                    >
                        {isMenuOpen ? (
                            <AiOutlineClose className="size-5" />
                        ) : (
                            <AiOutlineMenu className="size-5" />
                        )}
                    </motion.button>

                    <button className="ms-7 focus:outline-none">
                        <IoSearchOutline className="size-5" />
                    </button>
                </div>

                <div className="border-2 w-max px-5">
                    SW SHOP
                </div>

                <div className="flex justify-end">
                    <div className="flex">
                        <button className="focus:outline-none">
                            <FiUser className="size-5" />
                        </button>
                        <button className="ms-7 focus:outline-none">
                            <HiOutlineShoppingCart className="size-5" />
                        </button>
                    </div>
                </div>
            </div>

            <AnimatePresence>
                {isMenuOpen && (
                    <>
                        <motion.div
                            className="fixed inset-0 bg-white bg-opacity-70 z-40"
                            initial="hidden"
                            animate="visible"
                            exit="hidden"
                            variants={overlayVariants}
                            onClick={toggleMenu}
                        />

                        <motion.div
                            className="fixed top-0 left-0 bg-white w-64 h-full p-5 shadow-xl z-50"
                            initial="hidden"
                            animate="visible"
                            exit="exit"
                            variants={menuVariants}
                        >
                            <div className="flex justify-between items-center mb-8">
                                <h2 className="text-xl font-bold">Menu</h2>
                                <motion.button
                                    onClick={toggleMenu}
                                    className="focus:outline-none"
                                    whileHover={{ scale: 1.1 }}
                                    whileTap={{ scale: 0.9 }}
                                >
                                    <AiOutlineClose className="size-5" />
                                </motion.button>
                            </div>

                            <nav>
                                <ul className="space-y-4">
                                    {pages.map((page) => (
                                        <motion.li
                                            key={page.href}
                                            whileHover={{ x: 5 }}
                                            transition={{ type: "spring", stiffness: 400 }}
                                        >
                                            <Link
                                                to={page.href}
                                                onClick={() => setIsMenuOpen(false)}
                                                className="block py-2 hover:text-gray-500 transition-colors"
                                            >
                                                {page.name}
                                            </Link>
                                        </motion.li>
                                    ))}
                                </ul>
                            </nav>
                        </motion.div>
                    </>
                )}
            </AnimatePresence>
        </div>
    );
};

export default Navbar;