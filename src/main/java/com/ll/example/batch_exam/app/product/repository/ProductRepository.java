package com.ll.example.batch_exam.app.product.repository;

import com.ll.example.batch_exam.app.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
