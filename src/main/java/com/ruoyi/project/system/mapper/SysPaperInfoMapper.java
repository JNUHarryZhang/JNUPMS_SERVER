package com.ruoyi.project.system.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysPaperInfoMapper {
    String getPaperAddressById(@Param("id") Long id);

    int addPaperInfo(Map<String, Object> map);

    int editPaperInfo(Map<String, Object> map);

    int delPaperInfo(Long[] ids);

    List<Map<String, Object>> queryPaperList(Map<String, Object> map);

    Map<String, Object> getInfo(Long id);

    List<String> selectAllTitle();
}
