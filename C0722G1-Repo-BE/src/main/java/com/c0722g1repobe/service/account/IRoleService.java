package com.c0722g1repobe.service.account;

import com.c0722g1repobe.entity.account.Role;
import com.c0722g1repobe.entity.account.RoleName;


import java.util.List;
import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName roleName);
    List<Role> findAll();
}
