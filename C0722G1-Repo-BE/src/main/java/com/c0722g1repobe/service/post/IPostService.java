package com.c0722g1repobe.service.post;

import com.c0722g1repobe.entity.post.Post;
import org.springframework.data.repository.query.Param;

public interface IPostService {
    /**
     * Method uses:
     * find in database a Post that has and id equal to parameter id, if Post is null or is deleted, return not found http status
     * if Post is found, return Post and OK http status
     * Created by: HuyDN
     * Created date: 31/01/2023
     * Catching NullPointerException
     * @param id:  a Post' id
     * @return a Post object that can be showed on Post detail screen
     */
    Post findPostById(@Param("id") Long id);
}