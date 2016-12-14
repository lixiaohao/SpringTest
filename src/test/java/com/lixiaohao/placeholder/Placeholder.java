package com.lixiaohao.placeholder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lixiaohao on 2016/12/14
 *
 * @Description
 * @Create 2016-12-14 19:06
 * @Company
 */
public class Placeholder {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/appContext.xml");
        ConfigTest configTest = (ConfigTest)context.getBean(ConfigTest.class);
        System.out.println("id:"+configTest.getId()+"   name:"+configTest.getName());
    }
}
