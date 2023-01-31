package com.c0722g1repobe.repository.post;

import com.c0722g1repobe.dto.post.PostDto;
import com.c0722g1repobe.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPostRepository extends JpaRepository<Post, Long> {
    /* Method use: getAll()
     * Get List data of required attributes from the database of related tables(Post,Address,Wards,District,StatusPost)
     * Use interface PostDto
     * Parameter: NO
     * Author: DatTQ
     * */
    @Query(value = "select p.id_post idPost,p.price price,p.date_creation dateCreation, sp.id_status_post statusPost,a.number_address numberAddress,w.name_wards nameWards,d.name_district nameDistrict,c.name_city nameCity,year(p.date_creation) yearPost,month(p.date_creation) monthPost from post p join address a on a.id_address = p.address_id_address join wards w on a.wards_id_wards = w.id_wards join district d on w.district_id_district = d.id_district join city c on d.city_id_city = c.id_city join status_post sp on sp.id_status_post = p.status_post_id_status_post where p.flag_deleted = false order by p.date_creation DESC", nativeQuery = true)
    List<PostDto> getAll();

    /*Method uses: searchYear(@Param("year") String year)
     * Get List data of required attributes from the database of related tables(Post,Address,Wards,District,StatusPost) together when searching by post year
     * Use interface PostDto
     * Parameter: String year
     * Author: DatTQ*/
    @Query(value = "select p.id_post idPost,p.price price,p.date_creation dateCreation, sp.id_status_post statusPost,a.number_address numberAddress,w.name_wards nameWards,d.name_district nameDistrict,c.name_city nameCity,year(p.date_creation) yearPost,month(p.date_creation) monthPost from post p join address a on a.id_address = p.address_id_address join wards w on a.wards_id_wards = w.id_wards join district d on w.district_id_district = d.id_district join city c on d.city_id_city = c.id_city join status_post sp on sp.id_status_post = p.status_post_id_status_post where p.flag_deleted = false and year(p.date_creation)= :year order by p.date_creation DESC", nativeQuery = true)
    List<PostDto> searchYear(@Param("year") String year);

    /*Method uses: searchYear(@Param("year") String year,@Param("month") String month )
     * Get List data of required attributes from the database of related tables(Post,Address,Wards,District,StatusPost) together when searching by post year and month
     * Use interface PostDto
     * Parameter: String year,String month
     * Author: DatTQ*/
    @Query(value = "select p.id_post idPost,p.price price,p.date_creation dateCreation, sp.id_status_post statusPost,a.number_address numberAddress,w.name_wards nameWards,d.name_district nameDistrict,c.name_city nameCity,year(p.date_creation) yearPost,month(p.date_creation) monthPost from post p join address a on a.id_address = p.address_id_address join wards w on a.wards_id_wards = w.id_wards join district d on w.district_id_district = d.id_district join city c on d.city_id_city = c.id_city join status_post sp on sp.id_status_post = p.status_post_id_status_post where p.flag_deleted = false and year(p.date_creation)= :year and month(p.date_creation)=:month order by p.date_creation DESC", nativeQuery = true)
    List<PostDto> searchYearAndMonth(@Param("year") String year, @Param("month") String month);

}
