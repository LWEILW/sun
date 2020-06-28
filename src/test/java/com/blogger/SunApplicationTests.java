package com.blogger;


import com.blogger.util.word.RichHtmlHandler;
import com.blogger.util.word.RichObject;
import com.blogger.util.word.WordGeneratorWithFreemarker;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SunApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(SunApplicationTests.class);


    @Test
    public void contextLoads() {

    }

    @Test
    public static void main(String[] args) throws Exception {
        b();









//        if (blogIdArr != null && blogIdArr.length != 1) {
//            //多篇博客文章下载
//            String zipName = "博客下载.zip" + "_" + DateUtils.getDateToStringByPattern(new Date(), "yyyyMMddHHmmss");
//            response.setCharacterEncoding("ISO8859-1");
//            response.setContentType("APPLICATION/OCTET-STREAM"); // 设置response的编码方式
//            response.setHeader("Content-Disposition",
//                    "attachment; filename=" + new String(zipName.getBytes("GBK"), "ISO8859-1"));
//            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(response.getOutputStream()));
//            BlogNote blogNote = null;
//            for (String id : blogIdArr) {
//                //单个博客文章下载
//                handledBase64Block = "";
//                xmlimaHref = "";
//                blogNote = blogNoteService.getByPrimaryKey(id);
//                // 设置response参数，可以打开下载页面
//                String fileName = blogNote.getTitle() + "_" + DateUtils.getDateToStringByPattern(new Date(), "yyyyMMddHHmmss");
//                out.putNextEntry(new ZipEntry(fileName + ".doc"));
//                ByteArrayOutputStream os = new ByteArrayOutputStream();
//                downloadSingleBlog(os, blogNote, response);
//                // 写文件
//                os.writeTo(out);
//                out.flush();
//                out.closeEntry();
//                os.close();
//                response.flushBuffer();
//            }
//            if (out != null) {
//                out.close();
//            }
//        }

    }

//    /**项目所在tomcat位置*/
//    public String appRootPath;
//
//    public String handledBase64Block;
//
//    public String xmlimaHref;
//
//    public void downloadBlog(String blogIds, HttpServletResponse response, HttpServletRequest request) throws IOException {
//        appRootPath = request.getSession().getServletContext().getRealPath("/");  //寻找试题图片的时候需要这个
//
//        //单个博客文章下载
//        handledBase64Block = "";
//        xmlimaHref = "";
//        BlogNote blogNote = blogNoteService.getByPrimaryKey(blogIdArr[0]);
//        // 设置response参数，可以打开下载页面
//        String fileName = blogNote.getTitle() + "_" + DateUtils.getDateToStringByPattern(new Date(), "yyyyMMddHHmmss");
//
//        response.reset();
//        response.setContentType("application/msword;charset=utf-8");
//        response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("GBK"), "ISO8859-1") + ".doc");
//        ServletOutputStream out = response.getOutputStream();
//        downloadSingleBlog(out, blogNote, response);
//    }

//    /**
//     * 下载单篇或多篇博客文章提取的公共方法
//     * @createUser shandianlala
//     * @createDate 2017年10月20日
//     * @param out 输出流
//     * @param blogNote 博客文章
//     * @param response http响应
//     * @throws IOException
//     */
//    private void downloadSingleBlog(OutputStream out, BlogNote blogNote, HttpServletResponse response) throws IOException{
//        Template template = getTemplate();
//        if(template != null) {
//            Map<String, Object> dataMap = new HashMap<String, Object>();
//            dataMap.put("createTime", DateUtils.getDateToStringByPattern(blogNote.getCreateTime(), "YYYY年MM月dd日  hh:mm"));
//
//            RichHtmlHandler handler = new RichHtmlHandler(blogNote.getBlogContent(), appRootPath + File.separator);
//            blogNote.setBlogContent(handler.getHandledDocBodyBlock());
//
//            handledBase64Block += handler.getData(handler.getDocBase64BlockResults());
//            xmlimaHref += handler.getData(handler.getXmlImgRefs());
//            dataMap.put("imagesBase64String", handledBase64Block);
//            dataMap.put("imagesXmlHrefString", xmlimaHref);
//            dataMap.put("blogNote", blogNote);
//            Writer wb = null;
//            try {
//                wb = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
//                template.process(dataMap, wb);//写数据到模板
//                wb.close();
//            } catch (FileNotFoundException e1) {
//                e1.printStackTrace();
//            } catch (TemplateException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }

