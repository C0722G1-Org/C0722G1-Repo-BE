package com.c0722g1repobe.service.post.impl;

import com.c0722g1repobe.entity.post.Post;
import com.c0722g1repobe.repository.post.IPostRepository;
import com.c0722g1repobe.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {
    @Autowired
    IPostRepository iPostRepository;

    /**
     *Created by: UyDD
     * Date Created: 31/01/2023
     * @param pageable
     * @return page post from post repository
     */
    @Override
    public Page<Post> findAllPost(Pageable pageable) {
        return iPostRepository.findAllPost(pageable);
    }
}
