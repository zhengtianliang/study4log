package com.zheng;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.*;

/**
 * @author: ZhengTianLiang
 * @date: 2022/07/13 22:54
 * @desc: 测试 jul (Java util Logging ) 是jdk自带的，不需要额外的导包
 *      1、获取日志记录对象
 *      Logger logger = Logger.getLogger("com.zheng.log.JULTest");   java.util.logging.Logger
 *      2、日志记录输出
 *      logger.warning("warning的输出");
 *      logger.log(Level.INFO,"通用日志"); // 信息: 通用日志
 *      logger.log(Level.SEVERE,"用户信息1:{0},{1}",new Object[]{name,age}); // 严重: 用户信息1:nihao,18
 *
 */
public class JULTest {

    public static void main(String[] args) {
        // simpleLog(); // 测试 jul (Java util Logging ) 的入门学习案例
        // testLogLevel(); // 测试 jul (Java util Logging ) 的级别
        // customLogLevel(); // 测试 jul (Java util Logging ) 的自定义日志级别
         testParentLog(); // 测试log的父子关系
//        testCustomConfiguration(); // 测试jul的自定义配置文件
    }

    /**
     * @author: ZhengTianLiang
     * @date: 2022/07/14 22:54
     * @desc: 测试 jul (Java util Logging ) 的入门学习案例
     */
    public static void simpleLog(){
        // 1、获取日志记录对象
        Logger logger = Logger.getLogger("com.zheng.log.JULTest");
        // 2、日志记录输出
        logger.info("info的输出"); // 信息: info的输出
        logger.warning("warning的输出"); // 警告: warning的输出

        // 通用方法记录日志
        logger.log(Level.INFO,"通用日志"); // 信息: 通用日志

        // 通过占位符来记录日志
        String name = "nihao";
        Integer age = 18;
        logger.log(Level.SEVERE,"用户信息1:{0},{1}",new Object[]{name,age}); // 严重: 用户信息1:nihao,18
        logger.log(Level.SEVERE,"用户信息2:{0}，{1}",new Object[]{name,age}); // 严重: 用户信息2:nihao，18
        logger.log(Level.SEVERE,"用户信息3:{0}，{1}", Arrays.asList(name,age)); // 严重: 用户信息3:[nihao, 18]，{1}
    }