//
//    /**
//     * 获取博客文章下载模板 .ftl文件
//     * @createUser shandianlala
//     * @createDate 2017年10月20日
//     * @return
//     */
//    public Template getTemplate() {
//        //设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库装载，
//        //这里我们的模板是放在resources/template 目录下面
//        Configuration configuration = new Configuration();
//        configuration.setDefaultEncoding("UTF-8");
//        configuration.setClassForTemplateLoading(this.getClass(), "/");
//        Template template = null;
//        try {
//            //blogTemplate.ftl为要装载的模板
//            template = configuration.getTemplate("template/blogTemplate.ftl", "UTF-8");
//            return template;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }






    public static void a() throws Exception {
        //用map存放数据
        HashMap<String, Object> data = new HashMap<String, Object>();
        //创建富文本
        StringBuilder sb = new StringBuilder();
        sb.append("<div>");
//        sb.append("<img style='height:100px;width:200px;display:block;' src='C:\\Users\\DELL\\Desktop\\111111111111.jpg' />");
        sb.append("</br><span>wesley 演示 导出富文本！@@#######￥￥%%%%………………&&&**~~~~~~&&&&&&&&、、、、、、、、</span>");
        sb.append("</br><span>----多图分割线---</span>");
//        sb.append("</br><img style='height:100px;width:200px;display:block;' src='C:\\Users\\DELL\\Desktop\\111111111111.jpg' />");
        sb.append("</br><span>中国梦，幸福梦！</span>");
        sb.append("</div>");

        RichObject richObject = new RichObject();
        richObject.setHtml(sb.toString());
        //--------------------此处可以spring配置文件配置，也可以直接读取属性文件获取------------------
        //从mht文件中找
        richObject.setDocSrcLocationPrex("file:///C:/268BA2D4"); //这里是从mht中获取的资源文件所在的文件夹
        richObject.setDocSrcParent("test.files"); //资源文件夹名字
        richObject.setNextPartId("01D644AA.16C9A090"); //下一部分的ID
        //以下三个属性字段我也不是很懂 查询网上是这么用的 不过根据字段应该大致能猜到是做什么用的。
        richObject.setShapeidPrex("_x56fe__x7247__x0020");
        richObject.setTypeid("#_x0000_t75");
        richObject.setSpidPrex("_x0000_i");

        richObject.setWebAppliction(false);

        //这里封装了一个Hnadler处理对象，来处理数据。
        RichHtmlHandler richHtmlHandler = WordGeneratorWithFreemarker.createRichHtmlHandler(richObject);
        List<RichHtmlHandler> richHtmlHandlerList = new ArrayList<RichHtmlHandler>();
        richHtmlHandlerList.add(richHtmlHandler);
        //这里就是我们刚才加的两个字段，也是我们富文本文件处理的关键两个字段
        data.put("imagesXmlHrefString", WordGeneratorWithFreemarker.getXmlImgHref(richHtmlHandlerList));//
        logger.debug("------imagesXmlHrefString-------" + WordGeneratorWithFreemarker.getXmlImgHref(richHtmlHandlerList));
        data.put("imagesBase64String", WordGeneratorWithFreemarker.getImagesBase64String(richHtmlHandlerList));
        logger.debug("------imagesBase64String-------" + WordGeneratorWithFreemarker.getImagesBase64String(richHtmlHandlerList));

        data.put("name", "wesley");
        data.put("datetime", "2017-05-10");
        data.put("image", "演示demo");
        data.put("content", richHtmlHandler.getHandledDocBodyBlock());



        String docFilePath = "C:/Users/DELL/Desktop/123.docx";//目标文件
        String templatePath = "C:/Users/DELL/Desktop";
        templatePath = java.net.URLDecoder.decode(templatePath, "utf-8");//这里我的路径有空格添加此处理
        logger.debug("------templatePath-------" + templatePath);
        WordGeneratorWithFreemarker.createDoc(templatePath, "test.ftl", data, docFilePath);
    }


    public static void b() throws Exception {
        //用map存放数据
        HashMap<String, Object> data = new HashMap<String, Object>();
        //创建富文本
        StringBuilder sb = new StringBuilder();

        sb.append("<figure class=\"image\"><img src=\"C:/Users/DELL/Desktop/111111111111.jpg\"></figure><p>24能我确认</p>");
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
        richObject.setDocSrcLocationPrex("file:///C:/268BA2D4");
        richObject.setDocSrcParent("test.files");
        richObject.setNextPartId("01D644AA.16C9A090");

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
        data.put("name", "1");
        // 日期
        data.put("image", "1");
        data.put("content", richHtmlHandler.getHandledDocBodyBlock());

        String docFilePath = "C:/Users/DELL/Desktop/11.doc";
        String templatePath = "C:/Users/DELL/Desktop";
        //这里我的路径有空格添加此处理
        templatePath = java.net.URLDecoder.decode(templatePath, "utf-8");
        WordGeneratorWithFreemarker.createDoc(templatePath, "test.ftl", data, docFilePath);
    }
