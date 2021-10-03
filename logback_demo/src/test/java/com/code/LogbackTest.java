package com.code;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void test01() {
        for (int i = 0; i < 10000; i++) {
            LOGGER.error("error-logback");
            LOGGER.warn("warn-logback");
            LOGGER.info("info-logback");
            LOGGER.debug("debug-logback");//默认级别
            LOGGER.trace("trace-logback");
        }

    }
}
