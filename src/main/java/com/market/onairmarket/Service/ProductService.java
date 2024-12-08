package com.market.onairmarket.Service;

import com.market.onairmarket.dto.ProductDTO;
import com.market.onairmarket.entity.Product;
import com.market.onairmarket.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    // 모든 상품
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 상품 저장
    public Long registerProduct(ProductDTO productDTO) {
        Product product = Product.builder()
                .id(productDTO.getPno())
                .category(productDTO.getCategory())
                .content(productDTO.getContent())
                .pname(productDTO.getPname())
                .price(productDTO.getPrice())
                .imagePath(productDTO.getImagePath())
                .build();

        return productRepository.save(product).getId();
    }

    // 상품 수정
    public void modifyProduct(Long pno, ProductDTO productDTO) {
        Optional<Product> result = productRepository.findById(pno);

        Product product = result.orElseThrow();

        product.changePname(productDTO.getPname());
        product.changeCategory(productDTO.getCategory());
        product.changeContent(productDTO.getContent());
        product.changePrice(productDTO.getPrice());
        product.changeImagePath(productDTO.getImagePath());

        productRepository.save(product);
    }

    // 상품 삭제
    public void deleteProduct(Long pno) {
        Optional<Product> result = productRepository.findById(pno);

        Product product = result.orElseThrow();

        product.changeDelFlag(true);

        productRepository.save(product);
    }
}
