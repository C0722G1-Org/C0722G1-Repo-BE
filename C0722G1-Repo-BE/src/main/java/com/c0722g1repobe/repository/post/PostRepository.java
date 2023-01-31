package com.c0722g1repobe.repository.post;

import com.c0722g1repobe.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "insert into sprint_1.post " +
            "(approval, " +
            "area, " +
            "description_post, " +
            "flag_deleted," +
            "name_post," +
            "note," +
            "price," +
            "address_id_address," +
            "demand_type_id_demand_type," +
            "direction_id_direction," +
            "image_list_id_image_list," +
            "land_type_id_land_type," +
            "status_post_id_status_post) " +
            "VALUES (:#{post.approval}," +
            ":#{post.area}," +
            ":#{post.descriptionPost}," +
            "b'1'," +
            "b'1'," +
            "b'1'," +
            "b'1'," +
            "b'1'," +
            "b'1'," +
            "b'1'," +
            "b'1'," +
            "b'1'," +
            "b'1')",
    nativeQuery = true)
    boolean savePost(@Param("post") Post post);
}
