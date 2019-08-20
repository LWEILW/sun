package com.sunshine.entity;

public class SysPermissionInit {
    private String id;
    private String url;
    private String permission_init;
    private int sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getPermission_init() {
        return permission_init;
    }

    public void setPermission_init(String permission_init) {
        this.permission_init = permission_init;
    }
}
