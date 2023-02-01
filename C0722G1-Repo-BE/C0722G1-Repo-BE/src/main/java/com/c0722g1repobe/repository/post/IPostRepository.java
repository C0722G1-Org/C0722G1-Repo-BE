package com.c0722g1repobe.repository.post;

import com.c0722g1repobe.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {
    /**
     *Created by: UyDD
     *Date Created: 31/01/2023
     * @param pageable
     * @return list post from database
     */
    @Query(value = "select * from post" +
            " join direction on post.id_post = direction.id_direction" +
            " join status_post on post.id_post = status_post.id_status_post" +
            " join address on post.id_post = address.id_address" +
            " join demand_type on post.id_post = demand_type.id_demand_type" +
            " join land_type on post.id_post = land_type.id_land_type" +
            " join image_list on post.id_post = image_list.id_image_list" +
            " join customer on post.customer_id_customer = customer.id_customer" +
            " join account on customer.account_id_account = account.id_account" +
            " where account.username_account like :userNameAccount", nativeQuery = true)
    Page<Post> findAllPost(Pageable pageable,@Param("userNameAccount") String userNameAccount);
}
