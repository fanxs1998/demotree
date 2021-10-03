package com.code;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

public class JULTest {


    // 快速入门
    @Test
    public void testQuick() {
        // 1.获取日志记录器对象
        Logger logger = Logger.getLogger("JULTest");
        // 2.日志记录输出
        logger.info("jul-info");

        // 通用方法进行日志记录
        logger.log(Level.INFO, "jul log info");

        // 通过占位符 方式输出变量值
        String name = logger.getName();
        Integer age = 18;
        logger.log(Level.INFO, "loggerName:{0},{1}", new Object[]{name, age});

    }
    // 日志级别
    @Test
    public void TestLogLevel() {
        // 1.获取日志记录器对象
        Logger logger = Logger.getLogger("com.code.JULTest");
        // 2.日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info"); // jul默认日志的日志级别
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }


    // 自定义日志级别
    @Test
    public void testLogConfig() throws IOException {
        // 获取日志对象
        Logger logger = Logger.getLogger("com.code.JULTest");
        // 关闭系统默认配置
        logger.setUseParentHandlers( false );

        // 自定义配置日志级别
        // 创建ConsolHhandler
        ConsoleHandler consoleHandler = new ConsoleHandler();

        //创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        //进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler( consoleHandler );

        //设置日志的具体级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel( Level.ALL );

        //设置文件场景输出
        String rootPath = System.getProperty("user.dir");//当前项目根路径
        FileHandler fileHandler = new FileHandler(rootPath +"\\src\\test\\resources\\logs\\jul.log");
        //进行关联
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);

        //打印输出
        logger.severe("severe"); //严重
        logger.warning("warning"); //警告
        logger.info("info"); //默认信息
        logger.config("cofnig"); //配置
        logger.fine("fine"); //详细
        logger.finer("finer"); //比较详细
        logger.finest("finest"); //非常详细
    }

    // Logger对象父子关系
    @Test
    public void  testLogParent() {
        Logger logger1 = Logger.getLogger("com.code");
        Logger logger2 = Logger.getLogger("com");

        // 测试
        System.out.println(logger1.getParent() == logger2);//true
        // 所有日志记录器的顶级父元素:LogManager$RootLogger
        // name : ""
        System.out.println("logger2 Parent:" + logger2.getParent() + ", name:" + logger2.getParent().getName());
    }

    // 加载自定义配置文件
    @Test
    public void testLogProperties() throws IOException {
        // 读取配置文件，通过类加载器
        InputStream inputStream = JULTest.class.getClassLoader().getResourceAsStream("logging.properties");
        // 创建LogManager
        LogManager logManager = LogManager.getLogManager();
        // 通过LogManager加载配置文件
        logManager.readConfiguration(inputStream);

        // 1.获取日志记录器对象
        Logger logger = Logger.getLogger("com.code.JULTest");
        // 2.日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info"); // jul默认日志的日志级别
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

}
