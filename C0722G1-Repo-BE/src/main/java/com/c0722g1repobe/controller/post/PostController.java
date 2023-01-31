package com.c0722g1repobe.controller.post;

import com.c0722g1repobe.entity.post.Post;
import com.c0722g1repobe.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("api/post")
public class PostController {

    @Autowired
    private IPostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable("id") Long id) {
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
/**
 * Method uses:
 * find in database a Post that has and id equal to parameter id, if Post is null or is deleted, return not found http status
 * if Post is found, return Post and OK http status
 * Author: HuyDN
 * Parameter: Post's id
 * Return content: return a Post object that can be showed on Post detail screen
 * Catching NullPointerException
 */
