package com.c0722g1repobe.repository.post;

import com.c0722g1repobe.entity.post.Wards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IWardsRepository extends JpaRepository<Wards, Long> {
    @Query(value = "select w.name_wards from sprint_1.wards as w where w.id_wards = :idWards", nativeQuery = true)
    String findNameByIdNativeQuery(@Param("idWards") Long idWards);
}
