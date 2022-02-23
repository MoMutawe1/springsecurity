package com.springsecurity.security;

public enum ApplicationUserPermission {
    DIGIMON_GETINFO("digimon:read"),
    DIGIMON_UPGRADE("digimon:write"),
    ABILITY_GETINFO("ability:read"),
    ABILITY_UPGRADE("ability:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
