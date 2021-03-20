package com.ruoyi.project.system.mapper;

import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.project.system.domain.Tech;
import com.ruoyi.project.system.service.impl.SysChartServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SysSkillTypeMapperTest {

    @Resource
    private SysSkillTypeMapper mapper;

    @Resource
    private SysPaperInfoMapper paperInfoMapper;

    @Resource
    private SysChartMapper chartMapper;

    @Resource
    private SysChartServiceImpl chartService;

    @Test
    public void test() {
//        List<Map<String, Object>> maps =
//                paperInfoMapper.queryPaperList(new HashMap<>());
//
//        System.out.println(maps);

//        List<Tech> techByYear = chartMapper.getTechByYear();
//        System.out.println(techByYear);
//        techByYear.sort(Comparator.comparing(Tech::getPaperYear));
//        System.out.println(techByYear);

        Map<String, Object> techByYear = chartService.getTechByYear();
        System.out.println(techByYear);
    }

    public static void main(String[] args) throws IOException, InterruptedException {

//        long start = System.currentTimeMillis();
//        String executer = "python";
//        String file_path = "C:\\Users\\Xinke\\Downloads\\wordCloud\\wordCloud\\demo.py"; // python绝对路径
//        String[] command_line = new String[] {executer, file_path};
//        Process process = Runtime.getRuntime().exec(command_line);
//        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        String line = "";
//        line = in.readLine();
//        in.close();
//        process.waitFor();
//        if (Objects.equals(line, "1")) {
//            System.out.println("yes");
//        }
//        System.out.println(System.currentTimeMillis() - start);

        String lunwen = "C:/Users/Xinke/Downloads/wordCloud/wordCloud/doc/lunwen.txt";

        List<String> list = new ArrayList<>();
        list.add("该法规的规定");
        list.add("而薇热望热望");
        FileUtils.writeLists(lunwen, list);


//        String[] command_line = new String[] {"d:\\", "dir"};
//        Process process = Runtime.getRuntime().exec(command_line);
//        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        String line = "";
//        line = in.readLine();
//        in.close();
//        process.waitFor();
    }
}