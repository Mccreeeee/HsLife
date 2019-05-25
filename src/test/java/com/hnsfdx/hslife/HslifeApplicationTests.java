package com.hnsfdx.hslife;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class HslifeApplicationTests {
    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    void contextLoads() {
    }
    @Test
    public void encryptPwd() {
        String password="root";//要加密的密码
        String result = stringEncryptor.encrypt(password);
        //打印结果
        System.out.println(result);
    }
}
