package com.pearadmin.api.capital;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.tools.secure.SecurityUtil;
import com.pearadmin.common.tools.string.Convert;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.system.domain.CapitalHistory;
import com.pearadmin.system.domain.SysUser;
import com.pearadmin.system.service.ICapitalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 交易记录Controller
 *
 * @author wzh
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/api/capital/history")
public class ApiCapitalHistoryController extends BaseController {

    @Autowired
    private ICapitalHistoryService capitalHistoryService;


    /**
     * 查询账户交易记录
     *
     * @param accountId
     * @return
     */
    @GetMapping("/list")
    public Result list(String accountId) {
        List<CapitalHistory> capitalHistoryList = capitalHistoryService.selectCapitalHistoryByAccountId(accountId);
        System.out.println(capitalHistoryList);
        return success(capitalHistoryList);
    }

}
