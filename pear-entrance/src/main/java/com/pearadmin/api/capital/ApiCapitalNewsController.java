package com.pearadmin.api.capital;

import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.system.domain.CapitalNews;
import com.pearadmin.system.service.ICapitalNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 新闻Controller
 *
 * @author wzh
 * @date 2021-08-09
 */
@RestController
@CrossOrigin //解决跨域问题
@RequestMapping("/api/capital/news")
public class ApiCapitalNewsController extends BaseController {
    private String prefix = "capital/news";

    @Autowired
    private ICapitalNewsService capitalNewsService;

    /**
     * 查询新闻列表
     *
     * @param capitalNews
     * @return
     */
    @GetMapping("/list")
    public Result list(CapitalNews capitalNews) {
        List<CapitalNews> capitalNewsList = capitalNewsService.selectCapitalNewsList(capitalNews);
        return success(capitalNewsList);
    }


    /**
     * 查看新闻详情
     *
     * @param id
     * @return
     */
    @GetMapping("/details")
    public Result details(Long id) {
        CapitalNews capitalNews = capitalNewsService.selectCapitalNewsById(id);
        return success(capitalNews);
    }

}
