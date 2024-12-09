package com.market.onairmarket.repository;

import com.market.onairmarket.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findPageBy(Pageable page);

    Page<Product> findAllByOrderByCreatedDateDesc(Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.category = :category AND p.content LIKE %:keyword%")
    List<Product> findByCategoryAndContentContainingIgnoreCase(@Param("category") String category, @Param("keyword") String keyword);

    List<Product> findByContentContainingIgnoreCase(String keyword);

    List<Product> findByCategory(String category);
}
