package com.project.dasi.auth.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Userrole {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private String value;
}
