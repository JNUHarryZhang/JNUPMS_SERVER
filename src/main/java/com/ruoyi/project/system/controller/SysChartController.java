package com.ruoyi.project.system.controller;

import com.ruoyi.common.utils.ip.IpUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.service.impl.SysChartServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/system/chart")
public class SysChartController extends BaseController {

    @Resource
    private SysChartServiceImpl chartService;

    @GetMapping("/titleSource")
    public AjaxResult titleSource() {
        return AjaxResult.success(chartService.getTitleSource());
    }

    @GetMapping("/teacherSource")
    public AjaxResult teacherSource() {
        return AjaxResult.success(chartService.getTeacher());
    }

    @GetMapping("/techByYear")
    public AjaxResult getTechByYear() {
        return AjaxResult.success(chartService.getTechByYear());
    }

    @GetMapping("/wordUrl")
    public AjaxResult getUrl() {
        String url = IpUtils.getHostIp() + "/profile/test.png";
        return AjaxResult.success(url);
    }

    @GetMapping("/getTopTen")
    public AjaxResult getTopTen() {
        return AjaxResult.success(chartService.getTopTen());
    }

    @GetMapping("/tu")
    public AjaxResult getTu() {
        return AjaxResult.success(chartService.getTuPu());
    }

}
