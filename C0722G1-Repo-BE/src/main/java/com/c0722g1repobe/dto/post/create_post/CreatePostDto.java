package com.c0722g1repobe.dto.post.create_post;

import lombok.Getter;

@Getter
public class CreatePostDto {
    private String codeCustomer;
    private String namePost;
    private Long idDemand;
    private Long idLandType;
    private Long idWards;
    private Long idDirection;
    private String numberAddress;
    private Double price;
    private Double area;
    private String note;
    private String imageListURL;
}
