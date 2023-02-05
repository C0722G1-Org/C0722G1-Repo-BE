package com.c0722g1repobe.controller.post;

import com.c0722g1repobe.entity.post.Post;
import com.c0722g1repobe.service.post.IPostService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/post")
public class PostRestController {
    @Autowired
    private IPostService postService;

    /**
     * Created by: UyDD
     * Date Created: 31/01/2023
     *
     * @param pageable
     * @return HttpStatus.NO_CONTENT if list post is empty or HttpStatus.OK if result have content
     */

    @GetMapping("search-page")
    public ResponseEntity<?> getAllAndSearch(@PageableDefault(value = 4) Pageable pageable, @RequestParam String nameDemandTypeSearch, @RequestParam String idCustomer) {
        Page<Post> postList = postService.getAllAndSearch(nameDemandTypeSearch, idCustomer, pageable);
        if (postList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }
}
