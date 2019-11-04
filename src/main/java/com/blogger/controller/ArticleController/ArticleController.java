package com.blogger.controller.ArticleController;


import com.alibaba.fastjson.JSONObject;
import com.blogger.entity.ArticleEntity.Article;
import com.blogger.server.ArticleService.ArticleService;
import com.blogger.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // 文章台账
    @PostMapping("getArticleList")
    public Result getArticleList(@RequestBody String data) {
        JSONObject obj = JSONObject.parseObject(data);
        List<Article> articleList = articleService.getArticleList();
        return Result.success(articleList);
    }

    // 文章保存
    @PostMapping("saveArticle")
    public String saveArticle(@RequestBody String data) {
        JSONObject obj = JSONObject.parseObject(data);
        Article article = JSONObject.parseObject(data, Article.class);

        boolean succ = articleService.saveArticle(article);
        if (succ) {
            return "保存成功";
        } else {
            return "保存失败";
        }

    }

//    // 文章删除 批量删除
//    @PostMapping("deleteArticleAll")
//    public String  deleteArticleAll(@RequestBody String data) {
//        String oper = "deleteArticleAll";
//        JSONObject obj = JSONObject.parseObject(data);
//        JSONArray idList = (JSONArray) obj.get("idList");
//        boolean succ = schedulingMgmtService.deleteScheduling(idList);
//        if (succ) {
//            return  "删除成功";
//        } else {
//            return  "删除失败";
//        }
//    }

    // 文章删除 单独删除
    @PostMapping("deleteArticle/{articleId}")
    public String deleteArticle(@PathVariable("articleId") int articleId) {
        int succ = articleService.deleteArticle(articleId);
        if (succ == 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }


    // 文章详情
    @GetMapping("detailsArticle/{articleId}")
    public Article detailsArticle(@PathVariable("articleId") int articleId) {

        Article article = articleService.detailsArticle(articleId);
        return article;
    }


//    // 调度命令复制
//    @PostMapping("copyScheduling")
//    public Json copyScheduling(@RequestBody String data) {
//        String oper = "copyScheduling";
//        data = StringUtils.decode(data);
//        JSONObject obj = JSONObject.parseObject(data);
//        JSONArray idList = (JSONArray) obj.get("idList");
//
//        boolean succ = schedulingMgmtService.copyScheduling(idList);
//        if (succ) {
//            return Json.succ(oper, "复制成功");
//        } else {
//            return Json.succ(oper, "复制失败");
//        }
//    }
//
//
//    // 调度获取当前调度人员列表
//    @GetMapping("getSchedulingPersonGroup")
//    public Json getSchedulingPersonGroup() {
//        String oper = "getSchedulingPersonGroup";
//
//        List<JSONObject> SchedulingPersonGroup = schedulingMgmtService.getSchedulingPersonGroup();
//        return Json.succ(oper, "当前调度人员列表")
//                .data("PersonGroup", SchedulingPersonGroup);
//    }
}
