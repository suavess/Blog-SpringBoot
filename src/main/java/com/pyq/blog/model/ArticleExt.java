package com.pyq.blog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author Suave
 * @Date 2019/9/10 13:56
 * @Version 1.0
 */
@Getter @Setter @ToString
public class ArticleExt extends Article{
    private String cateName;
}
