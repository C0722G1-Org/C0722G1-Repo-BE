package com.c0722g1repobe.service.post;

import com.c0722g1repobe.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService {
    /**
     *Created by: UyDD
     * Date Created: 31/01/2023
     * @param pageable
     * @return page post
     */
    Page<Post> findAllPostByUserNameAccount(Pageable pageable, String userNameAccount);
}
