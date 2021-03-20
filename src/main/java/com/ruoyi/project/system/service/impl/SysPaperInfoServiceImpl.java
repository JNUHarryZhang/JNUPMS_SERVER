package com.ruoyi.project.system.service.impl;

import com.ruoyi.project.system.mapper.SysPaperInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SysPaperInfoServiceImpl {

    @Resource
    private SysPaperInfoMapper paperInfoMapper;

    public void add(Map<String, Object> map) {
        paperInfoMapper.addPaperInfo(map);
    }

    public void edit(Map<String, Object> map) {
        paperInfoMapper.editPaperInfo(map);
    }

    public void del(Long[] ids) {
        paperInfoMapper.delPaperInfo(ids);
    }

    public List<Map<String, Object>> list(Map<String, Object> map) {
        return paperInfoMapper.queryPaperList(map);
    }

    public Map<String, Object> info(Long id) {
        return paperInfoMapper.getInfo(id);
    }
}
