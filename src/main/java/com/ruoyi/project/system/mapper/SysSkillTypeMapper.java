package com.ruoyi.project.system.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysSkillTypeMapper {

    int addSkill(String techType);

    int editSkill(Map<String, Object> map);

    int delSkill(Long[] ids);

    List<Map<String, Object>> querySkillList(@Param("techType") String techType);

    Map<String, Object> queryInfoById(Long id);
}
