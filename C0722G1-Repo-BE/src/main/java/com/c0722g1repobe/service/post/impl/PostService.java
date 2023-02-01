package com.c0722g1repobe.service.post.impl;

import com.c0722g1repobe.dto.post.PostDtoViewList;
import com.c0722g1repobe.repository.post.IPostRepository;
import com.c0722g1repobe.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    private IPostRepository postRepository;
    /*DI IPostRepository to use IPostRepository's methods
     * Author: DatTQ*/

    /*Call method getAll() of IPostRepository
     * Author: DatTQ*/
    @Override
    public List<PostDtoViewList> getAll() {
        return postRepository.getAll();
    }

    /*Call method searchYear(String year) of IPostRepository
      Parameter: String year
      Author: DatTQ */
    @Override
    public List<PostDtoViewList> searchYear(String year) {
        return postRepository.searchYear(year);
    }

    /*Call method searchYear(String year, String month) of IPostRepository
     Parameter: String year, String month
     Author: DatTQ */
    @Override
    public List<PostDtoViewList> searchYearAndMonth(String year, String month) {
        return postRepository.searchYearAndMonth(year, month);
    }
}
