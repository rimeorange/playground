package com.multi.member.service;


import com.multi.product.entity.Product;

import java.util.Optional;

public interface MemberService {

    Optional<Product> findById(Long id);
}
