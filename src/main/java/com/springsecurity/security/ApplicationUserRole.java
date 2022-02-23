package com.springsecurity.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.springsecurity.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    PLAYER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(DIGIMON_GETINFO, DIGIMON_UPGRADE, ABILITY_GETINFO, ABILITY_UPGRADE)),
    ADMINTRAINEE(Sets.newHashSet(DIGIMON_GETINFO, ABILITY_GETINFO));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions(){
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        Set<SimpleGrantedAuthority> permissions =
                getPermissions().stream()
                        .map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
