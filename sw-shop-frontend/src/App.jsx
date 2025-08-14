import React from 'react';
import {BrowserRouter, Route, Routes} from "react-router";
import HomePage from "./ui/pages/homePage/HomePage.jsx";
import Layout from "./ui/components/layout/layout/Layout.jsx";
import ProductsPage from "./ui/pages/productsPage/ProductsPage.jsx";

const App = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"/"} element={<Layout/>}>
                    <Route index element={<HomePage/>}/>
                    <Route path={"products"} element={<ProductsPage/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
};

export default App;