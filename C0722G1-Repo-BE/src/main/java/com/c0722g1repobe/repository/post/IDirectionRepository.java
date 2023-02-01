package com.c0722g1repobe.repository.post;

import com.c0722g1repobe.entity.post.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDirectionRepository extends JpaRepository<Direction, Long> {
    @Query(value = "select * from sprint_1.direction as d where d.id_direction = :idDirection", nativeQuery = true)
    Direction findByIdNativeQuery(@Param("idDirection") Long idDirection);
}
