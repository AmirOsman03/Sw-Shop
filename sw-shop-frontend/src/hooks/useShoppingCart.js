import {useCallback, useEffect, useState} from 'react';
import shoppingCartRepository from "../repository/shoppingCartRepository.js";

const initialState = {
    shoppingCart: [],
    loading: true,
};

const UseShoppingCart = () => {
    const [state, setState] = useState(initialState);

    const fetchShoppingCart = useCallback(() => {
        setState(initialState);
        shoppingCartRepository
            .getShoppingCart()
            .then((response) => {
                setState({
                    shoppingCart: response.data,
                    loading: false,
                })
            })
            .catch((error) => {
                console.log(error);
            })
    }, []);

    const onAdd = useCallback((id) => {
        shoppingCartRepository
            .add(id)
            .then(() => {
                fetchShoppingCart();
                console.log("Product added to shopping cart");
            })
            .catch((error) => {
                console.log(error);
            });
    }, [fetchShoppingCart]);

    const onRemove = useCallback((id) => {
        shoppingCartRepository
            .remove(id)
            .then(() => {
                fetchShoppingCart();
                console.log("Product removed from shopping cart");
            })
            .catch((error) => {
                console.log(error);
            });
    }, [fetchShoppingCart]);

    useEffect(() => {
        fetchShoppingCart()
    }, [fetchShoppingCart]);

    return {
        ...state,
        onAdd,
        onRemove
    }
};

export default UseShoppingCart;