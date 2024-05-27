package com.multi.product.service;


import com.multi.product.entity.Product;

import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id);
}
