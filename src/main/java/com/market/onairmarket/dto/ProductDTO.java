package com.market.onairmarket.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
    private Long pno;
    private String pname;
    private Integer price;
    private String content;
    private String category;
    private String imagePath;
    private boolean delFlag;
}
