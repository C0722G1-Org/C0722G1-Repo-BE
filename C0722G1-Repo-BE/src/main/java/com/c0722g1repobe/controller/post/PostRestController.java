package com.c0722g1repobe.controller.post;

import com.c0722g1repobe.entity.post.Post;
import com.c0722g1repobe.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/post")
public class PostRestController {
    @Autowired
    private IPostService postService;

    /**
     * Method uses:
     * find in database a Post that has and id equal to parameter id, if Post is null or is deleted, return not found http status
     * if Post is found, return Post and OK http status
     * Created by: HuyDN
     * Created date: 31/01/2023
     * Catching NullPointerException
     *
     * @param id: a Post' id
     * @return a Post object that can be showed on Post detail screen
     */

    @GetMapping("/detail")
    public ResponseEntity<Post> findPostById(@RequestParam Long id) {

        Post post = postService.findPostById(id);
        try {
            if (post == null || post.isFlagDeleted()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NullPointerException e) {
            e.getStackTrace();
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}