package com.ll.example.batch_exam.app.product.entity;

import com.ll.example.batch_exam.app.base.entity.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class ProductOption extends BaseEntity {
    private String color;
    private String size;
    private String displayColor;    // 노출용 색상
    private String displaySize;     // 노출용 사이즈
    private int price;
    private int wholesalePrice;     // 도매가
    @ManyToOne(fetch = LAZY)
    @ToString.Exclude
    private Product product;
    private boolean isSoldOut; // 사입처에서의 품절여부
    private int stockQuantity; // 쇼핑몰에서 보유한 물건 개수

    public ProductOption(String color, String size) {
        this.color = color;
        this.displayColor = color;
        this.size = size;
        this.displaySize = size;
    }

    public boolean isOrderable(int quantity) {
        if (isSoldOut() == false) return true;

        return getStockQuantity() >= quantity;
    }
}