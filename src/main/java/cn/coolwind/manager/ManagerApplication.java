package cn.coolwind.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"cn.coolwind.manager.web.mapper","cn.coolwind.manager.web.dao"})
public class ManagerApplication {
    private static Logger log = LoggerFactory.getLogger(ManagerApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
        log.info("##################################系统启动成功!!!");
    }


}
