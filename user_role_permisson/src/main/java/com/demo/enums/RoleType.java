package com.demo.enums;

public enum RoleType {
    ADMIN_ROLE("ADMIN_ROLE"),
    SHENJI_ROLE("SHENJI_ROLE");

    private String roleType;

    RoleType(String roleType) {

    }

    public final String getRoleType() {
        return roleType;
    }
}
