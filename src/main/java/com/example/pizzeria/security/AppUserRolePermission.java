package com.example.pizzeria.security;

public enum AppUserRolePermission {
    //Role ktore musze dodac - tu podane przykladowe TODO
    USER_READ("product:read"),
    USER_WRITE("product:write");

    private final String permission;

    AppUserRolePermission(String permission){
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
