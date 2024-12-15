import React from 'react'
import { useNavigate } from 'react-router-dom'
import Slider from 'react-slick';
import './css/NewProductComponent.css'
import "slick-carousel/slick/slick.css"; 
import "slick-carousel/slick/slick-theme.css";

export default function NewProductComponent({product}) {
    const navigate = useNavigate()

    const settings = {
        dots: true,
        infinite: false,
        speed: 500,
        slidesToShow: 4,
        slidesToScroll: 1,
        swipe: false,
        arrows: true
      };

  return (
    <div>
        <div style={{marginTop:'20px'}}>
            <div className="slider-container" style={{marginBottom:'30px'}}>
              <Slider {...settings}>
                {product.map(prd => {
                  return (
                    <div key={prd.pno} className='h-[300px] cursor-pointer' onClick={() => navigate(`products/read/${prd.pno}`)}>
                      <div className='h-46 flex justify-center items-center '>
                        <img alt="product_image" className='h-44 w-33 rounded' />
                      </div>

                      <div className='flex flex-col items-center justify-center gap-1 p-4'>
                        <p className='text-xl font-semibold'>{prd.pname}</p>
                        <p className='text-center'>{prd.price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}원</p>
                      </div>
                    </div>
                  )
                })}
              </Slider>
            </div>
        </div>
    </div>
  )
}
