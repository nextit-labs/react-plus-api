package com.nextit.reactplus.dto;

import com.nextit.reactplus.model.ProductReview;
import com.nextit.reactplus.model.type.ReviewType;
import lombok.*;

@Data
@Builder
public class ProductReviewDto {

    private ReviewType reviewType;
    private String bestReviewYn;
    private String colorReview;
    private String sizeReview;
    private String orderSize;
    private String orderColor;
    private String score;
    private String idMember;
    private String title;
    private String content;
    private String imageUrl;
    private ProductDto product;

    public static ProductReviewDto fromEntity(ProductReview productReview) {
        if (productReview == null) {
            return null;
        }

        return ProductReviewDto.builder()
                .reviewType(productReview.getReviewType())
                .bestReviewYn(productReview.getBestReviewYn())
                .colorReview(productReview.getColorReview())
                .sizeReview(productReview.getSizeReview())
                .orderSize(productReview.getOrderSize())
                .orderColor(productReview.getOrderColor())
                .score(productReview.getScore())
                .idMember(productReview.getIdMember())
                .title(productReview.getTitle())
                .content(productReview.getContent())
                .imageUrl(productReview.getImageUrl())
                .product(ProductDto.fromEntity(productReview.getProduct()))
                .build();
    }

    public static ProductReview toEntity(ProductReviewDto productReviewDto) {
        if (productReviewDto == null) {
            return null;
        }
        ProductReview productReview = new ProductReview();
        productReview.setReviewType(productReviewDto.getReviewType());
        productReview.setBestReviewYn(productReviewDto.getBestReviewYn());
        productReview.setColorReview(productReviewDto.getColorReview());
        productReview.setSizeReview(productReviewDto.getSizeReview());
        productReview.setOrderSize(productReviewDto.getOrderSize());
        productReview.setOrderColor(productReviewDto.getOrderColor());
        productReview.setScore(productReviewDto.getScore());
        productReview.setIdMember(productReviewDto.getIdMember());
        productReview.setTitle(productReviewDto.getTitle());
        productReview.setContent(productReviewDto.getContent());
        productReview.setImageUrl(productReviewDto.getImageUrl());
        productReview.setProduct(ProductDto.toEntity(productReviewDto.getProduct()));

        return productReview;
    }
}