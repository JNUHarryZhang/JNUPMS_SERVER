package com.ruoyi.framework.config;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DruidConfigTest {

    @Autowired
    private List<DruidDataSource> list;

    @Test
    public void test() {
        System.out.println(list);
    }
}