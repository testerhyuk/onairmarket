import { faBars, faBell, faSearch, faUser } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import React from 'react'
import { Dropdown } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import logo from '../../OnAir.png'
import './css/BasicMenu.css'

export default function BasicMenu() {
  return (
    <div className='nav_layout'>
        <ul className='navbar'>
            <li>
                <Dropdown>
                    <Dropdown.Toggle className='dropdown_toggle'>
                        <FontAwesomeIcon
                            icon={faBars}
                            className='fabars'
                            size='2x'
                        />
                    </Dropdown.Toggle>

                    <Dropdown.Menu className='dropdown_menu'>
                        <Dropdown.Item className='all_products' as={Link} to={'/products/'}>전체 상품</Dropdown.Item>
                        <Dropdown.Item className='category_0' as={Link} to={'/products/category/0'}>음식</Dropdown.Item>
                        <Dropdown.Item className='category_1' as={Link} to={'/products/category/1'}>의류</Dropdown.Item>
                        <Dropdown.Item className='category_2' as={Link} to={'/products/category/2'}>가전제품</Dropdown.Item>
                        <Dropdown.Item className='category_3' as={Link} to={'/products/category/3'}>신발</Dropdown.Item>
                        <Dropdown.Item className='category_4' as={Link} to={'/products/category/4'}>기타상품</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>
            </li>

            <li className='logo'><Link to={'/'}><img src={logo} width='150px' alt='logo' /></Link></li>
            <ul className='navbar2' style={{display:'flex'}}>
                <li><FontAwesomeIcon icon={faSearch} className='fasearch' size='2x' /></li>
                <li><FontAwesomeIcon icon={faBell} className='fabell' size='2x' /></li>
                <li>
                    <Dropdown>
                        <Dropdown.Toggle className='dropdown_member_toggle'>
                            <FontAwesomeIcon icon={faUser} className='fauser' size='2x' />
                        </Dropdown.Toggle>

                        <Dropdown.Menu className='dropdown_menu'>
                            <Dropdown.Item className='memberInfo' as={Link} to={'/member/login'}>로그인</Dropdown.Item>
                        </Dropdown.Menu>
                    </Dropdown>
                </li>
            </ul>
        </ul>
    </div>
  )
}
