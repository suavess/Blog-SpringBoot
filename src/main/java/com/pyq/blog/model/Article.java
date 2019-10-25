package com.pyq.blog.model;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Article {
    private Integer id;
    private Integer cateId;
    private String title;
    private String desc;
    private String content;
    private Timestamp createTime;
    private String image;
}
