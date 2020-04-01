package com.blogger.entity.article;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 *文章实体类
 * @author Liu wei
 * @date 2020-03-31 16:00
 **/
@Data
@TableName(value = "article")
public class Article {

    @TableField(value = "articleId", el = "博客ID")
    private String articleId;

    @TableField(value = "articleNum", el = "博客编号")
    private String articleNum;

    @TableField(value = "articleName", el = "博客名称")
    private String articleName;

    @TableField(value = "articleType", el = "博客类型")
    private String articleType;

    @TableField(value = "articleContent", el = "博客内容")
    private String articleContent;

    @TableField(value = "articleStatus", el = "博客状态")
    private String articleStatus;

    @TableField(value = "createPerson", el = "创建人")
    private String createPerson;

    @TableField(value = "createDate", el = "创建时间")
    private String createDate;

    @TableField(value = "updateDate", el = "更新时间")
    private String updateDate;


}
