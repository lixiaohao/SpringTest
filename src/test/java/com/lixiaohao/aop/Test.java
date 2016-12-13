package com.lixiaohao.aop;

import com.lixiaohao.aop.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lixiaohao on 2016/12/13
 *
 * @Description
 * @Create 2016-12-13 11:06
 * @Company
 */
public class Test {
    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("/appContext.xml");
        PersonService personService = appContext.getBean(PersonService.class);
        String personName = "Jim";
        personService.addPerson(personName);
        System.out.println("------------------------------------");
        personService.deletePerson(personName);
        System.out.println("------------------------------------");
        personService.editPerson(personName);
        System.out.println("------------------------------------");
        ((ClassPathXmlApplicationContext)appContext).close();
    }
}
