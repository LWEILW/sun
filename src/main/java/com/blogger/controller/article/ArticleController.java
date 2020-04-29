package com.blogger.controller.article;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.blogger.entity.article.Article;
import com.blogger.server.article.ArticleService;
import com.blogger.util.*;
import com.blogger.util.word.RichHtmlHandler;
import com.blogger.util.word.RichObject;
import com.blogger.util.word.WordGeneratorWithFreemarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;

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
     * 文章删除 批量删除
     *
     * @param data
     * @return
     */
    @PostMapping("/deleteArticleAll")
    public String deleteArticleAll(@RequestBody String data) {
        JSONObject obj = JSONObject.parseObject(data);
        JSONArray list = (JSONArray) obj.get("idList");
        boolean succ = articleService.deleteArticleAll(list);
        if (succ) {
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
        return articleService.detailsArticle(articleId);
    }

    /**
     * 运营日报导出Word文档
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    @GetMapping("/wordExport")
    public void wordExport(HttpServletRequest request, HttpServletResponse response) throws ParseException, Exception {
//        // 第一种
//        Map<String, Object> params = new HashMap<>();
//        // 线路
//        params.put("dailySiteName", "1");
//        // 日期
//        params.put("dailyDate", "1");
//        // 表名
//        params.put("dailyName", "1");
//        // 更新时间
//        params.put("updateDate", "1");
//
//        System.out.println("1");
//
//        // 工具类生成word文档（本地）
//        WordExport.exportWord("C:/Users/DELL/Desktop/dome.docx", "C:/Users/DELL/Desktop", "123456.docx",
//                params, request, response);

        // 第二种
//        String content = "<figure class=\"image\"><img src=\"http://192.168.0.26:80/group1/M00/00/03/wKgAGl6dcrKAb5qlAACA9YnlRKA474.jpg?attname=6c5a6de1ly1gc9pvkh1saj20go0tn0vf.jpg\"></figure><p>24能我确认</p>";
//        String content="<div align=\"center\">\n" +
//                "<div id=\"main\" style=\"width:800px;text-align:left\">\n" +
//                "<div id=\"logo\"><a href=\"http://www.cnblogs.com/\"><img src=\"//static.cnblogs.com/images/logo150.gif\" alt=\"博客园logo\" style=\"border:0px\"></a></div>\n" +
//                "<div id=\"tips\" style=\"margin-top:10px;margin-bottom:10px;\">\n" +
//                "<p><b style=\"color:red;font-size:14px\">抱歉！系统发生了错误!</b></p>\n" +
//                "<span id=\"url\"></span>\n" +
//                "<p>麻烦您发邮件至 <a href=\"mailto:contact@cnblogs.com\">contact@cnblogs.com</a> 与管理员联系。</p>\n" +
//                "</div>\n" +
//                "<div id=\"sitelink\">\n" +
//                "\n" +
//                "</div>\n" +
//                "<div style=\"margin-top:10px;color:gray\">\n" +
//                "\n" +
//                "</div>\n" +
//                "</div>\n" +
//                "</div>";
//        WordUtil.exportWord(request, response, "nihao", content);

        // 第三种
        aaa();

//        ccc();
//        bbb();
    }


    public static void aaa() throws Exception {
        //用map存放数据
        HashMap<String, Object> data = new HashMap<String, Object>();
        //创建富文本
        StringBuilder sb = new StringBuilder();

        sb.append("<figure class=\"image\"><img src=\"C:/Users/DELL/Desktop/111111.png\"></figure><p>24能我确认</p>");
//        sb.append("<img style='height:100px;width:200px;display:block;' src='http://192.168.0.26:80/group1/M00/00/03/wKgAGl6dcrKAb5qlAACA9YnlRKA474.jpg?attname=6c5a6de1ly1gc9pvkh1saj20go0tn0vf.jpg' />");
//        sb.append("</br><span>wesley 演示 导出富文本！@@#######￥￥%%%%………………&&&**~~~~~~&&&&&&&&、、、、、、、、</span>");
//        sb.append("</br><span>----多图分割线---</span>");
//        sb.append("</br><img style='height:100px;width:200px;display:block;' src='http://192.168.0.26:80/group1/M00/00/03/wKgAGl6dcrKAb5qlAACA9YnlRKA474.jpg?attname=6c5a6de1ly1gc9pvkh1saj20go0tn0vf.jpg' />");
//        sb.append("</br><span>中国梦，幸福梦！</span>");
//        sb.append("</div>");

        RichObject richObject = new RichObject();
        richObject.setHtml(sb.toString());
        //--------------------此处可以spring配置文件配置，也可以直接读取属性文件获取------------------
        //从mht文件中找
        richObject.setDocSrcLocationPrex("file:///C:/373956B1");
        richObject.setDocSrcParent("wordExport1.files");
        richObject.setNextPartId("01D61886.34195CD0");

        richObject.setShapeidPrex("_x56fe__x7247__x0020");
        richObject.setTypeid("#_x0000_t75");
        richObject.setSpidPrex("_x0000_i");

        richObject.setWebAppliction(false);


        RichHtmlHandler richHtmlHandler = WordGeneratorWithFreemarker.createRichHtmlHandler(richObject);
        List<RichHtmlHandler> richHtmlHandlerList = new ArrayList<RichHtmlHandler>();
        richHtmlHandlerList.add(richHtmlHandler);

        data.put("imagesXmlHrefString", WordGeneratorWithFreemarker.getXmlImgHref(richHtmlHandlerList));
        data.put("imagesBase64String", WordGeneratorWithFreemarker.getImagesBase64String(richHtmlHandlerList));

        // 线路
        data.put("dailySiteName", "1");
        // 日期
        data.put("dailyDate", "1");
        // 表名
        data.put("dailyName", "1");
        // 更新时间
        data.put("updateDate", "1");
        data.put("name", "wesley");
        data.put("datetime", "2017-05-10");
        data.put("title", "演示demo");
        data.put("context1", richHtmlHandler.getHandledDocBodyBlock());
        data.put("context2", richHtmlHandler.getHandledDocBodyBlock());
        data.put("context3", richHtmlHandler.getHandledDocBodyBlock());
        data.put("context4", richHtmlHandler.getHandledDocBodyBlock());
        data.put("context5", richHtmlHandler.getHandledDocBodyBlock());
        data.put("context6", richHtmlHandler.getHandledDocBodyBlock());

        String docFilePath = "C:/Users/DELL/Desktop/11.doc";
        String templatePath = "C:/Users/DELL/Desktop";
        //这里我的路径有空格添加此处理
        templatePath = java.net.URLDecoder.decode(templatePath, "utf-8");
        WordGeneratorWithFreemarker.createDoc(templatePath, "wordExport1.ftl", data, docFilePath);
    }


    public static void bbb() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");

        RichObject richObject = context.getBean(RichObject.class);

        //用map存放数据
        HashMap<String, Object> data = new HashMap<String, Object>();
        //创建富文本
        StringBuilder sb = new StringBuilder();
        sb.append("<p>24能我确认</p>");
//        sb.append("<div>");
//        sb.append("<img style='height:100px;width:200px;display:block;' src='w:\\2.jpg' />");
//        sb.append("</br><span>wesley 演示 spring 使用导出富文本！</span>");
//        sb.append("</br><span>----多图分割线---</span>");
//        sb.append("</br><img style='height:100px;width:200px;display:block;' src='w:\\1.jpg' />");
//        sb.append("</br><span>中国梦，幸福梦！</span>");
//        sb.append("</div>");
        richObject.setHtml(sb.toString());

        RichHtmlHandler richHtmlHandler = WordGeneratorWithFreemarker.createRichHtmlHandler(richObject);
        List<RichHtmlHandler> richHtmlHandlerList = new ArrayList<RichHtmlHandler>();
        richHtmlHandlerList.add(richHtmlHandler);

        data.put("imagesXmlHrefString", WordGeneratorWithFreemarker.getXmlImgHref(richHtmlHandlerList));
//        logger.debug("------imagesXmlHrefString-------" + WordGeneratorWithFreemarker.getXmlImgHref(richHtmlHandlerList));
        data.put("imagesBase64String", WordGeneratorWithFreemarker.getImagesBase64String(richHtmlHandlerList));
//        logger.debug("------imagesBase64String-------" + WordGeneratorWithFreemarker.getImagesBase64String(richHtmlHandlerList));
        data.put("name", "wesley");
        data.put("datetime", "2017-05-10");
        data.put("title", "演示demo");
        data.put("context1", richHtmlHandler.getHandledDocBodyBlock());
        data.put("context2", richHtmlHandler.getHandledDocBodyBlock());
        data.put("context3", richHtmlHandler.getHandledDocBodyBlock());
        data.put("context4", richHtmlHandler.getHandledDocBodyBlock());
        data.put("context5", richHtmlHandler.getHandledDocBodyBlock());
        data.put("context6", richHtmlHandler.getHandledDocBodyBlock());

        String docFilePath = "C:/Users/DELL/Desktop/11.doc";
        String templatePath = Class.class.getResource("/ftl").getPath();
        templatePath = java.net.URLDecoder.decode(templatePath, "utf-8");//这里我的路径有空格添加此处理
//        logger.debug("------templatePath-------" + templatePath);
        WordGeneratorWithFreemarker.createDoc(templatePath, "wordExport.ftl", data, docFilePath);
    }

    public static void ccc() throws Exception {
        ExportDoc maker = new ExportDoc("UTF-8");
        maker.exportDoc("C:/Users/DELL/Desktop/", "wordExport.ftl");
        //maker.
    }

    /**
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void ddd() throws UnsupportedEncodingException {

        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("xytitle", "试卷");
        int index = 1;
        // 选择题
        List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();//题目
        List<Map<String, Object>> list11 = new ArrayList<Map<String, Object>>();//答案
        index = 1;
        for (int i = 0; i < 5; i++) {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("xzn", index + ".");
            map.put("xztest",
                    "(   )操作系统允许在一台主机上同时连接多台终端，多个用户可以通过各自的终端同时交互地使用计算机。");
            map.put("ans1", "A" + index);
            map.put("ans2", "B" + index);
            map.put("ans3", "C" + index);
            map.put("ans4", "D" + index);
            list1.add(map);

            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("fuck", index + ".");
            map1.put("abc", "A" + index);
            list11.add(map1);

            index++;
        }
        dataMap.put("table1", list1);
        dataMap.put("table11", list11);

        // 填空题
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> list12 = new ArrayList<Map<String, Object>>();
        index = 1;
        for (int i = 0; i < 5; i++) {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("tkn", index + ".");
            map.put("tktest",
                    "操作系统是计算机系统中的一个___系统软件_______，它管理和控制计算机系统中的___资源_________.");
            list2.add(map);

            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("fill", index + ".");
            map1.put("def", "中级调度" + index);
            list12.add(map1);

            index++;
        }
        dataMap.put("table2", list2);
        dataMap.put("table12", list12);

        // 判断题
        List<Map<String, Object>> list3 = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> list13 = new ArrayList<Map<String, Object>>();
        index = 1;
        for (int i = 0; i < 5; i++) {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("pdn", index + ".");
            map.put("pdtest",
                    "复合型防火墙防火墙是内部网与外部网的隔离点，起着监视和隔绝应用层通信流的作用，同时也常结合过滤器的功能。");
            list3.add(map);

            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("judge", index + ".");
            map1.put("hij", "对" + index);
            list13.add(map1);

            index++;
        }
        dataMap.put("table3", list3);
        dataMap.put("table13", list13);

        // 简答题
        List<Map<String, Object>> list4 = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> list14 = new ArrayList<Map<String, Object>>();
        index = 1;
        for (int i = 0; i < 5; i++) {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("jdn", index + ".");
            map.put("jdtest", "说明作业调度，中级调度和进程调度的区别，并分析下述问题应由哪一级调度程序负责。");
            list4.add(map);

            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("answer", index + ".");
            map1.put("xyz", "说明作业调度，中级调度和进程调度的区别，并分析下述问题应由哪一级调度程序负责。");
            list14.add(map1);

            index++;
        }
        dataMap.put("table4", list4);
        dataMap.put("table14", list14);

        DocumentHandler mdoc = new DocumentHandler();
        mdoc.createDoc(dataMap, "C:/Users/DELL/Desktop/22.docx");
    }

//    /**
//     * 浏览器导出word
//     * @param modelName 模板文件名（包含后缀ftl）
//     * @param fileName 导出文件名
//     * @param dataMap 数据Map
//     * @param request HttpServletRequest
//     * @param response HttpServletResponse
//     */
//    public void downloadDoc(String modelName, String fileName, Map dataMap, HttpServletRequest request, HttpServletResponse response){
//        Writer writer = null;
//        String filename = "";
//
//        try {
//            //编码文件名并加上后缀
//            filename = encodeChineseDownloadFileName(request, fileName) + ".doc";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            //设置HTTP响应头
//            //response.setContentType("application/msword");
//            //response.addHeader("Content-Disposition","attachment; filename="+"haha");
//            response.setHeader("Content-disposition", filename);
//            response.setContentType("application/msword");
//            response.setHeader("Content-disposition", "attachment;filename=" + filename);
//            response.setHeader("Pragma", "No-cache");
//            writer = response.getWriter();
//            //writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\ttt.doc"), encoding));
//            Template template = this.getTemplate(modelName);
//            //template.process(this.getSjDataMap(), writer);
//            template.process(dataMap, writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if(writer != null){
//                try {
//                    writer.flush();
//                    writer.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

}
