package com.c0722g1repobe.repository.post;

import com.c0722g1repobe.dto.post.PostDto;
import com.c0722g1repobe.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IPostRepository  extends JpaRepository<Post, Long> {
    /**
     * Create by: NgocLV
     * Date created: 31/01/2023
     * Function: delete post
     *
     * @param id
     */
    @Modifying
    @Query(value = "UPDATE post" +
            " SET flag_deleted = true" +
            " WHERE id_post = :id",
            nativeQuery = true)
    @Transactional
    void deletePost(@Param("id") Long id);

    /**
     * Create by: NgocLV
     * Date created: 31/01/2023
     * Function: find Post by id
     *
     * @param id
     *
     * @return object Post
     */
    @Query(value = "SELECT * " +
            "FROM post " +
            "WHERE flag_deleted = false and id_post = :id",
            nativeQuery = true)
    Post findPost(@Param("id") Long id);
    /**
     * Create by: NgocLV
     * Date created: 31/01/2023
     * Function: search all Post
     *
     * @param demandTypeSearch
     * @param lendTypeSearch
     * @param pageable
     *
     * @return json list Posts searched
     */

@Query(value = "select p.id_post as idPost, c.code_customer as codeCustomer, d.name_demand_type as demandType, l.name_land_type as landType, a.number_address as position, p.area as area, p.note as note, p.approval_id_approval as approval, p.price as price \n" +
        "from post p left join customer as c on p.customer_id_customer = c.id_customer left join demand_type as d on p.demand_type_id_demand_type = d.id_demand_type \n" +
        "left join land_type as l on l.id_land_type = p.land_type_id_land_type left join address as a on a.id_address = p.address_id_address where p.flag_deleted = false and (d.name_demand_type like concat('%', :demandTypeSearch, '%')  and  l.name_land_type like concat('%', :lendTypeSearch, '%'))",
        countQuery = "select p.id_post as idPost, c.code_customer as codeCustomer, d.name_demand_type as demandType, l.name_land_type as landType, a.number_address as position, p.area as area, p.note as note, p.approval_id_approval as approval \n" +
                "from post p left join customer as c on p.customer_id_customer = c.id_customer left join demand_type as d on p.demand_type_id_demand_type = d.id_demand_type \n" +
                "left join land_type as l on l.id_land_type = p.land_type_id_land_type left join address as a on a.id_address = p.address_id_address where p.flag_deleted = false and (d.name_demand_type like concat('%', :demandTypeSearch, '%')  and  l.name_land_type like concat('%', :lendTypeSearch, '%'))",
        nativeQuery = true)
Page<PostDto> searchAllPost(@Param("demandTypeSearch") String demandTypeSearch,@Param("lendTypeSearch") String lendTypeSearch, @Param("minPriceSearch") Double minPriceSearch, @Param("maxPriceSearch") Double maxPriceSearch, @Param("positionSearch") String positionSearch , Pageable pageable);
    /**
     * Create by: NgocLV
     * Date created: 31/01/2023
     * Function: find all Post
     *
     * @param pageable
     *
     * @return json list Posts searched
     */

    @Query(value = "select p.id_post as idPost, c.code_customer as codeCustomer, d.name_demand_type as demandType, l.name_land_type as landType, a.number_address as position, p.area as area, p.note as note, p.approval_id_approval as approval \n" +
            "from post p left join customer as c on p.customer_id_customer = c.id_customer left join demand_type as d on p.demand_type_id_demand_type = d.id_demand_type \n" +
            "left join land_type as l on l.id_land_type = p.land_type_id_land_type left join address as a on a.id_address = p.address_id_address where p.flag_deleted = false",
            countQuery = "select p.id_post as idPost, c.code_customer as codeCustomer, d.name_demand_type as demandType, l.name_land_type as landType, a.number_address as position, p.area as area, p.note as note, p.approval_id_approval as approval \n" +
                    "from post p left join customer as c on p.customer_id_customer = c.id_customer left join demand_type as d on p.demand_type_id_demand_type = d.id_demand_type \n" +
                    "left join land_type as l on l.id_land_type = p.land_type_id_land_type left join address as a on a.id_address = p.address_id_address where p.flag_deleted = false",
            nativeQuery = true)
    Page<PostDto> findAllPost( Pageable pageable);
    /**
     * Create by: NgocLV
     * Date created: 31/01/2023
     * Function: Approval post
     *
     * @param id
     */
    @Modifying
    @Query(value = "UPDATE post" +
            " SET approval_id_approval = 2" +
            " WHERE id_post = :id",
            nativeQuery = true)
    @Transactional
    void approvalPost(@Param("id") Long id);
}
