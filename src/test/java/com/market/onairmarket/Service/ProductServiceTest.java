package com.market.onairmarket.Service;

import com.market.onairmarket.dto.PageRequestDTO;
import com.market.onairmarket.dto.PageResponseDTO;
import com.market.onairmarket.dto.ProductDTO;
import com.market.onairmarket.entity.Product;
import com.market.onairmarket.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class ProductServiceTest {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void registerProduct() {
        for(int i = 0; i < 10; i++) {
            ProductDTO productDTO = ProductDTO.builder()
                    .price(3000)
                    .pname("의류상품" + i)
                    .category("의류")
                    .content("내용" + i)
                    .build();

            productService.registerProduct(productDTO);
        }
    }

    @Test
    @Transactional
    void modifyProduct() {
        Optional<Product> result = productRepository.findById(2L);

        Product product = result.orElseThrow();

        log.info("2번 상품 : " + product);

        product.changePrice(7000);
        product.changePname("수정 상품2");

        productRepository.save(product);

        log.info("수정된 후 : " + product);
    }

    @Test
    @Transactional
    void deleteProduct() {
        Optional<Product> result = productRepository.findById(1L);

        Product product = result.orElseThrow();

        log.info("del Flag : " + product.isDelFlag());

        product.changeDelFlag(true);

        productRepository.save(product);

        log.info("del Flag 수정 후 : " + product.isDelFlag());
    }

    @Test
    public void getAllProducts() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        PageResponseDTO<ProductDTO> responseDTO = productService.getPageList(pageRequestDTO);

        log.info("responseDTO : " + responseDTO.getCurrent() + responseDTO.getDtoList());
    }

    @Test
    public void getNewestProduct() {
        List<Product> products = productService.getNewest6Product();

        log.info(products);
    }

    @Test
    public void searchByCategoryAndContent() {
        List<Product> products = productService.searchByCategoryAndContent("의류", "용");

        log.info(products);
    }

    @Test
    public void searchByContent() {
        List<Product> products = productService.searchByContent("1");

        log.info(products);
    }

    @Test
    public void getProductsByCategory() {
        List<Product> products = productService.getProductsByCategory("가전제품");

        log.info(products);
    }
}