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
    IPostRepository PostRepository;

    /**
     * Created by: UyDD
     * Date Created: 31/01/2023
     *
     * @param pageable
     * @return page post customer from post repository with role admin
     */

    @Override
    public Page<Post> getAllAndSearchWithRoleAdmin(String nameDemandTypeSearch, String idCustomer, Pageable pageable) {
        return PostRepository.getAllAndSearchWithRoleAdmin(nameDemandTypeSearch, idCustomer, pageable);
    }

    /**
     * Created by: UyDD
     * Date Created: 31/01/2023
     *
     * @param pageable
     * @return page post customer from post repository with role customer
     */
    @Override
    public Page<Post> getAllAndSearchWithRoleCustomer(String nameDemandTypeSearch, String idAccount, Pageable pageable) {
        return PostRepository.getAllAndSearchWithRoleCustomer(nameDemandTypeSearch, idAccount, pageable);
    }
}
