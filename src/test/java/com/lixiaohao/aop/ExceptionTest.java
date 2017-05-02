package com.lixiaohao.aop;

import com.lixiaohao.aop.service.ExceptionService;
import com.lixiaohao.aop.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lixiaohao on 2017/4/28
 *
 * @Description
 * @Create 2017-04-28 11:30
 * @Company
 */
public class ExceptionTest {
    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("/appContext.xml");
        ExceptionService exceptionService = appContext.getBean(ExceptionService.class);
        exceptionService.exception("12l");
        ((ClassPathXmlApplicationContext)appContext).close();
    }
}
