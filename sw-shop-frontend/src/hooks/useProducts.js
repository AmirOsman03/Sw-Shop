import {useCallback, useEffect, useState} from 'react';
import productRepository from "../repository/productRepository.js";

const initialState = {
    products: [],
    loading: true,
}

const UseProducts = () => {
    const [state, setState] = useState(initialState);

    const fetchProducts = useCallback(() => {
        setState(initialState);
        productRepository
            .getAll()
            .then((response) => {
                setState({
                    products: response.data,
                    loading: false,
                })
            })
            .catch((error) => {
                console.log(error);
            })
    }, []);

    const onCreate = useCallback((data) => {
        productRepository
            .create(data)
            .then(() => {
                fetchProducts();
                console.log("Product created");
            })
            .catch((error) => {
                console.log(error);
            })
    }, [fetchProducts]);

    const onUpdate = useCallback((id, data) => {
        productRepository
            .update(id, data)
            .then(() => {
                fetchProducts();
                console.log("Product updated");
            })
            .catch((error) => {
                console.log(error);
            })
    }, [fetchProducts]);

    const onDelete = useCallback((id) => {
        productRepository
            .delete(id)
            .then(() => {
                fetchProducts();
                console.log("Product deleted");
            })
            .catch((error) => {
                console.log(error);
            })
    }, [fetchProducts])

    useEffect(() => {
        fetchProducts();
    }, [fetchProducts]);

    return {
        ...state,
        onCreate,
        onUpdate,
        onDelete
    }
};

export default UseProducts;