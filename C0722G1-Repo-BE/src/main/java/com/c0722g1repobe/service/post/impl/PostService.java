package com.c0722g1repobe.service.post.impl;

import com.c0722g1repobe.entity.post.Post;
import com.c0722g1repobe.repository.post.IPostRepository;
import com.c0722g1repobe.service.post.IPostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {
    private IPostRepository postRepository;

    public PostService(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Page<Post> findAll(Double area, Double price, String demandType, String direction, String city, Pageable pageable) {
        if (area == -1 && price == -1){
            return postRepository.findAll(demandType, direction, city, pageable);
        }
        return null;
    }
}
