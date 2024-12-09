package org.example.cqrsdemo.query.repository;

import org.example.cqrsdemo.query.ProductView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductViewRepository extends JpaRepository<ProductView, String> {
}
