package com.eskcti.algafoodauthesk.auth.core;

import lombok.Getter;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

@Getter
public class AuthUser extends User {
    private static final long serialVersionUID = 1L;

    private Long userId;
    private String fullName;
    public AuthUser(com.eskcti.algafoodauthesk.auth.domain.User user) {
        super(user.getEmail(), user.getPassword(), Collections.emptyList());
        this.userId = user.getId();
        this.fullName = user.getName();
    }
}
