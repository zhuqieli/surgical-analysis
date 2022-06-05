package com.zhuqielinode;

import org.mybatis.spring.annotation.MapperScan;
import org.python.netty.channel.ChannelHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan(basePackages = "com.zhuqielinode.dao")//开启扫描mapper接口的包以及子目录
@SpringBootApplication
public class SurgicalAnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurgicalAnalysisApplication.class, args);
    }

}
