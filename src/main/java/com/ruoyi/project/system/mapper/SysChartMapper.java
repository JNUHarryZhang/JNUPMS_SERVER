package com.ruoyi.project.system.mapper;

import com.ruoyi.project.system.domain.Tech;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysChartMapper {

    /**
     * 获取课题来源
     * @return
     */
    List<Map<String, Object>> getTitleSource();

    /**
     * 获取老师占比
     * @return
     */
    List<Map<String, Object>> getTeacher();

    List<Map<String, String>> getSkillTypeInfo();

    /**
     * 按年份获取技术总类
     * @return
     */
    List<Tech> getTechByYear();

    List<Map<String, Object>> selectTopTen();


    List<Map<String, Object>> selectTypes();

    /**
     * 论文 id techid
     * @return
     */
    List<Map<String, Object>> selectPaperIdTitle();
}
