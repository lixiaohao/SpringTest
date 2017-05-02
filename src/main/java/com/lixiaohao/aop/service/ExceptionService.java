package com.lixiaohao.aop.service;

import org.springframework.stereotype.Service;

/**
 * Created by lixiaohao on 2017/4/28
 *
 * @Description
 * @Create 2017-04-28 11:28
 * @Company
 */
@Service
public class ExceptionService {
    public void exception(String args){
        Integer value = Integer.parseInt(args);
        System.out.println(value);
    }
}
