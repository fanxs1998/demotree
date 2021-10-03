package com.code;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Log4j2Test {

    // 定义日志记录器对象
    public static final Logger LOGGER = LogManager.getLogger(Log4j2Test.class);

    // 快速入门
    @Test
    public void testQuick() {

        // 日志消息输出
        LOGGER.fatal("log4j2-fatal");
        LOGGER.error("log4j2-error");//默认级别
        LOGGER.warn("log4j2-warn");
        LOGGER.info("log4j2-info");
        LOGGER.debug("log4j2-debug");
        LOGGER.trace("log4j2-trace");

    }
}
