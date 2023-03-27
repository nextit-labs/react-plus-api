package com.nextit.reactplus.model;

import com.nextit.reactplus.model.type.ReviewType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product_review")
public class ProductReview extends AbstractEntity {

    @Column(name = "review_type")
    @Enumerated(EnumType.STRING)
    private ReviewType reviewType;

    @Column(name = "best_review_yn")
    private String bestReviewYn;

    @Column(name = "color_review")
    private String colorReview;

    @Column(name = "size_review")
    private String sizeReview;

    @Column(name = "order_size")
    private String orderSize;

    @Column(name = "order_color")
    private String orderColor;

    @Column(name = "score")
    private String score;

    @Column(name = "id_member")
    private String idMember;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

}