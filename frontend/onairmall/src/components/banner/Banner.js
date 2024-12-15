import React, { useState } from 'react'
import banner1 from '../../banner_image/banner1.png'
import banner2 from '../../banner_image/banner2.png'
import './css/Banner.css'
import { Carousel } from 'react-bootstrap'

export default function Banner() {
    const images = [banner1, banner2]

    const [index, setIndex] = useState(0);

    const handleSelect = (selectedIndex) => {
      setIndex(selectedIndex);
    };

  return (
    <div>
        <Carousel activeIndex={index} onSelect={handleSelect}>
            <Carousel.Item>
                <img className='banner_image' src={images[0]} alt={`banner${0}`} />
            </Carousel.Item>
            <Carousel.Item>
                <img className='banner_image' src={images[1]} alt={`banner${1}`} />
            </Carousel.Item>
        </Carousel>
        <div className='division-line'></div>
    </div>
  )
}
