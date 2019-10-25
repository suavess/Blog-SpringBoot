package com.pyq.blog.mapper;

import com.pyq.blog.model.Link;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LinkMapper {

    @Select("select * from link")
    List<Link> selectAllLink();

    @Insert("insert into link values(null,#{link.name},#{link.href})")
    void addLink(@Param("link") Link link);

    @Select("select * from link where id = #{id} limit 1")
    Link selectLinkById(String id);

    @Update("update link set link.name=#{link.name},link.href=#{link.href} where link.id=#{link.id}")
    void updateLink(@Param("link") Link link);

    @Delete("delete from link where id = #{id}")
    void delLink(String id);
}
