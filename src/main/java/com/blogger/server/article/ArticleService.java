package com.blogger.server.article;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.plugins.Page;
import com.blogger.entity.article.Article;

/**
 * 文章管理
 *
 * @author Liu wei
 * @date 2020-03-31 16:00
 **/
public interface ArticleService {

    /**
     * 文章台账
     *
     * @param page
     * @return
     */
    Page<Article> getArticleList(Page<Article> page);

    /**
     * 文章保存
     *
     * @param article
     * @return
     */
    boolean saveArticle(Article article);

    /**
     * 文章删除 单独删除
     *
     * @param articleId
     * @return
     */
    int deleteArticle(int articleId);

    /**
     * 文章删除 批量删除
     *
     * @param idList
     * @return
     */
    boolean deleteArticleAll(JSONArray list);

    /**
     * 文章详情
     *
     * @param articleId
     * @return
     */
    Article detailsArticle(int articleId);
}
