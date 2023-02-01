package com.c0722g1repobe.repository.post;

import com.c0722g1repobe.entity.post.LandType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ILandTypeRepository extends JpaRepository<LandType, Long> {
    @Query(value = "select * from sprint_1.land_type as lt where lt.id_land_type = :idLandType", nativeQuery = true)
    LandType findByIdNativeQuery(@Param("idLandType") Long idLandType);
}