//
//
//    public static void c() throws Exception {
//        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
//
//        RichObject richObject = context.getBean(RichObject.class);
//
//        //用map存放数据
//        HashMap<String, Object> data = new HashMap<String, Object>();
//        //创建富文本
//        StringBuilder sb = new StringBuilder();
//        sb.append("<p>24能我确认</p>");
////        sb.append("<div>");
////        sb.append("<img style='height:100px;width:200px;display:block;' src='w:\\2.jpg' />");
////        sb.append("</br><span>wesley 演示 spring 使用导出富文本！</span>");
////        sb.append("</br><span>----多图分割线---</span>");
////        sb.append("</br><img style='height:100px;width:200px;display:block;' src='w:\\1.jpg' />");
////        sb.append("</br><span>中国梦，幸福梦！</span>");
////        sb.append("</div>");
//        richObject.setHtml(sb.toString());
//
//        RichHtmlHandler richHtmlHandler = WordGeneratorWithFreemarker.createRichHtmlHandler(richObject);
//        List<RichHtmlHandler> richHtmlHandlerList = new ArrayList<RichHtmlHandler>();
//        richHtmlHandlerList.add(richHtmlHandler);
//
//        data.put("imagesXmlHrefString", WordGeneratorWithFreemarker.getXmlImgHref(richHtmlHandlerList));
////        logger.debug("------imagesXmlHrefString-------" + WordGeneratorWithFreemarker.getXmlImgHref(richHtmlHandlerList));
//        data.put("imagesBase64String", WordGeneratorWithFreemarker.getImagesBase64String(richHtmlHandlerList));
////        logger.debug("------imagesBase64String-------" + WordGeneratorWithFreemarker.getImagesBase64String(richHtmlHandlerList));
//        data.put("name", "wesley");
//        data.put("datetime", "2017-05-10");
//        data.put("title", "演示demo");
//        data.put("context1", richHtmlHandler.getHandledDocBodyBlock());
//        data.put("context2", richHtmlHandler.getHandledDocBodyBlock());
//        data.put("context3", richHtmlHandler.getHandledDocBodyBlock());
//        data.put("context4", richHtmlHandler.getHandledDocBodyBlock());
//        data.put("context5", richHtmlHandler.getHandledDocBodyBlock());
//        data.put("context6", richHtmlHandler.getHandledDocBodyBlock());
//
//        String docFilePath = "C:/Users/DELL/Desktop/11.doc";
//        String templatePath = Class.class.getResource("/ftl").getPath();
//        templatePath = java.net.URLDecoder.decode(templatePath, "utf-8");//这里我的路径有空格添加此处理
////        logger.debug("------templatePath-------" + templatePath);
//        WordGeneratorWithFreemarker.createDoc(templatePath, "wordExport.ftl", data, docFilePath);
//    }
//
//
//    public static void d() throws Exception {
//        ExportDoc maker = new ExportDoc("UTF-8");
//        maker.exportDoc("C:/Users/DELL/Desktop/", "wordExport.ftl");
//        //maker.
//    }
//
//
//    public static void e() throws UnsupportedEncodingException {
//
//        Map<String, Object> dataMap = new HashMap<String, Object>();
//        dataMap.put("xytitle", "试卷");
//        int index = 1;
//        // 选择题
//        List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();//题目
//        List<Map<String, Object>> list11 = new ArrayList<Map<String, Object>>();//答案
//        index = 1;
//        for (int i = 0; i < 5; i++) {
//
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("xzn", index + ".");
//            map.put("xztest",
//                    "(   )操作系统允许在一台主机上同时连接多台终端，多个用户可以通过各自的终端同时交互地使用计算机。");
//            map.put("ans1", "A" + index);
//            map.put("ans2", "B" + index);
//            map.put("ans3", "C" + index);
//            map.put("ans4", "D" + index);
//            list1.add(map);
//
//            Map<String, Object> map1 = new HashMap<String, Object>();
//            map1.put("fuck", index + ".");
//            map1.put("abc", "A" + index);
//            list11.add(map1);
//
//            index++;
//        }
//        dataMap.put("table1", list1);
//        dataMap.put("table11", list11);
//
//        // 填空题
//        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
//        List<Map<String, Object>> list12 = new ArrayList<Map<String, Object>>();
//        index = 1;
//        for (int i = 0; i < 5; i++) {
//
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("tkn", index + ".");
//            map.put("tktest",
//                    "操作系统是计算机系统中的一个___系统软件_______，它管理和控制计算机系统中的___资源_________.");
//            list2.add(map);
//
//            Map<String, Object> map1 = new HashMap<String, Object>();
//            map1.put("fill", index + ".");
//            map1.put("def", "中级调度" + index);
//            list12.add(map1);
//
//            index++;
//        }
//        dataMap.put("table2", list2);
//        dataMap.put("table12", list12);
//
//        // 判断题
//        List<Map<String, Object>> list3 = new ArrayList<Map<String, Object>>();
//        List<Map<String, Object>> list13 = new ArrayList<Map<String, Object>>();
//        index = 1;
//        for (int i = 0; i < 5; i++) {
//
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("pdn", index + ".");
//            map.put("pdtest",
//                    "复合型防火墙防火墙是内部网与外部网的隔离点，起着监视和隔绝应用层通信流的作用，同时也常结合过滤器的功能。");
//            list3.add(map);
//
//            Map<String, Object> map1 = new HashMap<String, Object>();
//            map1.put("judge", index + ".");
//            map1.put("hij", "对" + index);
//            list13.add(map1);
//
//            index++;
//        }
//        dataMap.put("table3", list3);
//        dataMap.put("table13", list13);
//
//        // 简答题
//        List<Map<String, Object>> list4 = new ArrayList<Map<String, Object>>();
//        List<Map<String, Object>> list14 = new ArrayList<Map<String, Object>>();
//        index = 1;
//        for (int i = 0; i < 5; i++) {
//
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("jdn", index + ".");
//            map.put("jdtest", "说明作业调度，中级调度和进程调度的区别，并分析下述问题应由哪一级调度程序负责。");
//            list4.add(map);
//
//            Map<String, Object> map1 = new HashMap<String, Object>();
//            map1.put("answer", index + ".");
//            map1.put("xyz", "说明作业调度，中级调度和进程调度的区别，并分析下述问题应由哪一级调度程序负责。");
//            list14.add(map1);
//
//            index++;
//        }
//        dataMap.put("table4", list4);
//        dataMap.put("table14", list14);
//
//        DocumentHandler mdoc = new DocumentHandler();
//        mdoc.createDoc(dataMap, "C:/Users/DELL/Desktop/22.docx");
//    }


}
