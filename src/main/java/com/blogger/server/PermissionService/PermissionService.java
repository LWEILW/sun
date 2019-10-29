package com.blogger.server.PermissionService;

import com.blogger.entity.PermissionEntity.Permission;
import com.blogger.entity.UserEntity.User;

import java.util.List;

public interface PermissionService {

     List<Permission> findByUser(User user);
}
