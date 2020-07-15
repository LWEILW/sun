package com.blogger.controller.article;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.blogger.entity.article.Article;
import com.blogger.server.article.ArticleService;
import com.blogger.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 文章管理
 *
 * @author Liu wei
 * @date 2020-03-31 16:00
 **/
@RestController
@RequestMapping("/article")
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);


    @Autowired
    private ArticleService articleService;

    /**
     * 文章台账
     *
     * @param data
     * @return
     */
    @PostMapping("/articleList")
    public Result articleList(@RequestBody String data) {
        JSONObject obj = JSONObject.parseObject(data);
        int currentPage = obj.getInteger("currentPage");
        int pageSize = obj.getInteger("pageSize");

        Page<Article> page = new Page<>(currentPage, pageSize);
        page = articleService.articleList(page);
        return Result.success("博客文章台账")
                .data("articleList", page.getRecords())
                .data("total", page.getTotal())
                .data("pages", page.getPages())
                .data("currentPage", currentPage);
    }


    /**
     * 文章详情
     *
     * @param articleId
     * @return
     */
    @GetMapping("/articleDetails/{articleId}")
    public Result articleDetails(@PathVariable("articleId") int articleId) {
        Article article = articleService.articleDetails(articleId);
        return Result.success("文章详情")
                .data("article", article);
    }


    /**
     * 文章新建/编辑
     *
     * @param data
     * @return
     */
    @PostMapping("/articleSave")
    public String articleSave(@RequestBody String data) {
        Article article = JSONObject.parseObject(data, Article.class);

        boolean succ = articleService.articleSave(article);
        if (succ) {
            return "保存成功";
        } else {
            return "保存失败";
        }
    }


    /**
     * 文章删除
     *
     * @param articleId
     * @return
     */
    @GetMapping("/articleDelete/{articleId}")
    public String articleDelete(@PathVariable("articleId") int articleId) {

        int succ = articleService.articleDelete(articleId);
        if (succ == 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }


    /**
     * 文章批量删除
     *
     * @param data
     * @return
     */
    @PostMapping("/deleteArticleAll")
    public String deleteArticleAll(@RequestBody String data) {
        JSONObject obj = JSONObject.parseObject(data);
        JSONArray idList = (JSONArray) obj.get("idList");

        boolean succ = articleService.articleDeleteAll(idList);
        if (succ) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

}
