package com.lixiaohao.messageconverter.model;

/**
 * Created by lixiaohao on 2017/1/17
 *
 * @Description
 * @Create 2017-01-17 14:54
 * @Company
 */
public class JsonReturnMessage {
    private String name;
    private String addr;
    private int age;

    public JsonReturnMessage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
