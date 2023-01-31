package com.c0722g1repobe.service.post;

import com.c0722g1repobe.dto.post.PostDto;

import java.util.List;

public interface IPostService {
    /*Method use: getAll()
     * Get List data of required attributes
     * Use interface PostDto
     * Parameter: NO
     * Author: DatTQ
     * */
    List<PostDto> getAll();

    /*Method uses: searchYear(String year)
     * Get List data of required attributes
     * Use interface PostDto
     * Parameter: String year
     * Author: DatTQ*/
    List<PostDto> searchYear(String year);

    /*Method uses: searchYear(@Param("year") String year,@Param("month") String month )
     * Get List data of required attributes
     * Use interface PostDto
     * Parameter: String year,String month
     * Author: DatTQ*/
    List<PostDto> searchYearAndMonth(String year,String month);
}
