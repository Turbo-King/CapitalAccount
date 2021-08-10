package com.pearadmin.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 新闻对象 capital_news
 * 
 * @author wzh
 * @date 2021-08-09
 */
@Data
public class CapitalNews extends BaseDomain
{
    private static final long serialVersionUID = 1L;

    /** 新闻id */
    private Long id;

    /** 新闻标题 */
    private String title;

    /** 新闻图片 */
    private String img;

    /** 浏览人数 */
    private Long browseNum;

    /** 新闻内容 */
    private String content;

}
