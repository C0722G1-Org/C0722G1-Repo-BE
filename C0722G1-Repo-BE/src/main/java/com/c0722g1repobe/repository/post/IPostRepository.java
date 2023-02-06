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
     *
     * @param pageable
     * @return list post customer from database
     */

    @Query(value = "select * from `post`" +
            " join `direction` on post.direction_id_direction = `direction`.id_direction" +
            " join status_post on post.status_post_id_status_post = status_post.id_status_post" +
            " join `address` on post.address_id_address = `address`.id_address" +
            " join demand_type on post.demand_type_id_demand_type = demand_type.id_demand_type" +
            " join land_type on post.land_type_id_land_type = land_type.id_land_type" +
            " join `customer` on post.customer_id_customer = `customer`.id_customer" +
            " join `account` on customer.account_id_account = `account`.id_account" +
            " where demand_type.name_demand_type like %:nameDemandTypeSearch% and `account`.id_account = :idAccount", nativeQuery = true)
    Page<Post> getAllAndSearchWithRoleCustomer(@Param("nameDemandTypeSearch") String nameDemandTypeSearch, @Param("idAccount") String idAccount, Pageable pageable);
    /**
     * Created by: UyDD
     * Date Created: 31/01/2023
     *
     * @param pageable
     * @return list post customer from database
     */
    @Query(value = "select * from `post`" +
            " join `direction` on post.direction_id_direction = `direction`.id_direction" +
            " join status_post on post.status_post_id_status_post = status_post.id_status_post" +
            " join `address` on post.address_id_address = `address`.id_address" +
            " join demand_type on post.demand_type_id_demand_type = demand_type.id_demand_type" +
            " join land_type on post.land_type_id_land_type = land_type.id_land_type" +
            " join `customer` on post.customer_id_customer = `customer`.id_customer" +
            " where demand_type.name_demand_type like %:nameDemandTypeSearch% and `customer`.id_customer = :idCustomer", nativeQuery = true)
    Page<Post> getAllAndSearchWithRoleAdmin(@Param("nameDemandTypeSearch") String nameDemandTypeSearch, @Param("idCustomer") String idCustomer, Pageable pageable);

}
