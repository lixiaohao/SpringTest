package com.lixiaohao.aop.service;

import org.springframework.stereotype.Service;

/**
 * Created by lixiaohao on 2016/12/13
 *
 * @Description
 * @Create 2016-12-13 11:01
 * @Company
 */
@Service
public class PersonService {
    public void addPerson(String personName) {
        System.out.println("add person " + personName);
    }

    public boolean deletePerson(String personName) {
        System.out.println("delete person " + personName) ;
        return true;
    }

    public void editPerson(String personName) {
        System.out.println("edit person " + personName);
        throw new RuntimeException("edit person throw exception");
    }
}
