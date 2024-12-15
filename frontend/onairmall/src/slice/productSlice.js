import { createSlice } from "@reduxjs/toolkit";

const productSlice = createSlice({
    name: 'newProductSlice',
    initialState: [],
    reducers: {
        sixProducts : (state, action) => {
            return action.payload
        }
    }
})

export const {sixProducts} = productSlice.actions

export default productSlice.reducer