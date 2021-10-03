package com.example.springboot_log;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootLogApplicationTests {

    // 声明日志记录器对象
    public static final Logger LOGGER = LoggerFactory.getLogger(SpringbootLogApplicationTests.class);

    @Test
    void contextLoads() {
        // 打印日志级别
        LOGGER.error("springboot-error");
        LOGGER.warn("springboot-warn");
        LOGGER.info("springboot-info");//默认级别
        LOGGER.debug("springboot-debug");
        LOGGER.trace("springboot-trace");

        // 使用log4j2 使用桥接器转换为slf4j门面和logback实现
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(SpringbootLogApplicationTests.class);
        logger.error("log4j2-error");

    }

}
