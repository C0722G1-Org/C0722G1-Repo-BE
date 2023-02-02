package com.c0722g1repobe.service.post.impl;

import com.c0722g1repobe.dto.post.create_post.BaseResponseCreatePost;
import com.c0722g1repobe.dto.post.create_post.CreatePostDto;
import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.entity.post.*;
import com.c0722g1repobe.repository.post.IAddressRepository;
import com.c0722g1repobe.repository.post.IPostRepository;
import com.c0722g1repobe.service.post.IPostService;
import com.c0722g1repobe.validation.post.IValidateCreatePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;

import com.c0722g1repobe.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class PostService implements IPostService {
    @Autowired
    private IValidateCreatePost validateCreatePost;
    @Autowired
    private iAddressRepository iAddressRepository;
    @Autowired
    private IPostRepository iPostRepository;

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

        iAddressRepository.saveAddress(createPostDto.getNumberAddress(), createPostDto.getIdWards());
        Long idAddress = iAddressRepository.findIdByNumberAddressAndIdWardsNativeQuery(createPostDto.getNumberAddress(), createPostDto.getIdWards());

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
        iPostRepository.savePost(post);
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

    /**
     * Created by: UyDD
     * Date Created: 31/01/2023
     *
     * @param pageable
     * @return page post from post repository
     */
    @Override
    public Page<Post> findAllPostByUserNameAccount(Pageable pageable, String userNameAccount) {
        return iPostRepository.findAllPostByUserNameAccount(pageable, userNameAccount);
    }

    private IPostRepository postRepository;

    public PostService(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Page<PostListViewDto> findAll(String area, String price, String demandType, String direction, String
            city, Pageable pageable) {
        if (area.equals("") && price.equals("")) {
            return postRepository.findAllWithDemandTypeDirectionCity(demandType, direction, city, pageable);
        }
        if (!area.equals("") && price.equals("")) {
            String[] arr = area.split("-");
            if (arr.length == 2) {
                Double areaMin = Double.parseDouble(arr[0]);
                Double areaMax = Double.parseDouble(arr[1]);
                return postRepository.findAllWithDemandTypeDirectionCityArea(demandType, direction, city, areaMin, areaMax, pageable);
            }
        }
        if (area.equals("") && !price.equals("")) {
            String[] arr = price.split("-");
            if (arr.length == 2) {
                Double priceMin = Double.parseDouble(arr[0]);
                Double priceMax = Double.parseDouble(arr[1]);
                return postRepository.findAllWithDemandTypeDirectionCityPrice(demandType, direction, city, priceMin, priceMax, pageable);
            }
        }
        if (!area.equals("") && !price.equals("")) {
            String[] arrOfArea = area.split("-");
            String[] arrOfPrice = price.split("-");
            if (arrOfArea.length == 2 && arrOfPrice.length == 2) {
                Double areaMin = Double.parseDouble(arrOfArea[0]);
                Double areaMax = Double.parseDouble(arrOfArea[1]);
                Double priceMin = Double.parseDouble(arrOfPrice[0]);
                Double priceMax = Double.parseDouble(arrOfPrice[1]);
                return postRepository.findAllWithDemandTypeDirectionCityAreaPrice(demandType, direction, city, areaMin, areaMax, priceMin, priceMax, pageable);
            }
        }
        return null;
    }

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
        return iPostRepository.searchAllPost(demandTypeSearch, lendTypeSearch, pageable);
    }
}
