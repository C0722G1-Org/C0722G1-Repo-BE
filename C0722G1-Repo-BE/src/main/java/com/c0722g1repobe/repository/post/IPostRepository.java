package com.c0722g1repobe.repository.post;

import com.c0722g1repobe.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPostRepository extends JpaRepository<Post, Long> {
    @Query(value = "SELECT cu.id, cu.name, ct.name as customerTypeName, cu.birthday, cu.gender, cu.id_card as idCard, cu.phone_number as phoneNumber, cu.email, cu.address FROM customer cu JOIN contract c on cu.id = c.customer_id JOIN customer_type ct on ct.id = cu.customer_type_id where cu.customer_type_id = :customerTypeId and cu.email like CONCAT('%',:email,'%') and cu.name like CONCAT('%',:name,'%') AND cu.flag_remove = true GROUP BY cu.id",
            nativeQuery = true,
            countQuery = "select *from (SELECT cu.id, cu.name, ct.name as customerTypeName, cu.birthday, cu.gender, cu.id_card as idCard, cu.phone_number as phoneNumber, cu.email, cu.address FROM customer cu JOIN contract c on cu.id = c.customer_id JOIN customer_type ct on ct.id = cu.customer_type_id where cu.customer_type_id = :customerTypeId and cu.email like CONCAT('%',:email,'%') and cu.name like CONCAT('%',:name,'%') AND cu.flag_remove = true GROUP BY cu.id)as A")
    Page<Post> findAll(@Param("demandType") String demandType, @Param("direction") String direction, @Param("city") String city, Pageable pageable);
}
