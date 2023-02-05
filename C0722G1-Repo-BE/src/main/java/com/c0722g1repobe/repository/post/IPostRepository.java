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
     * Created by: UyDD
     * Date Created: 31/01/2023
     * @param pageable
     * @return list post from database
     */
//    @Query(value = "select * from post" +
//            " join direction on post.id_post = direction.id_direction" +
//            " join status_post on post.id_post = status_post.id_status_post" +
//            " join address on post.id_post = address.id_address" +
//            " join demand_type on post.id_post = demand_type.id_demand_type" +
//            " join land_type on post.id_post = land_type.id_land_type" +
//            " join customer on post.customer_id_customer = customer.id_customer" +
//            " where customer.id_customer like :idCustomer", nativeQuery = true)
//    Page<Post> findAllPostByIdCustomer(Pageable pageable, @Param("idCustomer") String idCustomer);

    @Query(value = "select * from post" +
            " join direction on post.id_post = direction.id_direction" +
            " join status_post on post.id_post = status_post.id_status_post" +
            " join address on post.id_post = address.id_address" +
            " join demand_type on post.id_post = demand_type.id_demand_type" +
            " join land_type on post.id_post = land_type.id_land_type" +
            " join customer on post.customer_id_customer = customer.id_customer" +
            " where demand_type.name_demand_type like :nameDemandTypeSearch and customer.id_customer = :idCustomer", nativeQuery = true)
    Page<Post> getAllAndSearch(@Param("nameDemandTypeSearch") String nameDemandTypeSearch, @Param("idCustomer") String idCustomer, Pageable pageable);
}
