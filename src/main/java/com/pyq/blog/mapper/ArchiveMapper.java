package com.pyq.blog.mapper;
import com.pyq.blog.model.Archive;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Suave
 * @Date 2019/9/10 16:53
 * @Version 1.0
 */
public interface ArchiveMapper {

    @Select("SELECT DISTINCT YEAR(article.create_time)AS `year`,MONTH(article.create_time) AS `month` FROM article")
    List<Archive> selectArchive();

    @Select("SELECT count(1) from article where DATE_FORMAT(create_time,'%Y-%m')='${year}-${month}'")
    Integer countArticleByYearAndMonth(String year,String month);
}
