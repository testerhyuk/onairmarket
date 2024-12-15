import axios from "axios"

export const API_SERVER_HOST = 'http://localhost:8080'

const host = `${API_SERVER_HOST}/api/products`

// 최신 상품
export const newProdcut = async () => {
    const res = await axios.get(`${host}/latest`)

    return res.data
}