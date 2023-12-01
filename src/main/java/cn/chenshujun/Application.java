package cn.chenshujun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 主入口类
 *
 * @author XiaoChenClassmates
 * @version 1.0.0 2023/11/16
 */
@EnableCaching
@SpringBootApplication
@MapperScan("cn.chenshujun.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
