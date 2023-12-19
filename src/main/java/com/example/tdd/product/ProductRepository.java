package com.example.tdd.product;

import java.util.HashMap;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Product, Long> {

}
