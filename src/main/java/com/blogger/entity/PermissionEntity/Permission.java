package com.blogger.entity.PermissionEntity;

import com.blogger.entity.RoleEntity.Role;

public class Permission extends Role {
    // 权限ID
    private int permissionId;
    // 权限名称
    private String permissionName;
    // 父类ID
    private int parentId;
    // 父类名称
    private String parentName;
    // 功能名称
    private String functionName;
    // 功能路径
    private String functionPath;
    // 权限等级
    private int levelNo;
    // 创建者（用户ID）
    private String createPerson;
    // 创建时间
    private String createDate;
    // 更新者（用户ID）
    private String updatePerson;
    // 更新时间
    private String updateDate;


    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionPath() {
        return functionPath;
    }

    public void setFunctionPath(String functionPath) {
        this.functionPath = functionPath;
    }

    public int getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(int levelNo) {
        this.levelNo = levelNo;
    }

    @Override
    public String getCreatePerson() {
        return createPerson;
    }

    @Override
    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    @Override
    public String getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    @Override
    public String getUpdateDate() {
        return updateDate;
    }

    @Override
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
