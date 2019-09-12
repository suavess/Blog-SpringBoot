package com.pyq.blog.service;

import com.pyq.blog.model.Profile;

/**
 * @Author Suave
 * @Date 2019/9/10 13:08
 * @Version 1.0
 */
public interface ProfileService {
    Profile selectAll() throws Exception;
}
