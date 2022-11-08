package com.zheng;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: ZhengTianLiang
 * @date: 2022/08/11 22:51
 * @desc:
 */
public class Slf4jTest {

    private static final Logger logger = LoggerFactory.getLogger(Slf4jTest.class);

    /**
     * @author: ZhengTianLiang
     * @date: 2022/08/11 22:51
     * @desc: slfj的简单入门
     */
    @Test
    public void test1(){
        // 由于slf4j的默认日志级别是info，所以info以下的日志是不会被打印出来的
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");

        // 使用占位符{}来记录日志。
        // todo：如果{}比后面参数的多，那么会打印出来全部的参数，和剩下的{}；如果{}比后面的参数少，那么有几个{}就会打印出来几个参数，后面的参数不打印
        // todo：如果有多个实现的话，会使用前面的实现。比如同时有slf4j-simple-1.7.21.jar、logback-classic-1.2.3.jar 则会使用前面的实现
        String name = "nihjao";
        int age = 18;
        logger.info("用户:{},{},{}",name,age);

        // 将系统的异常信息输出
        try {
            int i = 1/0;
        }catch (Exception e){
//            e.printStackTrace();
            logger.error("系统异常：",e);  // 方法的重载，不用你自己拼接字符串了，直接俩参数，就会打印出来异常的堆栈信息
        }
    }
}
