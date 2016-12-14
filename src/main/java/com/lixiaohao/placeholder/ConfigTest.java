package com.lixiaohao.placeholder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lixiaohao on 2016/12/14
 *
 * @Description
 * @Create 2016-12-14 18:59
 * @Company
 */

public class ConfigTest {

    @Value("${id}")
    private int id;
    @Value("${name}")
    private String name;

    public ConfigTest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
