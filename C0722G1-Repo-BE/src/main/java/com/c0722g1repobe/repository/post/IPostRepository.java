package com.c0722g1repobe.repository.post;

import com.c0722g1repobe.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {
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
    @Query(value = "select post.name_post, " +
            "post.area, " +
            "post.note_post, " +
            "post.description_post, " +
            "post.price, " +
            "post.approval, " +
            "post.date_creation, " +
            "direction.name, " +
            "status_post.nam_status_post, " +
            "address.number_address, " +
            "demand_type.name_demand_type, " +
            "land_type.name_land_type, " +
            "image_list.url, " +
            "wards.name_wards, " +
            "district.name_district, " +
            "city.name_city" +
            "customer.name, customer.email_customer from post join direction " +
            "on post.direction_id_direction = direction.id_direction join status_post " +
            "on post.status_post_id_status_post = status_post.id_status_post join address " +
            "on post.address_id_address = address.id_address join demand_type " +
            "on post.demand_type_id_demand_type = demand_type.id_demand_type join image_list " +
            "on post.image_list_id_image_list = image_list.id_image_list join customer " +
            "on post.id_customer = customer.id_customer join wards " +
            "on address.wards_id_wards = wards.id_wards join district " +
            "on wards.district_id_district = district.id_district join city " +
            "on district.city_id_city = city.id_city" +
            "where post.id_post = %:id% and flag_deleted = false",
            countQuery = "select post.name_post," +
                    "            post.area," +
                    "            post.note_post," +
                    "            post.description_post," +
                    "            post.price," +
                    "            post.approval," +
                    "            post.date_creation," +
                    "            direction.name," +
                    "            status_post.nam_status_post," +
                    "            address.number_address," +
                    "            demand_type.name_demand_type," +
                    "            land_type.name_land_type," +
                    "            image_list.url," +
                    "            wards.name_wards, " +
                    "            district.name_district, " +
                    "            city.name_city" +
                    "            customer.name, customer.email_customer from post join direction" +
                    "            on post.direction_id_direction = direction.id_direction join status_post" +
                    "            on post.status_post_id_status_post = status_post.id_status_post join address" +
                    "            on post.address_id_address = address.id_address join demand_type" +
                    "            on post.demand_type_id_demand_type = demand_type.id_demand_type join image_list" +
                    "            on post.image_list_id_image_list = image_list.id_image_list join customer" +
                    "            on post.id_customer = customer.id_customer join wards " +
                    "            on address.wards_id_wards = wards.id_wards join district " +
                    "            on wards.district_id_district = district.id_district join city " +
                    "            on district.city_id_city = city.id_city" +
                    "            where post.id_post = %:id% and flag_deleted = false"
            , nativeQuery = true)
    Post findPostById(@Param("id") Long id);
}