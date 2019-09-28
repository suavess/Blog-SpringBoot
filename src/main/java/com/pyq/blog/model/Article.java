package com.pyq.blog.model;
import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


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
    private Timestamp createTime;
    private String image;
}
