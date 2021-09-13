package com.example.pizzeria.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.pizzeria.security.AppUserRolePermission.USER_READ;
import static com.example.pizzeria.security.AppUserRolePermission.USER_WRITE;

public enum AppUserRole {
    //TODO

    USER(Sets.newHashSet(USER_READ,USER_WRITE)),
    ADMIN(Sets.newHashSet(USER_READ,USER_WRITE));

    private final Set<AppUserRolePermission> permissions;

    AppUserRole(Set<AppUserRolePermission> permissions) {
        this.permissions = permissions;
    }
}
