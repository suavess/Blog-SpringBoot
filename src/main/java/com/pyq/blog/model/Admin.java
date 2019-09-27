package com.pyq.blog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author Suave
 * @Date 2019/9/10 11:58
 * @Version 1.0
 */
@Getter @Setter @ToString
public class Admin {
    private Integer id;
    private String username;
    private String password;
    private String name;
}
