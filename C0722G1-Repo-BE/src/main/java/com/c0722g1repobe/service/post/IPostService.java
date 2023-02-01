package com.c0722g1repobe.service.post;
import com.c0722g1repobe.dto.post.create_post.BaseResponseCreatePost;
import com.c0722g1repobe.dto.post.create_post.CreatePostDto;

import org.springframework.data.repository.query.Param;
import com.c0722g1repobe.dto.post.PostDto;
import com.c0722g1repobe.dto.post.PostListViewDto;
import com.c0722g1repobe.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService {

//    BaseResponseCreatePost validateCreatePost(CreatePostDto createPostDto);
//
//    PostDto addDefaultValue(CreatePostDto createPostDto);
//
//    void savePost(PostDto postDto);

    BaseResponseCreatePost getResponseCreatePost(CreatePostDto createPostDto);

    Page<PostListViewDto> findAll(String area, String price, String demandType, String direction, String city, Pageable pageable);
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
    Page<PostDto> findAllPost(Pageable pageable);
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
