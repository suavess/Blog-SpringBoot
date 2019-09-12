package com.pyq.blog.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * @Author Suave
 * @Date 2019/9/10 13:56
 * @Version 1.0
 */
@Getter @Setter
public class ArticleExt {
    private Integer id;
    private Integer cateId;
    private String cateName;
    private String title;
    private String desc;
    private String content;
    @JSONField(format = "yyyy-MM-dd")
    private Date createTime;
    private String image;
}
