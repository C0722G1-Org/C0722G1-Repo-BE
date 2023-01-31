package com.c0722g1repobe.repository.post;

import com.c0722g1repobe.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {
    @Query(value = "select name_post, " +
            "area, " +
            "note_post, " +
            "description_post, " +
            "price, " +
            "approval, " +
            "date_creation, " +
            "direction, " +
            "status_post, " +
            "address, " +
            "demand_type, " +
            "land_type, " +
            "image_list," +
            "customer from post where post.id_post = %:id% and flag_deleted = false "
            , nativeQuery = true)
    Post findPostById(@Param("id") Long id);
}

/**
 * Method uses:
 * find in database a Post that has and id equal to parameter id, if Post is null or is deleted, return not found http status
 * if Post is found, return Post and OK http status
 * Author: HuyDN
 * Parameter: Post's id
 * Return content: return a Post object that can be showed on Post detail screen
 * Catching NullPointerException
 */