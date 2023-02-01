package com.c0722g1repobe.controller.post;

//import com.c0722g1repobe.entity.post.Post;
//import com.c0722g1repobe.dto.post.PostDto;
//import com.c0722g1repobe.dto.post.create_post.BaseResponseCreatePost;
//import com.c0722g1repobe.dto.post.create_post.CreatePostDto;
import com.c0722g1repobe.dto.post.PostDto;
import com.c0722g1repobe.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
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
    /*DI IPostService to use IPostService's methods;
     Author: DatTQ
     */

    /*Method use: displayList(), call getAll() of IPostService to get list data from database
    * Use ResponseEntity to handling response, datatype: List<PostDto>
    * Parameter: NO
    * If the list returned is an empty list, return http status code : HttpStatus.NO_CONTENT
    * If the list returned is a list with data, then return http status code: HttpStatus.OK and List<PostDto>
    * Author: DatTQ*/
    @GetMapping("")
    public ResponseEntity<List<PostDto>> displayList() {
        List<PostDto> postDtoList = postService.getAll();
        if (postDtoList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }

    /*Method use: search(), call searchYear() and searchYearAndMonth of IPostService to get list data from database
     * Use ResponseEntity to handling response, datatype: List<PostDto>
     * Parameter: Integer year (defaultValue = "-1"), Integer month (defaultValue = "-1")
     * If parameter month is == -1, List<PostDto> = method searchYear of IPostService
     * If parameter year is != -1 and month != -1 => List<PostDto> = method searchYearAndMonth of IPostService
     * If parameter year is == -1 and month != -1 => assign 2 parameters year and month = current year and current month
                => List<PostDto> = method searchYearAndMonth of IPostService
     * If the list returned is an empty list, return http status code : HttpStatus.NO_CONTENT
     * If the list returned is a list with data, then return http status code: HttpStatus.OK and List<PostDto>
     * Author: DatTQ*/
    @GetMapping("/search")
    public ResponseEntity<List<PostDto>> search(@RequestParam(defaultValue = "-1") Integer year, @RequestParam(defaultValue = "-1") Integer month) {
        List<PostDto> postDtoList = null;
        if (month == -1) {
            postDtoList = postService.searchYear(String.valueOf(year));
        }
        if (month != -1 && year == -1) {
            month = new Date().getMonth() + 1;
            year = LocalDate.now().getYear();
            postDtoList = postService.searchYearAndMonth(String.valueOf(year), String.valueOf(month));
        }
        if (month != -1 && year != -1) {
            postDtoList = postService.searchYearAndMonth(String.valueOf(year), String.valueOf(month));
        }
        if (postDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }
}
