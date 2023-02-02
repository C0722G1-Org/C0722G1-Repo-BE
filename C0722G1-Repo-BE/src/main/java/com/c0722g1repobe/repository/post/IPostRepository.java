package com.c0722g1repobe.repository.post;


import com.c0722g1repobe.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.c0722g1repobe.dto.post.PostDtoViewList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.c0722g1repobe.dto.post.PostListViewDto;
import com.c0722g1repobe.dto.post.PostDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    Page<Post> findAllPostByUserNameAccount(Pageable pageable,@Param("userNameAccount") String userNameAccount);

    /* Method use: getAll()
     * Get List data of required attributes from the database of related tables(Post,Address,Wards,District,StatusPost)
     * Use interface PostDto
     * Parameter: NO
     * Author: DatTQ
     * */
    @Query(value = "select p.id_post idPost,p.price price,p.date_creation dateCreation, sp.id_status_post statusPost,a.number_address numberAddress,w.name_wards nameWards,d.name_district nameDistrict,c.name_city nameCity,year(p.date_creation) yearPost,month(p.date_creation) monthPost from post p join address a on a.id_address = p.address_id_address join wards w on a.wards_id_wards = w.id_wards join district d on w.district_id_district = d.id_district join city c on d.city_id_city = c.id_city join status_post sp on sp.id_status_post = p.status_post_id_status_post where p.flag_deleted = false order by p.date_creation DESC", nativeQuery = true)
    List<PostDtoViewList> getAll();

    /*Method uses: searchYear(@Param("year") String year)
     * Get List data of required attributes from the database of related tables(Post,Address,Wards,District,StatusPost) together when searching by post year
     * Use interface PostDto
     * Parameter: String year
     * Author: DatTQ*/
    @Query(value = "select p.id_post idPost,p.price price,p.date_creation dateCreation, sp.id_status_post statusPost,a.number_address numberAddress,w.name_wards nameWards,d.name_district nameDistrict,c.name_city nameCity,year(p.date_creation) yearPost,month(p.date_creation) monthPost from post p join address a on a.id_address = p.address_id_address join wards w on a.wards_id_wards = w.id_wards join district d on w.district_id_district = d.id_district join city c on d.city_id_city = c.id_city join status_post sp on sp.id_status_post = p.status_post_id_status_post where p.flag_deleted = false and year(p.date_creation)= :year order by p.date_creation DESC", nativeQuery = true)
    List<PostDtoViewList> searchYear(@Param("year") String year);

    /*Method uses: searchYear(@Param("year") String year,@Param("month") String month )
     * Get List data of required attributes from the database of related tables(Post,Address,Wards,District,StatusPost) together when searching by post year and month
     * Use interface PostDto
     * Parameter: String year,String month
     * Author: DatTQ*/
    @Query(value = "select p.id_post idPost,p.price price,p.date_creation dateCreation, sp.id_status_post statusPost,a.number_address numberAddress,w.name_wards nameWards,d.name_district nameDistrict,c.name_city nameCity,year(p.date_creation) yearPost,month(p.date_creation) monthPost from post p join address a on a.id_address = p.address_id_address join wards w on a.wards_id_wards = w.id_wards join district d on w.district_id_district = d.id_district join city c on d.city_id_city = c.id_city join status_post sp on sp.id_status_post = p.status_post_id_status_post where p.flag_deleted = false and year(p.date_creation)= :year and month(p.date_creation)=:month order by p.date_creation DESC", nativeQuery = true)
    List<PostDtoViewList> searchYearAndMonth(@Param("year") String year, @Param("month") String month);

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

    /**
     * Create by : BaoDP
     * Date create: 01/02/2023
     * Description: insert post object into mysql database
     *
     * @param post
     */
    @Modifying
    @Query(value = "insert into post " +
            "(approval, " +
            "area, " +
            "date_creation, " +
            "flag_deleted," +
            "name_post," +
            "note," +
            "price," +
            "address_id_address," +
            "demand_type_id_demand_type," +
            "direction_id_direction," +
            "image_listurl," +
            "land_type_id_land_type," +
            "customer_id_customer," +
            "status_post_id_status_post) " +
            "VALUES (" +
            ":#{#post.approval}," +
            ":#{#post.area}," +
            ":#{#post.dateCreation}," +
            ":#{#post.flagDeleted}," +
            ":#{#post.namePost}," +
            ":#{#post.note}," +
            ":#{#post.price}," +
            ":#{#post.address.idAddress}," +
            ":#{#post.demandType.idDemandType}," +
            ":#{#post.direction.idDirection}," +
            ":#{#post.imageListURL}," +
            ":#{#post.landType.idLandType}," +
            ":#{#post.customer.idCustomer}," +
            ":#{#post.statusPost.idStatusPost})",
            nativeQuery = true)
    @Transactional
    void savePost(@Param("post") Post post);
    
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
