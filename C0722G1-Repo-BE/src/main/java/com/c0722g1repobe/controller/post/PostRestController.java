package com.c0722g1repobe.controller.post;

import com.c0722g1repobe.entity.post.Post;
//import com.c0722g1repobe.dto.post.PostDto;
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
    }
}
