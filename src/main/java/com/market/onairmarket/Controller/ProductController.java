package com.market.onairmarket.Controller;

import com.market.onairmarket.Service.ProductService;
import com.market.onairmarket.dto.ProductDTO;
import com.market.onairmarket.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    // 상품 등록
    @GetMapping("/add")
    public Map<String, Long> addProduct(ProductDTO productDTO) {
        Long pno = productService.registerProduct(productDTO);

        return Map.of("Result", pno);
    }

    // 상품 수정
    @PutMapping("/modify/{pno}")
    public Map<String, String> modifyProduct(@PathVariable Long pno, ProductDTO productDTO) {
        productService.modifyProduct(pno, productDTO);

        return Map.of("Result", "SUCCESS");
    }

    // 상품 삭제
    @PutMapping("/delete/{pno}")
    public Map<String, String> deleteProduct(@PathVariable Long pno) {
        productService.deleteProduct(pno);
        return Map.of("Result", "SUCCESS");
    }

    // 모든 상품,판매 중인 상품
    @GetMapping("/list")
    public List<Product> allProduct() {
        return productService.getAllProducts();
    }

    // 상품 날짜순
    // 카테고리 별 상품
    // 상세페이지
}
