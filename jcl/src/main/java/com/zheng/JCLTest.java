package com.zheng;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.apache.log4j.BasicConfigurator;
import org.junit.Test;

/**
 * @author: ZhengTianLiang
 * @date: 2022/08/04 22:13
 * @desc: jcl的测试类。
 *      jcl是一个日志框架(接口)，如果你不导入任何的实现的话，默认是jdk14的实现。
 */
public class JCLTest {

    @Test
    public void testQuick(){
        // BasicConfigurator.configure(); 默认的配置。如果不加的话，就会：WARN No appenders could be found for logger (com.zheng.JCLTest).
        // 获取日志记录器对象
        Log log = LogFactory.getLog(JCLTest.class);
        // 日志记录输出
        log.info("test info");


    }
}
