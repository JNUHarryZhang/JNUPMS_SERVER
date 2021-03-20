package com.ruoyi.project.system.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysVocaMapper {

    int addVoca(Map<String, Object> map);

    int editVoca(Map<String, Object> map);

    int delVoca(Long[] ids);

    List<Map<String, Object>> queryVocaList(@Param("vocaName") String vocaName);

    Map<String, Object> queryVocaInfo(Long id);

    List<String> selectAllName();
}
