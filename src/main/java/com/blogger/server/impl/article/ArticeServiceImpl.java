package com.blogger.server.impl.article;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.plugins.Page;
import com.blogger.dao.article.ArticleMapper;
import com.blogger.entity.article.Article;
import com.blogger.server.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章管理
 *
 * @author Liu wei
 * @date 2020-03-31 16:00
 **/
@Service("ArticleService")
public class ArticeServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 文章台账
     * @param page
     * @return
     */
    @Override
    public Page<Article> getArticleList(Page<Article> page) {

        return page.setRecords(articleMapper.getArticleList(page));
    }


    /**
     * 文章保存
     * @param article
     * @return
     */
    @Override
    public boolean saveArticle(Article article) {
        int succ = 0;
        if (article.getArticleId() != null && !"".equals(article.getArticleId())) {
            // ID不为空，更新操作
            succ = articleMapper.updateArticle(article);
        } else {
            // ID为空，创建操作
            succ = articleMapper.createArticle(article);
        }
        if (succ != 1) {
            return false;
        }
        return true;
    }

    /**
     * 文章删除
     * @param articleId
     * @return
     */
    @Override
    public int deleteArticle(int articleId) {
        return articleMapper.deleteArticle(articleId);
    }


    /**
     * 文章删除 批量删除
     *
     * @param list
     * @return
     */
    @Override
    public boolean deleteArticleAll(JSONArray list){
        //定义装有需要删除的ID集合
        List<Integer> idList = new ArrayList<Integer>();
        //遍历原有数据
        for (Object id : list) {
            //封装到新集合里
            idList.add((Integer) id);
        }
        int succ = articleMapper.deleteArticleAll(idList);
        if (succ == 0) {
            return false;
        }
        return true;
    }


    /**
     * 文章详情
     * @param articleId
     * @return
     */
    @Override
    public Article detailsArticle(int articleId) {
       return articleMapper.detailsArticle(articleId);
    }
}
