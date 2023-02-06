package com.c0722g1repobe.service.post;

import com.c0722g1repobe.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService {
    /**
     * Created by: UyDD
     * Date Created: 31/01/2023
     *
     * @param pageable
     * @return page post customer
     */

    Page<Post> getAllAndSearchWithRoleAdmin(String nameDemandTypeSearch, String idCustomer, Pageable pageable);
    Page<Post> getAllAndSearchWithRoleCustomer(String nameDemandTypeSearch, String idAccount, Pageable pageable);
}
