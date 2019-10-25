package com.pyq.blog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Admin {
    private Integer id;
    private String username;
    private String password;
    private String name;
}
