import React from 'react'
import BasicLayout from '../../layouts/BasicLayout'
import Banner from '../../components/banner/Banner'
import NewProduct from './NewProduct'

export default function MainPage() {
  return (
    <BasicLayout>
        <Banner />
        <NewProduct />
    </BasicLayout>
  )
}