    /**
     * @author: ZhengTianLiang
     * @date: 2022/07/14 22:54
     * @desc: 测试 jul (Java util Logging ) 的级别
     *      todo: 默认只会打印出来  sever、warning、info  这三日志
     */
    public static void testLogLevel(){
        // 1、获取日志对象
        Logger logger = Logger.getLogger("com.zheng.log.JULTest");
        // 2、日志记录输出
        logger.severe("sever");
        logger.warning("warning");
        logger.info("info");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    /**
     * @author: ZhengTianLiang
     * @date: 2022/07/13 23:00
     * @desc: 测试 jul (Java util Logging ) 的自定义日志级别
     */
    public static void customLogLevel(){
        // 1、获取日志对象
        Logger logger = Logger.getLogger("com.zheng.log.JULTest");

        // 关闭系统的默认配置
        logger.setUseParentHandlers(false); // 关闭掉默认的配置
        // 自定义配置日志的级别
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // 创建简单的格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        // 进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);
        // 配置日志的级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL); // 这行代表着，你的控制台打印的日志的级别

        // 上面的是打印到控制台的，这个是将日志转储进文件内的
        try {
            FileHandler fileHandler = new FileHandler("D:\\jul.log"); // 会在d盘下的 jul.log 文件中记录下日志
            fileHandler.setFormatter(simpleFormatter);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2、日志记录输出
        logger.severe("sever"); // 严重: sever
        logger.warning("warning"); // 警告: warning
        logger.info("info"); // 信息: info
        logger.fine("fine"); // 详细: fine
        logger.finer("finer"); // 较详细: finer
        logger.finest("finest"); // 非常详细: finest
    }

    /**
     * @author: ZhengTianLiang
     * @date: 2022/07/16 23:30
     * @desc: 测试 jul (Java util Logging ) 的父子关系
     *      对于下面的代码来说， Logger2 是logger1的父类 ; 设置了Logger2的日志级别，Logger1也会继承Logger2的级别
     *      他们的最顶级父类是：
     *          java.util.logging.LogManager$RootLogger   (默认的名字是空，logger2.getParent().getName())
     */
    public static void testParentLog(){
        Logger logger1 = Logger.getLogger("com.zheng");
        Logger logger2 = Logger.getLogger("com");

        System.out.println(logger1); // java.util.logging.Logger@591f989e
        System.out.println(logger2); // java.util.logging.Logger@66048bfd
        System.out.println(logger1 == logger2); // false
        System.out.println(logger1.equals(logger2)); // false
        System.out.println(logger1.getParent() == logger2); // true
        System.out.println(logger1.getParent().equals(logger2)); // true
        System.out.println("logger2 is = "+logger2+"; logger2 parent is ="+logger2.getParent()+" name is = "+logger2.getParent().getName());

        System.out.println("=====================");

        // 如果不给logger2加默认的级别的话，默认logger1是只展示了info以上的信息，如果给logger2配置的话，logger1继承了logger2的级别，就会打印对应的日志
        logger2.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        consoleHandler.setFormatter(simpleFormatter);
        logger2.addHandler(consoleHandler);
        logger2.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);


        // 2、日志记录输出
        logger1.severe("sever"); // 严重: sever
        logger1.warning("warning"); // 警告: warning
        logger1.info("info"); // 信息: info
        logger1.fine("fine"); // 详细: fine
        logger1.finer("finer"); // 较详细: finer
        logger1.finest("finest"); // 非常详细: finest
    }

    /**
     * @author: ZhengTianLiang
     * @date: 2022/07/18 22:01
     * @desc: 测试 jul (Java util Logging ) 的自定义配置文件
     *         todo： 如果你自己定义了 LogManager ，就会用你的 LogManager。如果你没有，就会用jdk自带的 LogManager
     */
    public static void testCustomConfiguration(){
        // 读取配置文件，通过类加载期
        InputStream resourceAsStream = JULTest.class.getClassLoader().getResourceAsStream("logging.properties");
        // 创建 LogManager
        LogManager logManager = LogManager.getLogManager();
        try {
            // 通过 LogManager 加载配置文件
            logManager.readConfiguration(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger logger1 = Logger.getLogger("com.zheng");

        logger1.severe("sever"); // 严重: sever
        logger1.warning("warning"); // 警告: warning
        logger1.info("info"); // 信息: info
        logger1.fine("fine"); // 详细: fine
        logger1.finer("finer"); // 较详细: finer
        logger1.finest("finest"); // 非常详细: finest

        Logger logger2 = Logger.getLogger("test"); // 并没有遵循自定义的com。zheng 那就会用默认的 rootLogger

        logger2.severe("sever zheng"); // 严重: sever
        logger2.warning("warning zheng"); // 警告: warning
        logger2.info("info zheng"); // 信息: info
        logger2.fine("fine zheng"); // 详细: fine
        logger2.finer("finer zheng"); // 较详细: finer
        logger2.finest("finest zheng"); // 非常详细: finest

        Logger logger3 = Logger.getLogger("com.zheng"); // 并没有遵循自定义的com。zheng 那就会用默认的 rootLogger

        logger3.severe("sever zheng3"); // 严重: sever
        logger3.warning("warning zheng3"); // 警告: warning
        logger3.info("info zheng3"); // 信息: info
        logger3.fine("fine zheng3"); // 详细: fine
        logger3.finer("finer zheng3"); // 较详细: finer
        logger3.finest("finest zheng3"); // 非常详细: finest
    }

}
