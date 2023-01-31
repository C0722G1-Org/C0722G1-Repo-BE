package com.c0722g1repobe.service.post;

import com.c0722g1repobe.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService {
    Page<Post> findAll(Double area, Double price, String demandType, String direction, String city, Pageable pageable);
}
