import axiosInstance from "../axios/axios.js";

const productRepository = {
    create: async (data) => {
        return axiosInstance.post("/products/create", data);
    },
    getAll: async () => {
        return axiosInstance.get("/products");
    },
    update: async (id, data) => {
        return axiosInstance.put(`/products/edit/${id}`, data);
    },
    delete: async (id) => {
        return axiosInstance.delete(`/products/delete/${id}`);
    },
    getById: async (id) => {
        return axiosInstance.get(`/products/${id}`);
    },
};

export default productRepository;