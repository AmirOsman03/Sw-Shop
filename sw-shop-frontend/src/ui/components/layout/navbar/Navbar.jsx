import React, { useState, useEffect } from 'react';
import { AiOutlineMenu, AiOutlineClose } from "react-icons/ai";
import { IoSearchOutline } from "react-icons/io5";
import { FiUser } from "react-icons/fi";
import { HiOutlineShoppingCart } from "react-icons/hi";
import { motion, AnimatePresence } from 'framer-motion';

const Navbar = () => {
    const [isMenuOpen, setIsMenuOpen] = useState(false);
    const [isScrolled, setIsScrolled] = useState(false);

    useEffect(() => {
        const handleScroll = () => {
            setIsScrolled(window.scrollY > 50);
        };

        window.addEventListener('scroll', handleScroll);
        return () => window.removeEventListener('scroll', handleScroll);
    }, []);

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
        <nav className={`fixed top-0 left-0 right-0 z-50 transition-all duration-500 ${
            isScrolled
                ? 'bg-white/70 backdrop-blur-md shadow-lg'
                : 'bg-transparent'
        }`}>
            <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
                <div className="flex items-center justify-between h-16 lg:h-20">
                    {/* Left side - Menu */}
                    <div className="flex items-center space-x-4">
                        <motion.button
                            onClick={toggleMenu}
                            className="p-2 rounded-full transition-all duration-300 hover:bg-gray-100/30 focus:outline-none"
                            whileTap={{ scale: 0.9 }}
                        >
                            {isMenuOpen ? (
                                <AiOutlineClose className="w-6 h-6" />
                            ) : (
                                <AiOutlineMenu className="w-6 h-6" />
                            )}
                        </motion.button>

                        <button className="p-2 rounded-full transition-all duration-300 hover:bg-gray-100/30 focus:outline-none">
                            <IoSearchOutline className="w-6 h-6" />
                        </button>
                    </div>

                    {/* Center - Logo */}
                    <div className="flex-1 flex justify-center">
                        <div className="text-2xl lg:text-3xl font-light tracking-widest transition-all duration-500 text-gray-800">
                            <span className="font-light">SW</span>
                            <span className="font-medium text-pink-500">SHOP</span>
                        </div>
                    </div>

                    {/* Right side - User actions */}
                    <div className="flex items-center space-x-2 lg:space-x-4">
                        <button className="p-2 rounded-full transition-all duration-300 hover:bg-white/20 text-gray-800 focus:outline-none">
                            <FiUser className="w-6 h-6" />
                        </button>
                        <button className="relative p-2 rounded-full transition-all duration-300 hover:bg-white/20 text-gray-800 focus:outline-none">
                            <HiOutlineShoppingCart className="w-6 h-6" />
                            <span className="absolute -top-1 -right-1 bg-pink-500 text-white text-xs rounded-full w-5 h-5 flex items-center justify-center">
                                3
                            </span>
                        </button>
                    </div>
                </div>

                {/* Mobile Menu - Solid styling for menu items */}
                <AnimatePresence>
                    {isMenuOpen && (
                        <>
                            <motion.div
                                className="fixed inset-0 bg-white bg-opacity-30 backdrop-blur-md z-40"
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
                                    <h2 className="text-xl font-bold text-gray-800">Menu</h2>
                                    <motion.button
                                        onClick={toggleMenu}
                                        className="focus:outline-none text-gray-800"
                                        whileHover={{ scale: 1.1 }}
                                        whileTap={{ scale: 0.9 }}
                                    >
                                        <AiOutlineClose className="w-6 h-6" />
                                    </motion.button>
                                </div>

                                <nav>
                                    <ul className="space-y-4">
                                        {['Home', 'Shop', 'Collections', 'About Us', 'Contact'].map((item) => (
                                            <motion.li
                                                key={item}
                                                whileHover={{ x: 5 }}
                                                transition={{ type: 'spring', stiffness: 400 }}
                                            >
                                                <a href="#" className="block py-2 px-3 text-gray-800 hover:text-pink-500 hover:bg-pink-50 rounded-lg transition-all duration-300">
                                                    {item}
                                                </a>
                                            </motion.li>
                                        ))}
                                    </ul>
                                </nav>
                            </motion.div>
                        </>
                    )}
                </AnimatePresence>
            </div>

            {/* Decorative elements */}
            <div className="absolute top-0 left-0 w-full h-px bg-gradient-to-r from-transparent via-pink-200 to-transparent opacity-50"></div>
        </nav>
    );
};

export default Navbar;