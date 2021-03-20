package com.ruoyi.project.system.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.mapper.SysVocaMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/system/voca")
public class SysVocaController extends BaseController {

    @Resource
    private SysVocaMapper vocaMapper;

    @PostMapping
    public AjaxResult add(@RequestBody Map<String, Object> map) {
        vocaMapper.addVoca(map);
        return AjaxResult.success();
    }

    @PutMapping
    public AjaxResult edit(@RequestBody Map<String, Object> map) {
        vocaMapper.editVoca(map);
        return AjaxResult.success();
    }

    @DeleteMapping("/{ids}")
    public AjaxResult del(@PathVariable Long[] ids) {
        vocaMapper.delVoca(ids);
        return AjaxResult.success();
    }

    @GetMapping("/list")
    public TableDataInfo list(String vocaName) {
        startPage();
        return getDataTable(vocaMapper.queryVocaList(vocaName));
    }

    @GetMapping("/info/{id}")
    public AjaxResult info(@PathVariable Long id) {
        return AjaxResult.success(vocaMapper.queryVocaInfo(id));
    }
}
