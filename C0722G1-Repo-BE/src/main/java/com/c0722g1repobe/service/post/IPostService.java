package com.c0722g1repobe.service.post;


import com.c0722g1repobe.dto.post.PostDto;
import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IPostService {
    /**
     * Create by: NgocLV
     * Date created: 31/01/2023
     * Function: delete post
     *
     * @param idPost
     *
     */
    void deletePost(Long idPost);
    /**
     * Create by: NgocLV
     * Date created: 31/01/2023
     * Function: search post
     *
     * @param id
     *
     * @return json  post
     */
    Post findPost(Long id);
    /**
     * Create by: NgocLV
     * Date created: 31/01/2023
     * Function: search list posts
     *
     * @param demandTypeSearch
     * @param lendTypeSearch
     * @param pageable
     *
     * @return json list posts
     */
    Page<PostDto> searchAllPost(String demandTypeSearch, String lendTypeSearch, Pageable pageable);
    /**
     * Create by: NgocLV
     * Date created: 31/01/2023
     * Function: show list posts
     *
     * @param pageable
     *
     * @return json list posts
     */
    Page<PostDto> findAllPost( Pageable pageable);
    /**
     * Create by: NgocLV
     * Date created: 31/01/2023
     * Function: approval post
     *
     * @param id
     *
     */
    void approvalPost( Long id);
}
