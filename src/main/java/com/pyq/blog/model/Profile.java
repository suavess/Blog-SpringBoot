package com.pyq.blog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Profile {
    private Integer id;
    private String desc;
    private String name;
    private String place;
    private String hobby;
    private String qq;
    private String image;
}
