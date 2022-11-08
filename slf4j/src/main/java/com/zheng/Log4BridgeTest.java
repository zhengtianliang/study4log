package com.zheng;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author: ZhengTianLiang
 * @date: 2022/08/22 22:16
 * @desc: slf4j对于桥接器的测试demo
 */
public class Log4BridgeTest {

    private static final Logger logger = Logger.getLogger(Log4BridgeTest.class);

    @Test
    public void test1(){
        logger.info("hello word");
    }
}
