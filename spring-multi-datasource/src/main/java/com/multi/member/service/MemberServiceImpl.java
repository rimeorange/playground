package com.multi.member.service;

import com.multi.product.entity.Product;
import com.multi.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final ProductRepository productRepository;

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
