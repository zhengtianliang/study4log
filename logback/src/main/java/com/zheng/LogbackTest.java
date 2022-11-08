package com.zheng;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: ZhengTianLiang
 * @date: 2022/08/24 22:44
 * @desc:
 *  todo: logback默认的日志级别是  debug
 */
public class LogbackTest {

    private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void testQuick(){
        for (int i = 0; i < 1000; i++) {
            logger.error("error");
            logger.warn("warn");
            logger.info("info");
            logger.debug("debug");
            logger.trace("trace");
        }

    }
}
