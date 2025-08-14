import axiosInstance from "../axios/axios.js";

const shoppingCartRepository = {
    add: async (id) => {
        return axiosInstance.post(`/shopping-cart/add-product/${id}`);
    },
    getShoppingCart: async () => {
        return axiosInstance.get(`/shopping-cart`);
    },
    remove: async (id) => {
        return axiosInstance.post(`/shopping-cart/remove-product/${id}`);
    },
};

export default shoppingCartRepository;