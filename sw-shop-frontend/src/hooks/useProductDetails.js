import {useEffect, useState} from 'react';
import productRepository from "../repository/productRepository.js";

const initialState = {
    product: {},
    loading: true,
}

const useProductDetails = (id) => {
    const [state, setState] = useState(initialState);

    useEffect(() => {
        productRepository
            .getById(id)
            .then((response) => {
                setState({
                    product: response.data,
                    loading: false,
                })
            })
            .catch((error) => {
                console.log(error);
            });
    }, [id]);

    return state;
};

export default useProductDetails;