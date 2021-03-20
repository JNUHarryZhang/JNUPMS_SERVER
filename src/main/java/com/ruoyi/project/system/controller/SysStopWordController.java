package com.ruoyi.project.system.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.mapper.SysStopWordMapper;
import com.ruoyi.project.system.mapper.SysVocaMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/system/stopWord")
public class SysStopWordController extends BaseController {

    @Resource
    private SysStopWordMapper stopWordMapper;

    @PostMapping
    public AjaxResult add(@RequestBody Map<String, Object> map) {
        stopWordMapper.addStopWord(map);
        return AjaxResult.success();
    }

    @PutMapping
    public AjaxResult edit(@RequestBody Map<String, Object> map) {
        stopWordMapper.editStopWord(map);
        return AjaxResult.success();
    }

    @DeleteMapping("/{ids}")
    public AjaxResult del(@PathVariable Long[] ids) {
        stopWordMapper.delStopWord(ids);
        return AjaxResult.success();
    }

    @GetMapping("/list")
    public TableDataInfo list(String vocaName) {
        startPage();
        return getDataTable(stopWordMapper.queryStopWordList(vocaName));
    }

    @GetMapping("/info/{id}")
    public AjaxResult info(@PathVariable Long id) {
        return AjaxResult.success(stopWordMapper.queryStopWordInfo(id));
    }
}
