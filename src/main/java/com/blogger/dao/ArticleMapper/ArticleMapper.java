package com.blogger.dao.ArticleMapper;

import com.blogger.entity.ArticleEntity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    // 文章台账
    List<Article> getArticleList();

    // 文章创建
    int createArticle(@Param("article") Article article);

    // 文章更新
    int updateArticle(@Param("article") Article article);

    // 文章删除
    int deleteArticle(@Param("articleId") int articleId);

    // 文章详情
    Article detailsArticle(@Param("articleId") int articleId);
}
