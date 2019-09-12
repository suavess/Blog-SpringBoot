package com.pyq.blog.service;

import com.pyq.blog.model.Link;

import java.util.List;

/**
 * @Author Suave
 * @Date 2019/9/10 16:33
 * @Version 1.0
 */
public interface LinkService {
    List<Link> selectAllLink() throws Exception;
}
