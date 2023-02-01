package com.c0722g1repobe.controller.post;

import com.c0722g1repobe.entity.post.Post;
import com.c0722g1repobe.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/post")
public class PostRestController {
    @Autowired
    IPostService iPostService;

    /**
     * Created by: UyDD
     * Date Created: 31/01/2023
     * @param pageable
     * @return HttpStatus.NO_CONTENT if list post is empty or HttpStatus.OK if result have content
     */
    @GetMapping("/{userNameAccount}")
    public ResponseEntity<List<Post>> getPostList(Pageable pageable, @PathVariable String userNameAccount) {
        Page<Post> postList = iPostService.findAllPost(pageable, userNameAccount);
        if (postList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(postList.getContent(), HttpStatus.OK);
    }
}
