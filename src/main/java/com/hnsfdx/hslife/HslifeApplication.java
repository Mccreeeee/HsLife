package com.hnsfdx.hslife;

import com.hnsfdx.hslife.util.RedisUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.MultipartConfigElement;

@EnableScheduling
@SpringBootApplication
public class HslifeApplication {


    public static void main(String[] args) {
        SpringApplication.run(HslifeApplication.class, args);
    }

    // 更改上传文件相对路径
//    @Bean
//    MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setLocation("temp/images");
//        return factory.createMultipartConfig();
//    }
}
