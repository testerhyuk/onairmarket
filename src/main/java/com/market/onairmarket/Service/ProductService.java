package com.market.onairmarket.Service;

import com.market.onairmarket.dto.PageRequestDTO;
import com.market.onairmarket.dto.PageResponseDTO;
import com.market.onairmarket.dto.ProductDTO;
import com.market.onairmarket.entity.Product;
import com.market.onairmarket.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    // 상품 전체 목록 페이징
    public PageResponseDTO<ProductDTO> getPageList(PageRequestDTO pageRequestDTO) {
        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() - 1,
                pageRequestDTO.getSize(),
                Sort.by("id").descending()
        );

        Page<Product> result = productRepository.findPageBy(pageable);

        List<ProductDTO> dtoList = result.getContent().stream().map(arr -> ProductDTO.builder()
                .pno(arr.getId())
                .pname(arr.getPname())
                .content(arr.getContent())
                .price(arr.getPrice())
                .category(arr.getCategory())
                .imagePath(arr.getImagePath())
                .build()
        ).toList();

        long totalCount = result.getTotalElements();

        return PageResponseDTO.<ProductDTO>withAll()
                .dtoList(dtoList)
                .total(totalCount)
                .pageRequestDTO(pageRequestDTO)
                .build();
    }

    // 최신 상품 목록
    public List<Product> getNewest6Product() {
        Pageable pageable = PageRequest.of(0, 6, Sort.by("createdDate").descending());

        return productRepository.findAllByOrderByCreatedDateDesc(pageable).getContent();
    }

    // 카테고리별 검색
    public List<Product> searchByCategoryAndContent(String category, String keyword) {
        return productRepository.findByCategoryAndContentContainingIgnoreCase(category, keyword);
    }

    // 전체 검색
    public List<Product> searchByContent(String keyword) {
        return productRepository.findByContentContainingIgnoreCase(keyword);
    }

    // 카테고리별 목록
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
}
