package com.ruoyi.project.system.mapper;

import java.util.List;
import java.util.Map;

public interface SysStopWordMapper {

    int addStopWord(Map<String, Object> map);

    int editStopWord(Map<String, Object> map);

    int delStopWord(Long[] ids);

    List<Map<String, Object>> queryStopWordList(String vocaName);

    Map<String, Object> queryStopWordInfo(Long id);
}
