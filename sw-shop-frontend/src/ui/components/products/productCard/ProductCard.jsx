import React from 'react';
import {useNavigate} from "react-router";

const ProductCard = ({product}) => {
    const navigate = useNavigate();

    const handleClick = (id) => {
        navigate(`/products/${id}`);
    }

    if (!product) return null;

    return (
        <div className="group">
            <div
                className="aspect-[3/4] bg-gradient-to-br from-pink-50 to-rose-100 rounded-xl overflow-hidden mb-4 relative">
                <div className="absolute inset-0 bg-gradient-to-t from-black/10 to-transparent"></div>
                <div className="absolute top-4 right-4">
                    <button
                        className="w-8 h-8 bg-white/80 rounded-full flex items-center justify-center text-gray-600 hover:bg-pink-500 hover:text-white transition-colors">
                        ♥
                    </button>
                </div>
            </div>
            <h3 className="text-lg font-medium text-gray-800 mb-2">{product.name}</h3>
            <p className="text-gray-600 mb-2">{product.price} ден</p>
            <button className="w-full bg-pink-500 text-white py-2 rounded-lg hover:bg-pink-600 transition-colors">
                Add to Cart
            </button>
        </div>
    );
};

export default ProductCard;