package com.c0722g1repobe.service.post.impl;

import com.c0722g1repobe.dto.post.PostListViewDto;
import com.c0722g1repobe.entity.post.Post;
import com.c0722g1repobe.repository.post.IPostRepository;
import com.c0722g1repobe.service.post.IPostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {
    private IPostRepository postRepository;

    public PostService(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Page<PostListViewDto> findAll(String area, String price, String demandType, String direction, String city, Pageable pageable) {
        if (area.equals("") && price.equals("")){
            return postRepository.findAllWithDemandTypeDirectionCity(demandType, direction, city, pageable);
        }
        if (!area.equals("") && price.equals("")){
            String[] arr = area.split("-");
            if (arr.length == 2){
                Double areaMin = Double.parseDouble(arr[0]);
                Double areaMax = Double.parseDouble(arr[1]);
                return postRepository.findAllWithDemandTypeDirectionCityArea(demandType, direction, city, areaMin, areaMax, pageable);
            }
        }
        if (area.equals("") && !price.equals("")){
            String[] arr = price.split("-");
            if (arr.length == 2){
                Double priceMin = Double.parseDouble(arr[0]);
                Double priceMax = Double.parseDouble(arr[1]);
                return postRepository.findAllWithDemandTypeDirectionCityPrice(demandType, direction, city, priceMin, priceMax, pageable);
            }
        }
        if (!area.equals("") && !price.equals("")){
            String[] arrOfArea = area.split("-");
            String[] arrOfPrice = price.split("-");
            if (arrOfArea.length == 2 && arrOfPrice.length ==2){
                Double areaMin = Double.parseDouble(arrOfArea[0]);
                Double areaMax = Double.parseDouble(arrOfArea[1]);
                Double priceMin = Double.parseDouble(arrOfPrice[0]);
                Double priceMax = Double.parseDouble(arrOfPrice[1]);
                return postRepository.findAllWithDemandTypeDirectionCityAreaPrice(demandType, direction, city, areaMin, areaMax, priceMin, priceMax, pageable);
            }
        }
        return null;
    }
}
