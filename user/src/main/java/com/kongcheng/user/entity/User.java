package com.kongcheng.user.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = -1664903063988315619L;

    private Long id;

    private String account;

    private String password;

    private String nickname;
}
