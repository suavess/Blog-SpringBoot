package com.pyq.blog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Link {
    private Integer id;
    private String name;
    private String href;
}
