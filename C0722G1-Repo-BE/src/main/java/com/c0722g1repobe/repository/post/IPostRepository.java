package com.c0722g1repobe.repository.post;

import com.c0722g1repobe.dto.post.PostListViewDto;
import com.c0722g1repobe.dto.post.PostDto;
import com.c0722g1repobe.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IPostRepository extends JpaRepository<Post, Long> {
    @Query(value = "SELECT p.name_post,\n" +
            "       p.price,\n" +
            "       p.area,\n" +
            "       d2.name_district as district,\n" +
            "       c2.name_city     as city,\n" +
            "       p.image_listurl,\n" +
            "       p.date_creation\n" +
            "FROM post p\n" +
            "         JOIN address a on a.id_address = p.address_id_address\n" +
            "         JOIN customer c on c.id_customer = p.customer_id_customer\n" +
            "         JOIN demand_type dt on dt.id_demand_type = p.demand_type_id_demand_type\n" +
            "         JOIN direction d on d.id_direction = p.direction_id_direction\n" +
            "         JOIN land_type lt on lt.id_land_type = p.land_type_id_land_type\n" +
            "         JOIN status_post sp on sp.id_status_post = p.status_post_id_status_post\n" +
            "         JOIN wards w on w.id_wards = a.wards_id_wards\n" +
            "         JOIN district d2 on d2.id_district = w.district_id_district\n" +
            "         JOIN city c2 on c2.id_city = d2.city_id_city\n" +
            "WHERE flag_deleted = false\n" +
            "  AND approval = 1\n" +
            "  AND dt.name_demand_type LIKE CONCAT('%', :demandType, '%')\n" +
            "  AND d.name_direction LIKE CONCAT('%', :direction, '%')\n" +
            "  AND c2.name_city LIKE CONCAT('%', :city, '%')",
            nativeQuery = true,
            countQuery = "SELECT p.name_post,\n" +
                    "       p.price,\n" +
                    "       p.area,\n" +
                    "       d2.name_district as district,\n" +
                    "       c2.name_city     as city,\n" +
                    "       p.image_listurl,\n" +
                    "       p.date_creation\n" +
                    "FROM post p\n" +
                    "         JOIN address a on a.id_address = p.address_id_address\n" +
                    "         JOIN customer c on c.id_customer = p.customer_id_customer\n" +
                    "         JOIN demand_type dt on dt.id_demand_type = p.demand_type_id_demand_type\n" +
                    "         JOIN direction d on d.id_direction = p.direction_id_direction\n" +
                    "         JOIN land_type lt on lt.id_land_type = p.land_type_id_land_type\n" +
                    "         JOIN status_post sp on sp.id_status_post = p.status_post_id_status_post\n" +
                    "         JOIN wards w on w.id_wards = a.wards_id_wards\n" +
                    "         JOIN district d2 on d2.id_district = w.district_id_district\n" +
                    "         JOIN city c2 on c2.id_city = d2.city_id_city\n" +
                    "WHERE flag_deleted = false\n" +
                    "  AND approval = 1\n" +
                    "  AND dt.name_demand_type LIKE CONCAT('%', :demandType, '%')\n" +
                    "  AND d.name_direction LIKE CONCAT('%', :direction, '%')\n" +
                    "  AND c2.name_city LIKE CONCAT('%', :city, '%')")
    Page<PostListViewDto> findAllWithDemandTypeDirectionCity(@Param("demandType") String demandType,
                                                             @Param("direction") String direction,
                                                             @Param("city") String city, Pageable pageable);
    @Query(value = "SELECT p.name_post,\n" +
            "       p.price,\n" +
            "       p.area,\n" +
            "       d2.name_district as district,\n" +
            "       c2.name_city     as city,\n" +
            "       p.image_listurl,\n" +
            "       p.date_creation\n" +
            "FROM post p\n" +
            "         JOIN address a on a.id_address = p.address_id_address\n" +
            "         JOIN customer c on c.id_customer = p.customer_id_customer\n" +
            "         JOIN demand_type dt on dt.id_demand_type = p.demand_type_id_demand_type\n" +
            "         JOIN direction d on d.id_direction = p.direction_id_direction\n" +
            "         JOIN land_type lt on lt.id_land_type = p.land_type_id_land_type\n" +
            "         JOIN status_post sp on sp.id_status_post = p.status_post_id_status_post\n" +
            "         JOIN wards w on w.id_wards = a.wards_id_wards\n" +
            "         JOIN district d2 on d2.id_district = w.district_id_district\n" +
            "         JOIN city c2 on c2.id_city = d2.city_id_city\n" +
            "WHERE flag_deleted = false\n" +
            "  AND approval = 1\n" +
            "  AND dt.name_demand_type LIKE CONCAT('%', :demandType, '%')\n" +
            "  AND d.name_direction LIKE CONCAT('%', :direction, '%')\n" +
            "  AND c2.name_city LIKE CONCAT('%', :city, '%')\n" +
            "  AND p.area BETWEEN :minArea AND :maxArea",
            nativeQuery = true,
            countQuery = "SELECT p.name_post,\n" +
                    "       p.price,\n" +
                    "       p.area,\n" +
                    "       d2.name_district as district,\n" +
                    "       c2.name_city     as city,\n" +
                    "       p.image_listurl,\n" +
                    "       p.date_creation\n" +
                    "FROM post p\n" +
                    "         JOIN address a on a.id_address = p.address_id_address\n" +
                    "         JOIN customer c on c.id_customer = p.customer_id_customer\n" +
                    "         JOIN demand_type dt on dt.id_demand_type = p.demand_type_id_demand_type\n" +
                    "         JOIN direction d on d.id_direction = p.direction_id_direction\n" +
                    "         JOIN land_type lt on lt.id_land_type = p.land_type_id_land_type\n" +
                    "         JOIN status_post sp on sp.id_status_post = p.status_post_id_status_post\n" +
                    "         JOIN wards w on w.id_wards = a.wards_id_wards\n" +
                    "         JOIN district d2 on d2.id_district = w.district_id_district\n" +
                    "         JOIN city c2 on c2.id_city = d2.city_id_city\n" +
                    "WHERE flag_deleted = false\n" +
                    "  AND approval = 1\n" +
                    "  AND dt.name_demand_type LIKE CONCAT('%', :demandType, '%')\n" +
                    "  AND d.name_direction LIKE CONCAT('%', :direction, '%')\n" +
                    "  AND c2.name_city LIKE CONCAT('%', :city, '%')\n" +
                    "  AND p.area BETWEEN :minArea AND :maxArea")
    Page<PostListViewDto> findAllWithDemandTypeDirectionCityArea(@Param("demandType") String demandType,
                                                      @Param("direction") String direction,
                                                      @Param("city") String city,
                                                      @Param("minArea") Double minArea,
                                                      @Param("maxArea") Double maxArea, Pageable pageable);
    @Query(value = "SELECT p.name_post,\n" +
            "       p.price,\n" +
            "       p.area,\n" +
            "       d2.name_district as district,\n" +
            "       c2.name_city     as city,\n" +
            "       p.image_listurl,\n" +
            "       p.date_creation\n" +
            "FROM post p\n" +
            "         JOIN address a on a.id_address = p.address_id_address\n" +
            "         JOIN customer c on c.id_customer = p.customer_id_customer\n" +
            "         JOIN demand_type dt on dt.id_demand_type = p.demand_type_id_demand_type\n" +
            "         JOIN direction d on d.id_direction = p.direction_id_direction\n" +
            "         JOIN land_type lt on lt.id_land_type = p.land_type_id_land_type\n" +
            "         JOIN status_post sp on sp.id_status_post = p.status_post_id_status_post\n" +
            "         JOIN wards w on w.id_wards = a.wards_id_wards\n" +
            "         JOIN district d2 on d2.id_district = w.district_id_district\n" +
            "         JOIN city c2 on c2.id_city = d2.city_id_city\n" +
            "WHERE flag_deleted = false\n" +
            "  AND approval = 1\n" +
            "  AND dt.name_demand_type LIKE CONCAT('%', :demandType, '%')\n" +
            "  AND d.name_direction LIKE CONCAT('%', :direction, '%')\n" +
            "  AND c2.name_city LIKE CONCAT('%', :city, '%')\n" +
            "  AND p.area BETWEEN :priceMin AND :priceMax",
            nativeQuery = true,
            countQuery = "SELECT p.name_post,\n" +
                    "       p.price,\n" +
                    "       p.area,\n" +
                    "       d2.name_district as district,\n" +
                    "       c2.name_city     as city,\n" +
                    "       p.image_listurl,\n" +
                    "       p.date_creation\n" +
                    "FROM post p\n" +
                    "         JOIN address a on a.id_address = p.address_id_address\n" +
                    "         JOIN customer c on c.id_customer = p.customer_id_customer\n" +
                    "         JOIN demand_type dt on dt.id_demand_type = p.demand_type_id_demand_type\n" +
                    "         JOIN direction d on d.id_direction = p.direction_id_direction\n" +
                    "         JOIN land_type lt on lt.id_land_type = p.land_type_id_land_type\n" +
                    "         JOIN status_post sp on sp.id_status_post = p.status_post_id_status_post\n" +
                    "         JOIN wards w on w.id_wards = a.wards_id_wards\n" +
                    "         JOIN district d2 on d2.id_district = w.district_id_district\n" +
                    "         JOIN city c2 on c2.id_city = d2.city_id_city\n" +
                    "WHERE flag_deleted = false\n" +
                    "  AND approval = 1\n" +
                    "  AND dt.name_demand_type LIKE CONCAT('%', :demandType, '%')\n" +
                    "  AND d.name_direction LIKE CONCAT('%', :direction, '%')\n" +
                    "  AND c2.name_city LIKE CONCAT('%', :city, '%')\n" +
                    "  AND p.area BETWEEN :priceMin AND :priceMax")
    Page<PostListViewDto> findAllWithDemandTypeDirectionCityPrice(@Param("demandType") String demandType,
                                                      @Param("direction") String direction,
                                                      @Param("city") String city,
                                                      @Param("priceMin") Double priceMin,
                                                      @Param("priceMax") Double priceMax, Pageable pageable);
    @Query(value = "SELECT p.name_post,\n" +
            "       p.price,\n" +
            "       p.area,\n" +
            "       d2.name_district as district,\n" +
            "       c2.name_city     as city,\n" +
            "       p.image_listurl,\n" +
            "       p.date_creation\n" +
            "FROM post p\n" +
            "         JOIN address a on a.id_address = p.address_id_address\n" +
            "         JOIN customer c on c.id_customer = p.customer_id_customer\n" +
            "         JOIN demand_type dt on dt.id_demand_type = p.demand_type_id_demand_type\n" +
            "         JOIN direction d on d.id_direction = p.direction_id_direction\n" +
            "         JOIN land_type lt on lt.id_land_type = p.land_type_id_land_type\n" +
            "         JOIN status_post sp on sp.id_status_post = p.status_post_id_status_post\n" +
            "         JOIN wards w on w.id_wards = a.wards_id_wards\n" +
            "         JOIN district d2 on d2.id_district = w.district_id_district\n" +
            "         JOIN city c2 on c2.id_city = d2.city_id_city\n" +
            "WHERE flag_deleted = false\n" +
            "  AND approval = 1\n" +
            "  AND dt.name_demand_type LIKE CONCAT('%', :demandType, '%')\n" +
            "  AND d.name_direction LIKE CONCAT('%', :direction, '%')\n" +
            "  AND c2.name_city LIKE CONCAT('%', :city, '%')\n" +
            "  AND p.area BETWEEN :minArea AND :maxArea\n" +
            "  AND p.price BETWEEN :priceMin AND :priceMax",
            nativeQuery = true,
            countQuery = "SELECT p.name_post,\n" +
                    "       p.price,\n" +
                    "       p.area,\n" +
                    "       d2.name_district as district,\n" +
                    "       c2.name_city     as city,\n" +
                    "       p.image_listurl,\n" +
                    "       p.date_creation\n" +
                    "FROM post p\n" +
                    "         JOIN address a on a.id_address = p.address_id_address\n" +
                    "         JOIN customer c on c.id_customer = p.customer_id_customer\n" +
                    "         JOIN demand_type dt on dt.id_demand_type = p.demand_type_id_demand_type\n" +
                    "         JOIN direction d on d.id_direction = p.direction_id_direction\n" +
                    "         JOIN land_type lt on lt.id_land_type = p.land_type_id_land_type\n" +
                    "         JOIN status_post sp on sp.id_status_post = p.status_post_id_status_post\n" +
                    "         JOIN wards w on w.id_wards = a.wards_id_wards\n" +
                    "         JOIN district d2 on d2.id_district = w.district_id_district\n" +
                    "         JOIN city c2 on c2.id_city = d2.city_id_city\n" +
                    "WHERE flag_deleted = false\n" +
                    "  AND approval = 1\n" +
                    "  AND dt.name_demand_type LIKE CONCAT('%', :demandType, '%')\n" +
                    "  AND d.name_direction LIKE CONCAT('%', :direction, '%')\n" +
                    "  AND c2.name_city LIKE CONCAT('%', :city, '%')\n" +
                    "  AND p.area BETWEEN :minArea AND :maxArea\n" +
                    "  AND p.price BETWEEN :priceMin AND :priceMax")
    Page<PostListViewDto> findAllWithDemandTypeDirectionCityAreaPrice(@Param("demandType") String demandType,
                                                           @Param("direction") String direction,
                                                           @Param("city") String city,
                                                           @Param("minArea") Double minArea,
                                                           @Param("maxArea") Double maxArea,
                                                           @Param("priceMin") Double priceMin,
                                                           @Param("priceMax") Double priceMax, Pageable pageable);
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

    @Query(value = "select p.id_post as idPost, c.code_customer as codeCustomer, d.name_demand_type as demandType, l.name_land_type as landType, a.number_address as position, p.area as area, p.note as note, p.approval_id_approval as approval \n" +
            "from post p left join customer as c on p.customer_id_customer = c.id_customer left join demand_type as d on p.demand_type_id_demand_type = d.id_demand_type \n" +
            "left join land_type as l on l.id_land_type = p.land_type_id_land_type left join address as a on a.id_address = p.address_id_address where p.flag_deleted = false and (d.name_demand_type like concat('%', :demandTypeSearch, '%')  and  l.name_land_type like concat('%', :lendTypeSearch, '%'))",
            countQuery = "select p.id_post as idPost, c.code_customer as codeCustomer, d.name_demand_type as demandType, l.name_land_type as landType, a.number_address as position, p.area as area, p.note as note, p.approval_id_approval as approval \n" +
                    "from post p left join customer as c on p.customer_id_customer = c.id_customer left join demand_type as d on p.demand_type_id_demand_type = d.id_demand_type \n" +
                    "left join land_type as l on l.id_land_type = p.land_type_id_land_type left join address as a on a.id_address = p.address_id_address where p.flag_deleted = false and (d.name_demand_type like concat('%', :demandTypeSearch, '%')  and  l.name_land_type like concat('%', :lendTypeSearch, '%'))",
            nativeQuery = true)
    Page<PostDto> searchAllPost(@Param("demandTypeSearch") String demandTypeSearch,@Param("lendTypeSearch") String lendTypeSearch , Pageable pageable);
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
