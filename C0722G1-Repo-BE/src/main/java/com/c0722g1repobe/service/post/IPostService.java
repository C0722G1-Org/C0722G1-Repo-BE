package com.c0722g1repobe.service.post;

import com.c0722g1repobe.dto.post.PostDtoViewList;

import java.util.List;

public interface IPostService {
    /*Method use: getAll()
     * Get List data of required attributes
     * Use interface PostDto
     * Parameter: NO
     * Author: DatTQ
     * */
    List<PostDtoViewList> getAll();

    /*Method uses: searchYear(String year)
     * Get List data of required attributes
     * Use interface PostDto
     * Parameter: String year
     * Author: DatTQ*/
    List<PostDtoViewList> searchYear(String year);

    /*Method uses: searchYear(@Param("year") String year,@Param("month") String month )
     * Get List data of required attributes
     * Use interface PostDto
     * Parameter: String year,String month
     * Author: DatTQ*/
    List<PostDtoViewList> searchYearAndMonth(String year, String month);
}
