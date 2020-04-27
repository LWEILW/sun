package com.blogger.dao.article;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.blogger.entity.article.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章管理
 *
 * @author Liu wei
 * @date 2020-03-31 16:00
 **/
@Mapper
public interface ArticleMapper {
    /**
     * 文章台账
     *
     * @param page
     * @return
     */
    List<Article> getArticleList(Pagination page);

    /**
     * 文章创建
     *
     * @param article
     * @return
     */
    int createArticle(@Param("article") Article article);

    /**
     * 文章更新
     *
     * @param article
     * @return
     */
    int updateArticle(@Param("article") Article article);

    /**
     * 文章删除
     *
     * @param articleId
     * @return
     */
    int deleteArticle(@Param("articleId") int articleId);

    /**
     * 文章删除 批量删除
     *
     * @param idList
     * @return
     */
    int deleteArticleAll(@Param("idList") List<Integer> idList);


    /**
     * 文章详情
     *
     * @param articleId
     * @return
     */
    Article detailsArticle(@Param("articleId") int articleId);
}
