package com.pyq.blog.mapper;

import com.pyq.blog.model.Article;
import com.pyq.blog.model.ArticleExt;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Suave
 * @Date 2019/9/10 12:29
 * @Version 1.0
 */
public interface ArticleMapper {

    @Select("select count(1) from article")
    Integer countAllArticle();

    @Select("select count(1) from article where cate_id=#{cate_id}")
    Integer countArticleByCateId(Integer cate_id);

    @Select("select count(1) from article where DATE_FORMAT(create_time,'%Y-%m') = '${year}-${month}'")
    Integer countArticleByYearAndMonth(String year, String month);

    @Select("select title from article where id = #{id}")
    String selectTitleById(String id);

    @Select("select article.*,article_category.name as cate_name from article LEFT JOIN article_category ON article" +
            ".cate_id=article_category.id where article.id=#{id} limit 1")
    ArticleExt selectArticleById(String id);

    @Select("select article.*,article_category.name as cate_name from article LEFT JOIN article_category ON article" +
            ".cate_id=article_category.id")
    List<ArticleExt> selectAllArticles();

    @Select("select article.*,article_category.`name` as cate_name from article LEFT JOIN article_category on " +
            "article_category.id=article.cate_id ORDER BY article.create_time desc limit #{offset},5")
    List<ArticleExt> selectArticlesByPage(Integer offset);

    @Select("select article.*,article_category.`name` as cate_name from article LEFT JOIN article_category on " +
            "article_category.id = article.cate_id where cate_id=#{cate_id} ORDER BY article.create_time desc limit #{offset},5")
    List<ArticleExt> selectArticlesByCidAndPage(Integer cate_id,Integer offset);

    @Select("select article.*,article_category.`name` AS cate_name from article LEFT JOIN article_category ON article_category.id = article.cate_id where DATE_FORMAT(create_time,'%Y-%m')='${year}-${month}' ORDER BY article.create_time desc")
    List<ArticleExt> selectArticlesByYearAndMonth(String year, String month);

    @Select("select article.*,article_category.`name` AS cate_name from article LEFT JOIN article_category ON " +
            "article_category.id = article.cate_id where DATE_FORMAT(create_time,'%Y-%m')='${year}-${month}' ORDER BY" +
            " article.create_time desc limit #{offset},5")
    List<ArticleExt> selectArticlesByDateAndPage(String year, String month, Integer offset);

    @Insert("insert into article values(null,#{article.cateId},#{article.title}," +
            "#{article.desc},#{article.content},NOW(),#{article.image})")
    void saveArticle(@Param("article") Article article);

    @Delete("delete from article where id = #{id}")
    void delArticle(String id);

}
