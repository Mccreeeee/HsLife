package com.hnsfdx.hslife;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HslifeApplicationTests {

    @Test
    public void encryptPwd() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", 1);
        map.put("data2", "string");
        System.out.println(map);
    }
}
