package com.pyq.blog.mapper;

import com.pyq.blog.model.ArticleCategory;
import com.pyq.blog.model.ArticleCategoryExt;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author Suave
 * @Date 2019/9/10 12:29
 * @Version 1.0
 */
public interface ArticleCategoryMapper {
    @Select("select name from article_category where id = #{cate_id}")
    String selectCateName(Integer cate_id);

    @Select("select DISTINCT article_category.*," +
            "(select count(1) from article where cate_id=article_category.id) AS article_num" +
            " from article_category,article")
    List<ArticleCategoryExt> selectAll();

    @Select("select * from article_category where id=#{id}")
    ArticleCategory selectCategoryById(String id);

    @Insert("insert into article_category values(null,#{cateName})")
    void addCategory(String cateName);

    @Update("update article_category set article_category.name=#{articleCategory.name} " +
            "where article_category.id=#{articleCategory.id}")
    void updateCategoryById(@Param("articleCategory")ArticleCategory articleCategory);

    @Delete("delete from article_category where id=#{id}")
    void delCategoryById(String id);

}
