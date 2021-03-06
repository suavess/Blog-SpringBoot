package com.pyq.blog.mapper;

import com.pyq.blog.model.Profile;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProfileMapper {

    @Select("select * from profile limit 1")
    Profile selectAll();

    @Update("update profile set profile.desc=#{profile.desc},profile.name=#{profile.name}," +
            "profile.place=#{profile.place},profile.hobby=#{profile.hobby}," +
            "profile.qq=#{profile.qq},profile.image=#{profile.image} where profile.id=1")
    void updateProfile(@Param("profile") Profile profile);
}
