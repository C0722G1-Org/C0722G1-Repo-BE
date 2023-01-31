package com.c0722g1repobe.controller.post;

import com.c0722g1repobe.entity.post.Post;
import com.c0722g1repobe.service.post.IPostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/post")
public class PostController {

    private IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public ResponseEntity<Page<Post>> getAllPost(@RequestParam(defaultValue = "-1") Double area,
                                                 @RequestParam(defaultValue = "-1") Double price,
                                                 @RequestParam(defaultValue = "")String demandType,
                                                 @RequestParam(defaultValue = "")String direction,
                                                 @RequestParam(defaultValue = "")String city,
                                                 Pageable pageable){
        Page<Post> postList = postService.findAll(area, price, demandType, direction, city, pageable);
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }
}
