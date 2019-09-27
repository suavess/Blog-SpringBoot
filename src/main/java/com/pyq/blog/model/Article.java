package com.pyq.blog.model;
import java.sql.Date;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @Author Suave
 * @Date 2019/9/10 11:58
 * @Version 1.0
 */
@Getter @Setter @ToString
public class Article {
    private Integer id;
    private Integer cateId;
    private String title;
    private String desc;
    private String content;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String image;
}
