package com.hnsfdx.hslife;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HslifeApplicationTests {

    @Test
    public void encryptPwd() throws IOException {
        File f = new File("temp/a/123.txt");
        if(!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        f.createNewFile();

        File ff = new File("temp/a/234.txt");
        if(!ff.getParentFile().exists())
            ff.getParentFile().mkdirs();
        ff.createNewFile();

        File fff = new File("temp/b/234.txt");
        if(!fff.getParentFile().exists())
            fff.getParentFile().mkdirs();
        fff.createNewFile();
    }
}
