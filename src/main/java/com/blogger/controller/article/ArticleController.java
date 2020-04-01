package com.blogger.controller.article;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.blogger.entity.article.Article;
import com.blogger.server.article.ArticleService;
import com.blogger.util.Result;
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

    @Autowired
    private ArticleService articleService;

    /**
     * 文章台账
     *
     * @param data
     * @return
     */
    @PostMapping("/getArticleList")
    public Result getArticleList(@RequestBody String data) {
        JSONObject obj = JSONObject.parseObject(data);
        int currentPage = obj.getInteger("currentPage");
        int pageSize = obj.getInteger("pageSize");

        Page<Article> page = new Page<>(currentPage, pageSize);
        page = articleService.getArticleList(page);

        return Result.success("文章台账")
                .data("articleList", page.getRecords())
                .data("total", page.getTotal())
                .data("pages", page.getPages())
                .data("currentPage", currentPage);
    }

    /**
     * 文章新建/编辑
     *
     * @param data
     * @return
     */
    @PostMapping("/saveArticle")
    public String saveArticle(@RequestBody String data) {
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

    /**
     * 文章删除 单独删除
     *
     * @param articleId
     * @return
     */
    @GetMapping("/deleteArticle/{articleId}")
    public String deleteArticle(@PathVariable("articleId") int articleId) {
        int succ = articleService.deleteArticle(articleId);
        if (succ == 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }


    /**
     * 文章详情
     *
     * @param articleId
     * @return
     */
    @GetMapping("/detailsArticle/{articleId}")
    public Article detailsArticle(@PathVariable("articleId") int articleId) {

        Article article = articleService.detailsArticle(articleId);
        return article;
    }

    // 导出文章Word文件 /// throws ParseException
//    @GetMapping("exportWrod/{articleId}")
//    public void exportWrod(HttpServletRequest request, HttpServletResponse response, @PathVariable("articleId") int articleId) {
//
//
//        List<Article> articleList = articleService.getArticleList();
//        Article article = articleService.detailsArticle(articleId);
//        Map<String, Object> params = new HashMap<>();
//        params.put("ArticleName", article.getArticleName());
//        // 工具类生成word文档（本地）
//        ExportWord.exportWord("C:/Users/DELL/Desktop/exportWord.docx", "C:/Users/DELL/Desktop",
//                article.getArticleName() + ".docx", params, request, response, article,articleList);
//
//        // 工具类生成word文档（服务器）   高明有轨电车XX月XX日运营日报
////        WorderToNewWordUtils.exportWord("/root/operateWord.docx", "/root", operationalProjectOne.getOperateName() + ".docx",
////                params, request, response, operationalProjectTimetables, operationalProjectDelayList, operationalProjectVehicleList, operationalProjectEventList, operationalProjectFaultList);
//    }
}
