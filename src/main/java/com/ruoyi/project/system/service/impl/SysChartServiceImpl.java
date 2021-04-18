package com.ruoyi.project.system.service.impl;

import com.ruoyi.common.enums.TitleSource;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.project.system.domain.Tech;
import com.ruoyi.project.system.domain.vo.TechTotal;
import com.ruoyi.project.system.mapper.SysChartMapper;
import com.ruoyi.project.system.mapper.SysPaperInfoMapper;
import com.ruoyi.project.system.mapper.SysSkillTypeMapper;
import com.ruoyi.project.system.mapper.SysVocaMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


@Service
public class SysChartServiceImpl {

    @Resource
    private SysChartMapper chartMapper;

    @Resource
    private SysSkillTypeMapper skillTypeMapper;

    @Resource
    private SysPaperInfoMapper paperInfoMapper;

    @Resource
    private SysVocaMapper vocaMapper;

    public static final Logger log = LoggerFactory.getLogger(SysChartServiceImpl.class);

    public List<Map<String, Object>> getTitleSource() {
        List<Map<String, Object>> titleSource = chartMapper.getTitleSource();
        for (Map<String, Object> map : titleSource) {
            map.put("name", TitleSource.get(map.get("name").toString()));
        }
        return titleSource;
    }

    public List<Map<String, Object>> getTeacher() {
        return chartMapper.getTeacher();
    }

    public Map<String, Object> getTechByYear() {

        Map<String, Object> result = new HashMap<>();

        Map<Long, String> skill = new HashMap<>();
        List<Map<String, Object>> skillList = skillTypeMapper.querySkillList("");
        for (Map<String, Object> map : skillList) {
            Long id = ((BigInteger) map.get("id")).longValue();
            String techType = (String) map.get("techType");
            skill.put(id, techType);
        }
        List<Tech> techByYear = chartMapper.getTechByYear();
        techByYear.sort(Comparator.comparing(Tech::getPaperYear));

        List<String> resultYear = new ArrayList<>();
        for (Tech tech : techByYear) {
            resultYear.add(tech.getPaperYear());
        }
        result.put("years", resultYear);

        Map<String, List<Integer>> skillTotalList = new HashMap<>();
        for (Tech tech : techByYear) {

            List<String> name = new ArrayList<>();
            List<TechTotal> techTotals = tech.getTechTotals();
            for (TechTotal techTotal : techTotals) {
                Long id = techTotal.getId();
                Integer total = techTotal.getTotal();
                String s = skill.get(id);
                name.add(s);
                if (skillTotalList.containsKey(s)) {
                    List<Integer> integers = skillTotalList.get(s);
                    integers.add(total);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(total);
                    skillTotalList.put(s, list);
                }
            }
            Set<Map.Entry<Long, String>> entries = skill.entrySet();
            for (Map.Entry<Long, String> entry : entries) {
                String value = entry.getValue();
                if (!name.contains(value)) {
                    if (skillTotalList.containsKey(value)) {
                        List<Integer> list = skillTotalList.get(value);
                        list.add(0);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(0);
                        skillTotalList.put(value, list);
                    }
                }
            }
        }
        result.put("typeList", skillTotalList);
        return result;
    }

    // 每隔20秒生成一张最新的词云图
    @Scheduled(cron = "0/20 * * * * ?")
    private void cronTask() {
        log.info("开始生成词云图");
        // 生成词云图函数
        getWorldCloud();
        log.info("词云图生成完毕");
    }

    // 生成词云图
    private void getWorldCloud() {
        String url = "C:/Users/10733/Desktop/lunwen/WordCloud_0320/wordCloud";
        List<String> titles = paperInfoMapper.selectAllTitle();
        String lunwen = url + "/doc/lunwen.txt";
        FileUtils.writeLists(lunwen, titles);
        String dict = url + "/userdict/userdict.txt";
        List<String> nameList = vocaMapper.selectAllName();
        FileUtils.writeLists(dict, nameList);

        String executer = "python";
        String file_path = url + "/demo.py"; // python绝对路径
        String[] command_line = new String[] {executer, file_path};
        Process process;
        try {
            process = Runtime.getRuntime().exec(command_line);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            line = in.readLine();
            in.close();
            if (Objects.equals(line, "1")) {
                System.out.println("yes");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Object> getTopTen() {

        List<Map<String, Object>> maps = chartMapper.selectTopTen();

        List<String> techType = new ArrayList<>();
        List<Integer> techNum = new ArrayList<>();

        maps.forEach(map -> {
            techType.add(map.get("techType").toString());
            techNum.add(Integer.parseInt(map.get("techNum").toString()));
        });

        Map<String, Object> map = new HashMap<>();
        map.put("techType", techType);
        map.put("techNum", techNum);
        return map;
    }

    public Map<String, Object> getTuPu() {

        List<Map<String, Object>> maps = chartMapper.selectTypes();

        // id 映射
        Map<Long, Integer> mapping = new HashMap<>();
        int index = 0;
        for (Map<String, Object> map : maps) {
            long id = Long.parseLong(map.get("id").toString());
            mapping.put(id, index++);
        }

//        Map<Long, Map<String, Object>> type = new HashMap<>();
//
        List<Map<String, String>> categories = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            String techType = map.get("techType").toString();
            Map<String, String> a = new HashMap<>();
            a.put("name", techType);
            categories.add(a);
        }

        List<Map<String, Object>> paperIdTitles = chartMapper.selectPaperIdTitle();

        List<Map<String, Object>> nodes = new ArrayList<>();

        int nodeIndex = 0;
        Map<Long, Integer> nodeMapping = new HashMap<>();
        Map<String, Object> node;
        for (Map<String, Object> map : paperIdTitles) {
            long id = Long.parseLong(map.get("id").toString());
            long techId = Long.parseLong(map.get("techId").toString());
            Integer ca = mapping.get(techId);
            String title = map.get("title").toString();

            node = new HashMap<>();
            node.put("name", title);
            node.put("value", id);
            node.put("category", ca);
            nodes.add(node);

            nodeMapping.put(id, nodeIndex++);
        }

        Map<Long, Integer> nodeMapping2 = new HashMap<>();
        for (Map<String, Object> map : maps) {

            node = new HashMap<>();
            node.put("name", map.get("techType"));
            node.put("value", Long.parseLong(map.get("id").toString()) + 2000000);
            node.put("category", mapping.get(Long.parseLong(map.get("id").toString())));
            nodes.add(node);
            nodeMapping2.put(Long.parseLong(map.get("id").toString()) + 2000000, nodeIndex++);
        }

        List<Map<String, Integer>> links = new ArrayList<>();
        for (Map<String, Object> map : paperIdTitles) {
            long id = Long.parseLong(map.get("id").toString());
            long techId = Long.parseLong(map.get("techId").toString());

            Map<String, Integer> link = new HashMap<>();
            link.put("source", nodeMapping2.get(techId + 2000000));
            link.put("target", nodeMapping.get(id));
            links.add(link);
        }


        Map<String, Object> re = new HashMap<>();
        re.put("categories", categories);
        re.put("nodes", nodes);
        re.put("links", links);
        return re;
    }

}
