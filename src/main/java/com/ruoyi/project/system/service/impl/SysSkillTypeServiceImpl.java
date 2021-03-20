package com.ruoyi.project.system.service.impl;

import com.ruoyi.project.system.mapper.SysSkillTypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SysSkillTypeServiceImpl {

    @Resource
    private SysSkillTypeMapper skillTypeMapper;

    public void addSkill(String techType) {
        skillTypeMapper.addSkill(techType);
    }

    public void editSkill(Map<String, Object> map) {
        skillTypeMapper.editSkill(map);
    }

    public void delSkill(Long[] ids) {
        skillTypeMapper.delSkill(ids);
    }

    public List<Map<String, Object>> getList(String techType) {
        return skillTypeMapper.querySkillList(techType);
    }

    public Map<String, Object> info(Long id) {
        return skillTypeMapper.queryInfoById(id);
    }
}
