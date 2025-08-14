import React from 'react';
import ProductCard from "../productCard/ProductCard.jsx";

const ProductsGrid = ({ products, onCreate, onDelete, onUpdate }) => {
    return (
        <div className="grid grid-cols-2 gap-3 sm:gap-4 md:grid-cols-3 lg:grid-cols-4 xl:gap-5">
            {products.map((product) => (
                <div key={product.id} className="w-full">
                    <ProductCard
                        onCreate={onCreate}
                        onDelete={onDelete}
                        onUpdate={onUpdate}
                        product={product}
                    />
                </div>
            ))}

            {/* Mobile Floating Action Button */}
            <button
                onClick={onCreate}
                className="md:hidden fixed bottom-6 right-6 flex items-center justify-center w-14 h-14 rounded-full bg-purple-600 text-white shadow-lg hover:bg-purple-700 transition-colors z-10"
                aria-label="Add product"
            >
                <svg xmlns="http://www.w3.org/2000/svg" className="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M12 4v16m8-8H4" />
                </svg>
            </button>

            {/* Desktop Add Product Card */}
            <div className="hidden md:flex col-span-full md:col-span-1 lg:col-span-1">
                <button
                    onClick={onCreate}
                    className="flex items-center justify-center w-full p-4 h-full min-h-[200px] border-2 border-dashed border-gray-300 rounded-lg hover:border-purple-500 hover:bg-purple-50 transition-colors"
                >
                    <div className="text-center">
                        <svg xmlns="http://www.w3.org/2000/svg" className="h-8 w-8 mx-auto text-purple-600 mb-2" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M12 4v16m8-8H4" />
                        </svg>
                        <span className="text-purple-600 font-medium">Add Product</span>
                    </div>
                </button>
            </div>
        </div>
    );
};

export default ProductsGrid;