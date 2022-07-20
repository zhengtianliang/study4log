package com.zheng;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author: ZhengTianLiang
 * @date: 2022/07/20 22:54
 * @desc: 测试log4j
 *  todo：log4j的默认级别是 debug (debug以下的日志级别，默认不会打印)
 */
public class Log4jTest {

    /**
     * @author: ZhengTianLiang
     * @date: 2022/07/20 22:54
     * @desc: log4j的快速入门
     */
    @Test
    public void testQuick(){

        // 初始化配置信息，在入门案例中暂不使用配置文件
        BasicConfigurator.configure();

        /*
            如果不加上面的 BasicConfigurator.configure();  则会报错：
                log4j:WARN No appenders could be found for logger (com.zheng.Log4jTest).
                log4j:WARN Please initialize the log4j system properly.
                log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
         */
        // 获取日志记录器对象
        Logger logger = Logger.getLogger(Log4jTest.class);
        // 日志记录输出
        logger.info("hello log4j");

        // 日志的级别
        logger.fatal("fatal"); // 严重错误，一般会造成系统崩溃并终止运行
        logger.error("error"); // 错误信息，不会影响系统运行
        logger.warn("warn"); // 错误信息，可能会发生问题
        logger.info("info"); // 运行信息，数据链接、网络链接、io参数等
        logger.debug("debug"); // 调试信息，记录程序变量，参数传递信息等等
        logger.trace("trace"); // 追踪信息，记录程序所有的流程信息
    }
}
