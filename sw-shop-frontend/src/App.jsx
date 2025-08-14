import React from 'react';
import {BrowserRouter, Route, Routes} from "react-router";
import HomePage from "./ui/pages/homePage/HomePage.jsx";
import Layout from "./ui/components/layout/layout/Layout.jsx";

const App = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"/"} element={<Layout/>}>
                    <Route index element={<HomePage/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
};

export default App;