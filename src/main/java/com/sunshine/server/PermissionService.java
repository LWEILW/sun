package com.sunshine.server;

import com.sunshine.entity.Permission;
import com.sunshine.entity.User;

import java.util.List;

public interface PermissionService {

     List<Permission> findByUser(User user);
}
