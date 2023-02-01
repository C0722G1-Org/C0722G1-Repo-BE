package com.c0722g1repobe.controller.post;

import com.c0722g1repobe.dto.post.PostListViewDto;
import com.c0722g1repobe.entity.post.Post;
import com.c0722g1repobe.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
}
