package com.pyq.blog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Archive {
    private String year;
    private String month;
    private String articleNum;
}
