package com.c0722g1repobe.service.post;

import com.c0722g1repobe.dto.post.PostDto;
import com.c0722g1repobe.entity.post.Post;
import com.c0722g1repobe.repository.post.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository iPostRepository;
    @Override
    public void deletePost(Long idPost) {
        iPostRepository.deletePost(idPost);
    }

    @Override
    public Post findPost(Long id) {
        return iPostRepository.findPost(id);
    }



    @Override
    public Page<PostDto> findAllPost(Pageable pageable) {
        return iPostRepository.findAllPost(pageable);
    }

    @Override
    public void approvalPost(Long id) {
        iPostRepository.approvalPost(id);
    }

    @Override
    public Page<PostDto> searchAllPost(String demandTypeSearch, String lendTypeSearch, Pageable pageable) {
        return iPostRepository.searchAllPost( demandTypeSearch,lendTypeSearch, pageable);
    }
}
