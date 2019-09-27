package com.pyq.blog.mapper;

import com.pyq.blog.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author Suave
 * @Date 2019/9/10 12:29
 * @Version 1.0
 */
@Mapper
public interface AdminMapper {
    @Select("select * from admin where username=#{username}")
    Admin selectAdminByUsername(String username);
}
