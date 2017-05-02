package com.lixiaohao.morphia;

import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * Created by lixiaohao on 2017/4/28
 *
 * @Description
 * @Create 2017-04-28 15:53
 * @Company
 */
public class MorphiaFactoryBean extends AbstractFactoryBean<Morphia> {
    /**
     * The path of packages which Morphia used to scan and mapping
     */
    private String[] mapPackages;

    /**
     * The Classes which Morphia used to scan and mapping
     */
    private String[] mapClasses;
    public Class<?> getObjectType() {
        return Morphia.class;
    }

    protected Morphia createInstance() throws Exception {
        Morphia m = new Morphia();

        if (mapPackages != null) {
            for (String packageName : mapPackages) {
                m.mapPackage(packageName, ignoreInvalidClasses);
            }
        }
        if (mapClasses != null) {
            for (String entityClass : mapClasses) {
                m.map(Class.forName(entityClass));
            }
        }
        return m;
    }



    /**
     * 扫描包时，是否忽略不映射的类
     * 这里按照Morphia的原始定义，默认设为false
     */
    private boolean ignoreInvalidClasses = false;


    public String[] getMapPackages() {
        return mapPackages;
    }

    public void setMapPackages(String[] mapPackages) {
        this.mapPackages = mapPackages;
    }

    public String[] getMapClasses() {
        return mapClasses;
    }

    public void setMapClasses(String[] mapClasses) {
        this.mapClasses = mapClasses;
    }

    public boolean isIgnoreInvalidClasses() {
        return ignoreInvalidClasses;
    }

    public void setIgnoreInvalidClasses(boolean ignoreInvalidClasses) {
        this.ignoreInvalidClasses = ignoreInvalidClasses;
    }
}
