package com.pyq.blog.mapper;

import com.pyq.blog.model.Profile;
import org.apache.ibatis.annotations.Select;

/**
 * @Author Suave
 * @Date 2019/9/10 13:07
 * @Version 1.0
 */
public interface ProfileMapper {

    @Select("select * from profile limit 1")
    Profile selectAll();
}
