package com.c0722g1repobe.repository.account;

import com.c0722g1repobe.entity.account.Role;

import com.c0722g1repobe.entity.account.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
    List<Role> findAll();
}
