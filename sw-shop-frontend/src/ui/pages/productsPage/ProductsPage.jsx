import React from 'react';
import useProducts from "../../../hooks/useProducts.js";
import ProductsGrid from "../../components/products/productsGrid/ProductsGrid.jsx";

const ProductsPage = () => {
    const {products, onDelete, onUpdate, onCreate, loading} = useProducts();

    if (loading) {
        return (
            <div className="flex justify-center items-center min-h-[60vh]">
                <div className="animate-spin rounded-full h-12 w-12 border-b-2 border-purple-600"></div>
            </div>
        );
    }

    return (
        <div className="px-4 py-10 sm:px-6 md:px-8 lg:px-10 xl:mx-10">
            <div className="my-10 flex flex-col sm:flex-row sm:items-center sm:justify-between">
                <h1 className="text-2xl font-bold text-gray-800 mb-4 sm:mb-0">Sales</h1>
            </div>

            <ProductsGrid
                products={products}
                onDelete={onDelete}
                onUpdate={onUpdate}
                onCreate={onCreate}
            />
        </div>
    );
};

export default ProductsPage;