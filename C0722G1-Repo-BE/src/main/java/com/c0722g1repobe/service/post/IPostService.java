package com.c0722g1repobe.service.post;
import com.c0722g1repobe.dto.post.PostDtoViewList;

import java.util.List;

import com.c0722g1repobe.dto.post.create_post.BaseResponseCreatePost;
import com.c0722g1repobe.dto.post.create_post.CreatePostDto;
import org.springframework.data.repository.query.Param;
import com.c0722g1repobe.dto.post.PostDto;
import com.c0722g1repobe.dto.post.PostListViewDto;
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

    /*Method use: getAll()
     * Get List data of required attributes
     * Use interface PostDto
     * Parameter: NO
     * Author: DatTQ
     * */
    List<PostDtoViewList> getAll();

    /*Method uses: searchYear(String year)
     * Get List data of required attributes
     * Use interface PostDto
     * Parameter: String year
     * Author: DatTQ*/
    List<PostDtoViewList> searchYear(String year);

    /*Method uses: searchYear(@Param("year") String year,@Param("month") String month )
     * Get List data of required attributes
     * Use interface PostDto
     * Parameter: String year,String month
     * Author: DatTQ*/
    List<PostDtoViewList> searchYearAndMonth(String year, String month);

//    BaseResponseCreatePost validateCreatePost(CreatePostDto createPostDto);
//
//    PostDto addDefaultValue(CreatePostDto createPostDto);
//
//    void savePost(PostDto postDto);

    BaseResponseCreatePost getResponseCreatePost(CreatePostDto createPostDto);

    /**
     * Method uses:
     * find all list posts for homepage
     * Created by: SangNP
     * Created date: 31/01/2023
     * @param area
     * @param price
     * @param landType
     * @param direction
     * @param city
     * @param pageable
     * @return Page<PostListViewDto> and null if not found
     */
    Page<PostListViewDto> findAll(String area, String price, String landType, String direction, String city, Pageable pageable);
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
     *Created by: NgocLV
     * Date Created: 31/01/2023
     *
     * @param demandTypeSearch
     * @param lendTypeSearch
     * @param pageable
     * @param minPriceSearch
     * @param maxPriceSearch
     *
     * @return json list posts
     */
    Page<PostDto> searchAllPost(String demandTypeSearch,String lendTypeSearch,Double minPriceSearch,Double maxPriceSearch, String positionSearch ,Pageable pageable);
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
