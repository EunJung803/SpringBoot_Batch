package com.ll.example.batch_exam.app.cart.service;

import com.ll.example.batch_exam.app.cart.entity.CartItem;
import com.ll.example.batch_exam.app.cart.repository.CartItemRepository;
import com.ll.example.batch_exam.app.member.entity.Member;
import com.ll.example.batch_exam.app.product.entity.ProductOption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartItemRepository cartItemRepository;

    public CartItem addItem(Member member, ProductOption productOption, int quantity) {
        CartItem oldCartItem = cartItemRepository.findByMemberIdAndProductOptionId(member.getId(), productOption.getId()).orElse(null);

        if ( oldCartItem != null ) {
            oldCartItem.setQuantity(oldCartItem.getQuantity() + quantity);
            cartItemRepository.save(oldCartItem);

            return oldCartItem;
        }

        CartItem cartItem = CartItem.builder()
                .member(member)
                .productOption(productOption)
                .quantity(quantity)
                .build();

        cartItemRepository.save(cartItem);

        return cartItem;
    }

    public void deleteItem(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }

    public List<CartItem> getItemsByMember(Member member) {
        return cartItemRepository.findAllByMemberId(member.getId());
    }
}