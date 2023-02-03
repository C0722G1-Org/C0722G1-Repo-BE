package com.c0722g1repobe.service.post.impl;


import com.c0722g1repobe.dto.post.PostDto;
import com.c0722g1repobe.dto.post.PostDtoViewList;
import com.c0722g1repobe.dto.post.PostListViewDto;
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
    private IAddressRepository addressRepository;
    @Autowired
    private IPostRepository postRepository;

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

    /**
     * Created by: UyDD
     * Date Created: 31/01/2023
     *
     * @param pageable
     * @return page post from post repository
     */
    @Override
    public Page<Post> findAllPostByUserNameAccount(Pageable pageable, String userNameAccount) {
        return postRepository.findAllPostByUserNameAccount(pageable, userNameAccount);
    }

    /**
     * Create by: SangNP
     * Date Create: 01/02/2023
     * Description: return list for home page .
     *
     * @param area
     * @param price
     * @param demandType
     * @param direction
     * @param city
     * @param pageable
     * @return an Page<PostListViewDto> or null if not found
     */
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
    /**
     * Method uses:
     * find in database a Post that has and id equal to parameter id, if Post is null or is deleted, return not found http status
     * if Post is found, return Post and OK http status
     * Created by: HuyDN
     * Created date: 31/01/2023
     * Catching NullPointerException
     *
     * @param id: a Post' id
     * @return a Post object that can be showed on Post detail screen
     */
    @Override
    public Post findPostById(Long id) {
        return postRepository.findPostById(id);
    }
    /**
     * Create by: NgocLV
     * Date Create: 01/02/2023
     * Description: delete post .
     *
     * @param idPost
     * @return delete post or null if not found
     */
    @Override
    public void deletePost(Long idPost) {
        postRepository.deletePost(idPost);
    }
    /**
     * Create by: NgocLV
     * Date Create: 01/02/2023
     * Description: find post .
     *
     * @param id
     * @return  post or null if not found
     */
    @Override
    public Post findPost(Long id) {
        return postRepository.findPost(id);
    }
    /**
     * Create by: NgocLV
     * Date Create: 01/02/2023
     * Description: find list post .
     *
     * @param pageable
     * @return  list post or null if not found
     */
      @Override
       public Page<PostDto> findAllPost(Pageable pageable) {
        return postRepository.findAllPost(pageable);}


    /**
     * Method uses:
     * find in database a Post that has and id equal to parameter id, if Post is null or is deleted, return not found http status
     * if Post is found, return Post and OK http status
     * Created by: HuyDN
     * Created date: 31/01/2023
     * Catching NullPointerException
     *
     * @param id: a Post' id
     * @return a Post object that can be showed on Post detail screen
     */
    @Override
    public Post findPostById(Long id) {
        return postRepository.findPostById(id);

    }
    /**
     * Create by: NgocLV
     * Date Create: 01/02/2023
     * Description: approval post .
     *
     * @param id
     * @return  approval post  or null if not found
     */
    @Override
    public void approvalPost(Long id) {
        postRepository.approvalPost(id);
    }
    /**
     * Create by: NgocLV
     * Date Create: 01/02/2023
     * Description: approval post .
     *
     * @param demandTypeSearch
     * @param lendTypeSearch
     * @param minPriceSearch
     * @param maxPriceSearch
     * @param positionSearch
     * @return  list post  or null if not found
     */

    @Override
    public Page<PostDto> searchAllPost(String demandTypeSearch,String lendTypeSearch,Double minPriceSearch,Double maxPriceSearch, String positionSearch ,Pageable pageable) {
        return postRepository.searchAllPost( demandTypeSearch,lendTypeSearch,minPriceSearch, maxPriceSearch, positionSearch,  pageable);
    }
}
