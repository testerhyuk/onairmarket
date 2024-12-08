package com.market.onairmarket.Service;

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
        ProductDTO productDTO = ProductDTO.builder()
                .price(3000)
                .pname("테스트 상품3")
                .category("가전제품3")
                .content("상품 3")
                .build();

        productService.registerProduct(productDTO);
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
        List<Product> product = productService.getAllProducts();

        log.info("모든 상품 : " + product);
    }
}