package com.c0722g1repobe.controller.post;

import com.c0722g1repobe.dto.post.create_post.BaseResponseCreatePost;
import com.c0722g1repobe.dto.post.create_post.CreatePostDto;
import com.c0722g1repobe.service.post.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/post")
public class PostRestController {
    private final IPostService postService;

    public PostRestController(IPostService postService) {
        this.postService = postService;
    }

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
    }
}
