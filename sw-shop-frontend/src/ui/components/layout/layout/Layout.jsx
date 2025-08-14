import React from 'react';
import Navbar from "../navbar/Navbar.jsx";
import {Outlet} from "react-router";
import Footer from "../footer/Footer.jsx";

const Layout = () => {
    return (
        <div>
            <Navbar/>
            <Outlet/>
            <Footer/>
        </div>
    );
};

export default Layout;