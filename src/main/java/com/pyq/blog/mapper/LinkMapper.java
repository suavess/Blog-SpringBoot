package com.pyq.blog.mapper;

import com.pyq.blog.model.Link;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Suave
 * @Date 2019/9/10 12:30
 * @Version 1.0
 */
public interface LinkMapper {

    @Select("select * from link")
    List<Link> selectAllLink();
}
