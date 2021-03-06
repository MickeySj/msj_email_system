package com.msj.controller;

import com.msj.entity.Top;
import com.msj.service.TopService;
import com.msj.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sj
 * @version 1.0
 * @date 2020/10/9 14:37
 */
@Controller
@RequestMapping("/top")
public class TopController {
    @Autowired
    private TopService topService;

    @RequestMapping("/topList")
    public String getTopList(Model model, @RequestParam(name = "current", required = false, defaultValue = "1") int current) {
        PageUtils goodPageUtils = new PageUtils(current, 6);
//        goodPageUtils.setCurrent(current);
        goodPageUtils.setRecordTotal(topService.getRecordsTotal());
        model.addAttribute("type", 1);
        model.addAttribute("goodList", topService.getTodayListLimit(goodPageUtils.getCurrent(), goodPageUtils.getPageSize()));
        model.addAttribute("page", goodPageUtils);
        model.addAttribute("url", "/top/topList");
        return "admin/good_list";
    }

    /* 今日推荐的添加 */
    @RequestMapping("/topSave")
    @ResponseBody
    public String topSave(Top top) {
        return String.valueOf(topService.insert(top));
    }

    /* 今日推荐的删除 */
    @RequestMapping("/topDelete")
    @ResponseBody
    public String topDelete(Top top) {
        return String.valueOf(topService.deleteByGoodAndType(top.getGoodId(), top.getType()));
    }
}
