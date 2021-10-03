package com.code;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

public class Log4jTest {

    // 快速入门
    @Test
    public void testQuick() {

        // 开启 log4j 内置日志记录
        LogLog.setInternalDebugging(true);

        //初始化配置信息，暂不使用配置文件
//        BasicConfigurator.configure();

        // 1.获取日志记录器对象
        Logger logger = Logger.getLogger(Log4jTest.class);

        // 日志级别
        logger.fatal("fatal");//严重错误，一般会造成系统严重奔溃并且终止运行

        logger.error("error");//错误信息，不会影响系统运行
        logger.warn("warn");//警告信息，可能会发生问题
        logger.info("info");//运行信息，数据库连接、网络连接、IO，操作等
        logger.debug("debug");//调试信息

        logger.trace("trace");//追踪信息，记录程序的流程信息

//        for (int i = 0; i < 1000; i++) {
//            // 日志级别
//            logger.fatal("fatal");//严重错误，一般会造成系统严重奔溃并且终止运行
//
//            logger.error("error");//错误信息，不会影响系统运行
//            logger.warn("warn");//警告信息，可能会发生问题
//            logger.info("info");//运行信息，数据库连接、网络连接、IO，操作等
//            logger.debug("debug");//调试信息
//
//            logger.trace("trace");//追踪信息，记录程序的流程信息
//        }

    }
}
