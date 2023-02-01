package com.c0722g1repobe.controller.post;


import com.c0722g1repobe.dto.post.PostDto;
import com.c0722g1repobe.dto.post.PostListViewDto;
import com.c0722g1repobe.entity.post.Post;
import com.c0722g1repobe.dto.post.PostDto;
import com.c0722g1repobe.dto.post.create_post.BaseResponseCreatePost;
import com.c0722g1repobe.dto.post.create_post.CreatePostDto;
import com.c0722g1repobe.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/post")
public class PostRestController {
    @Autowired
    private IPostService postService;

    /**

     * Create by: BaoDP
     * Date create: 01/02/2023
     * Description: send BaseResponseCreatePost object to Frontend project for handle response form server
     *
     * @param createPostDto: an object of class CreatePostDto
     * @return ResponseEntity with BaseResponseCreatePost and HttpStatus is code of BaseResponseCreatePost
     */
    @PostMapping("create")
    @ResponseBody
    public ResponseEntity<BaseResponseCreatePost> create(@RequestBody CreatePostDto createPostDto) {
        BaseResponseCreatePost baseResponseCreatePost = postService.getResponseCreatePost(createPostDto);
        return new ResponseEntity<>(baseResponseCreatePost, HttpStatus.valueOf(baseResponseCreatePost.getCode()));
        
     * Create by: SangNP
     * Date created: 31/01/2023
     * Function: show list post
     *
     * @param area       It's okay not to have
     * @param price      It's okay not to have
     * @param demandType It's okay not to have
     * @param direction  It's okay not to have
     * @param city       It's okay not to have
     * @param pageable   It's okay not to have
     * @return if have content it will return Page<Post> with HttpStatus.OK else it will return status HttpStatus.NO_CONTENT
     */
    @GetMapping("")
    public ResponseEntity<Page<PostListViewDto>> getAllPost(@RequestParam(defaultValue = "") String area,
                                                            @RequestParam(defaultValue = "") String price,
                                                            @RequestParam(defaultValue = "") String demandType,
                                                            @RequestParam(defaultValue = "") String direction,
                                                            @RequestParam(defaultValue = "") String city,
                                                            Pageable pageable) {
        if (area != null && price != null && demandType != null && direction != null && city != null) {
            Page<PostListViewDto> postList = postService.findAll(area, price, demandType, direction, city, pageable);
            if (postList != null && postList.hasContent()) {
                return new ResponseEntity<>(postList, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    /**
     * Create by: NgocLV
     * Date created: 31/01/2023
     * Function: show list or search  Post
     *
     * @param demandTypeSearch
     * @param lendTypeSearch
     * @param pageable
     *
     * @return HttpStatus.OK if json list Post
     */
    @GetMapping("")
    public ResponseEntity<Page<PostDto>> listAllPosts(@RequestParam(defaultValue = "") String demandTypeSearch,
                                                      @RequestParam(defaultValue = "") String lendTypeSearch, @PageableDefault(page = 0,size = 3) Pageable pageable) {
        Page<PostDto> listPostDtos;
        if (demandTypeSearch != null || lendTypeSearch != null) {
            listPostDtos = postService.searchAllPost(demandTypeSearch, lendTypeSearch, pageable);
        }else {
            listPostDtos = postService.findAllPost(pageable);
        }
        if(listPostDtos.isEmpty()){
            return new ResponseEntity<Page<PostDto>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Page<PostDto>>(listPostDtos, HttpStatus.OK);
    }

    /**
     * Create by: NgocLV
     * Date created: 31/01/2023
     * Function: delete post
     *
     * @param id
     *
     * @return HttpStatus.OK if have id in database, delete success or HttpStatus.NOT_FOUND if id not found in database
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Post> deletePost(@PathVariable("id") Long id) {
        Post currentPost = postService.findPost(id);
        if (currentPost==null) {
            System.out.println("Post with id " + id + " not found");
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
        postService.deletePost(id);
        return new ResponseEntity<Post>(currentPost, HttpStatus.OK);
    }
    /**
     * Create by: NgocLV
     * Date created: 31/01/2023
     * Function: approval post
     *
     * @param id
     *
     * @return HttpStatus.OK if have id in database, approval success or HttpStatus.NOT_FOUND if id not found in database
     */
    @DeleteMapping("/approval/{id}")
    public ResponseEntity<Post> approvalPost(@PathVariable("id") Long id) {
        Post currentPost = postService.findPost(id);

        if (currentPost==null) {
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
        postService.approvalPost(id);
        return new ResponseEntity<Post>(currentPost, HttpStatus.OK);
    }
}