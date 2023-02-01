package com.c0722g1repobe.controller.post;

import com.c0722g1repobe.dto.post.PostDto;
import com.c0722g1repobe.entity.post.Post;
import com.c0722g1repobe.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/posts")
@CrossOrigin("*")
public class RestPostController {
    @Autowired
    private IPostService iPostService;
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
                                                      @RequestParam(defaultValue = "") String lendTypeSearch,  @PageableDefault(page = 0,size = 3) Pageable pageable) {
        Page<PostDto> listPostDtos;
        if (demandTypeSearch != null || lendTypeSearch != null) {
            listPostDtos = iPostService.searchAllPost(demandTypeSearch, lendTypeSearch, pageable);
        }else {
            listPostDtos = iPostService.findAllPost(pageable);
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
        Post currentPost = iPostService.findPost(id);
        if (currentPost==null) {
            System.out.println("Post with id " + id + " not found");
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
        iPostService.deletePost(id);
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
        Post currentPost = iPostService.findPost(id);

        if (currentPost==null) {
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
        iPostService.approvalPost(id);
        return new ResponseEntity<Post>(currentPost, HttpStatus.OK);
    }
}
