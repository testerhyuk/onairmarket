import React, { useEffect } from 'react'
import NewProductComponent from '../../components/products/NewProductComponent'
import { useDispatch, useSelector } from 'react-redux'
import { newProdcut } from '../../api/ProductApi'
import { sixProducts } from '../../slice/productSlice'

export default function NewProduct() {
    const newSixProducts = useSelector(state => state.productSlice)

    const dispatch = useDispatch()

    useEffect(() => {
        newProdcut().then(data => {
            dispatch(sixProducts(data))
        })
    }, [])

  return (
    <div>
        <h4 style={{marginLeft:'42%', marginTop:'20px'}}>오늘의 상품</h4>
        <div style={{borderBottom:'1px solid lightgray', width:'160px', marginLeft:'40%'}}></div>
        <div>
            <NewProductComponent product={newSixProducts}/>
        </div>
    </div>
  )
}
