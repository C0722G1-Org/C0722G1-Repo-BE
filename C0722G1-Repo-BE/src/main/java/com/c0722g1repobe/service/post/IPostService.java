package com.c0722g1repobe.service.post;

import com.c0722g1repobe.dto.post.create_post.BaseResponseCreatePost;
import com.c0722g1repobe.dto.post.create_post.CreatePostDto;

public interface IPostService {
//    BaseResponseCreatePost validateCreatePost(CreatePostDto createPostDto);
//
//    PostDto addDefaultValue(CreatePostDto createPostDto);
//
//    void savePost(PostDto postDto);

    BaseResponseCreatePost getResponseCreatePost(CreatePostDto createPostDto);
}
