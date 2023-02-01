package com.c0722g1repobe.service.post.impl;

import com.c0722g1repobe.dto.post.create_post.BaseResponseCreatePost;
import com.c0722g1repobe.dto.post.create_post.CreatePostDto;
import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.entity.post.*;
import com.c0722g1repobe.repository.post.AddressRepository;
import com.c0722g1repobe.repository.post.PostRepository;
import com.c0722g1repobe.service.post.IPostService;
import com.c0722g1repobe.validation.post.IValidateCreatePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PostService implements IPostService {
    @Autowired
    private IValidateCreatePost validateCreatePost;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PostRepository postRepository;


    /**
     * Create by: BaoDP
     * Date Create: 01/02/2023
     * Description: call method validateCreatePost from class ValidateCreatePost.
     *
     * @param createPostDto : an object of class CreatePostDto
     * @return an object of class BaseResponseCreatePost
     */
    private BaseResponseCreatePost validateCreatePost(CreatePostDto createPostDto) {
        return validateCreatePost.validateCreatePost(createPostDto);
    }

    /**
     * Create by: BaoDP
     * Date Create: 01/02/2023
     * Description: transfer attributes form createPostDto to an object of class Post and add another default value to it.
     *
     * @param createPostDto : an object of class CreatePostDto
     * @return an object of class PostDto
     */
    private Post addDefaultValue(CreatePostDto createPostDto) {

        Long defaultIdStatus = 1L;

        addressRepository.saveAddress(createPostDto.getNumberAddress(), createPostDto.getIdWards());
        Long idAddress = addressRepository.findIdByNumberAddressAndIdWardsNativeQuery(createPostDto.getNumberAddress(), createPostDto.getIdWards());

        return Post.builder()
                .approval(false)
                .area(createPostDto.getArea())
                .dateCreation(LocalDate.now())
                .flagDeleted(false)
                .namePost(createPostDto.getNamePost())
                .note(createPostDto.getNote())
                .price(createPostDto.getPrice())
                .address(Address.builder().idAddress(idAddress).build())
                .demandType(DemandType.builder().idDemandType(createPostDto.getIdDemand()).build())
                .direction(Direction.builder().idDirection(createPostDto.getIdDirection()).build())
                .imageListURL(createPostDto.getImageListURL())
                .landType(LandType.builder().idLandType(createPostDto.getIdLandType()).build())
                .statusPost(StatusPost.builder().idStatusPost(defaultIdStatus).build())
                .customer(Customer.builder().idCustomer(createPostDto.getIdCustomer()).build())
                .build();
    }

    /**
     * Create by: BaoDP
     * Date Create: 01/02/2023
     * Description: call method savePost from PostRepository to save Post.
     *
     * @param post : an object of class PostDto
     */
    private void savePost(Post post) {
        postRepository.savePost(post);
    }

    /**
     * Create by: BaoDP
     * Date Create: 01/02/2023
     * Description: if createPostDto is valid then save Post before send BaseResponseCreatePost to Front-end project for handle http status code .
     *
     * @param createPostDto : an object of class CreatePostDto
     * @return an object of class BaseResponseCreatePost
     */
    @Override
    public BaseResponseCreatePost getResponseCreatePost(CreatePostDto createPostDto) {
        BaseResponseCreatePost baseResponseCreatePost = validateCreatePost(createPostDto);

        int validCode = 200;
        boolean validCreatePostDto = baseResponseCreatePost.getCode() == validCode;
        if (validCreatePostDto) {
            Post post = addDefaultValue(createPostDto);
            savePost(post);
            // gửi notification ở đoạn này
        }

        return baseResponseCreatePost;
    }
}
