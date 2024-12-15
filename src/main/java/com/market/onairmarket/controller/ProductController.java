package com.market.onairmarket.Controller;

import com.market.onairmarket.Service.ProductService;
import com.market.onairmarket.dto.PageRequestDTO;
import com.market.onairmarket.dto.PageResponseDTO;
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
    public PageResponseDTO<ProductDTO> allProducts(PageRequestDTO pageRequestDTO) {
        return productService.getPageList(pageRequestDTO);
    }

    // 상품 날짜순
    @GetMapping("/latest")
    public List<Product> getNewestProduct() {
        return productService.getNewest6Product();
    }

    // 카테고리 별 상품 검색
    @GetMapping("/search/category")
    public List<Product> searchByCategoryAndContent(@RequestParam String category, @RequestParam String keyword) {
        return productService.searchByCategoryAndContent(category, keyword);
    }

    // 상품 전체 검색
    @GetMapping("/search")
    public List<Product> searchBytContent(@RequestParam String keyword) {
        return productService.searchByContent(keyword);
    }

    // 카테고리별 상품
    @GetMapping("/category")
    public List<Product> getProductsByCategory(@RequestParam String category) {
        return productService.getProductsByCategory(category);
    }

    // 상세페이지
}
