package com.pyq.blog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ArticleExt extends Article{
    private String cateName;
}
