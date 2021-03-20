package com.ruoyi.project.system.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.service.impl.SysSkillTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/skill")
public class SysSkillTypeController extends BaseController {

    @Autowired
    private SysSkillTypeServiceImpl sysSkillTypeService;

    @PostMapping
    public AjaxResult addSkill(@RequestBody Map<String, Object> map) {
        String techType = map.get("techType").toString();
        sysSkillTypeService.addSkill(techType);
        return AjaxResult.success("新增成功");
    }

    @GetMapping("/list")
    public TableDataInfo list(String techType) {
        startPage();
        List<Map<String, Object>> list = sysSkillTypeService.getList(techType);
        return getDataTable(list);
    }

    @DeleteMapping("/{ids}")
    public AjaxResult delSkill(@PathVariable Long[] ids) {
        sysSkillTypeService.delSkill(ids);
        return AjaxResult.success("删除成功");
    }

    @PutMapping
    public AjaxResult update(@RequestBody Map<String, Object> map) {
        sysSkillTypeService.editSkill(map);
        return AjaxResult.success();
    }

    @GetMapping("/info/{id}")
    public AjaxResult info(@PathVariable Long id) {
        return AjaxResult.success(sysSkillTypeService.info(id));
    }
}
