package com.pyq.blog.mapper;

import com.pyq.blog.model.Admin;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
    @Select("select * from admin where username=#{username}")
    Admin selectAdminByUsername(String username);
}
