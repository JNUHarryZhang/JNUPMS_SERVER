package com.ruoyi.project.system.controller;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.service.impl.SysPaperInfoServiceImpl;
import org.apache.poi.hssf.record.TabIdRecord;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/paper")
public class SysPaperInfoController extends BaseController {

    @Resource
    private SysPaperInfoServiceImpl paperInfoService;

    @PostMapping
    public AjaxResult add(@RequestBody Map<String, Object> map) {
        map.put("paperYear", SecurityUtils.getYear());
        paperInfoService.add(map);
        return AjaxResult.success();
    }

    @PutMapping
    public AjaxResult edit(@RequestBody Map<String, Object> map) {
        paperInfoService.edit(map);
        return AjaxResult.success();
    }

    @DeleteMapping("/{ids}")
    public AjaxResult del(@PathVariable Long[] ids) {
        paperInfoService.del(ids);
        return AjaxResult.success();
    }

    @GetMapping("/list")
    public TableDataInfo list(@RequestParam Map<String, Object> map) {
        startPage();
        return getDataTable(paperInfoService.list(map));
    }

    @GetMapping("/info/{id}")
    public AjaxResult info(@PathVariable Long id) {
        return AjaxResult.success(paperInfoService.info(id));
    }
}
