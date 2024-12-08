package com.market.onairmarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pname;
    private Integer price;
    private String content;
    private String imagePath;
    private String creator;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @Builder.Default
    private boolean delFlag = false;
    private String category;

    public void changePname(String pname) {
        this.pname = pname;
    }

    public void changePrice(Integer price) {
        this.price = price;
    }

    public void changeContent(String content) {
        this.content = content;
    }

    public void changeCategory(String category) {
        this.category = category;
    }

    public void changeImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void changeDelFlag(boolean delFlag) {
        this.delFlag = delFlag;
    }
}
