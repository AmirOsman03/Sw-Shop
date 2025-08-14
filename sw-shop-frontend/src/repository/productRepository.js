import axiosInstance from "../axios/axios.js";

const productRepository = {
    create: async (data) => {
        return axiosInstance.post("/books/create", data);
    },
    getAll: async () => {
        return axiosInstance.get("/books");
    },
    update: async (id, data) => {
        return axiosInstance.put(`/books/edit/${id}`, data);
    },
    delete: async (id) => {
        return axiosInstance.delete(`/books/delete/${id}`);
    },
    getById: async (id) => {
        return axiosInstance.get(`/books/${id}`);
    },
};

export default productRepository;