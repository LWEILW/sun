package com.blogger.server.impl;

import com.blogger.server.SysPermissionInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SysPermissionInitService")
public class SysPermissionInitServiceImpl implements SysPermissionInitService {

    @Autowired
    private SysPermissionInitMapperEx sysPermissionInitMapperEx;

    @Override
    public List<SysPermissionInit> selectAll() {
        return sysPermissionInitMapperEx.selectAll();
    }
}
