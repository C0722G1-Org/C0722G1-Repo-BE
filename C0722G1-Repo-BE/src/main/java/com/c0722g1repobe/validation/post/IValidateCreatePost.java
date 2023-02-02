package com.c0722g1repobe.validation.post;

import com.c0722g1repobe.dto.post.create_post.BaseResponseCreatePost;
import com.c0722g1repobe.dto.post.create_post.CreatePostDto;

public interface IValidateCreatePost {
    BaseResponseCreatePost validateCreatePost(CreatePostDto createPostDto);
//
//    BaseResponseCreatePost validateIdCustomer(CreatePostDto createPostDto);
//
//    BaseResponseCreatePost validateIdDemand(CreatePostDto createPostDto);
//
//    BaseResponseCreatePost validateIdLandType(CreatePostDto createPostDto);
//
//    BaseResponseCreatePost validateIdWards(CreatePostDto createPostDto);
//
//    BaseResponseCreatePost validateIdDirection(CreatePostDto createPostDto);
//
//    BaseResponseCreatePost validateNumberAddress(CreatePostDto createPostDto);
//
//    BaseResponseCreatePost validatePrice(CreatePostDto createPostDto);
//
//    BaseResponseCreatePost validateArea(CreatePostDto createPostDto);
//
//    BaseResponseCreatePost validateNote(CreatePostDto createPostDto);
//
//    BaseResponseCreatePost validateExistAddressSameDemand(CreatePostDto createPostDto);
//
//    BaseResponseCreatePost validateImageListURL(CreatePostDto createPostDto);
}
