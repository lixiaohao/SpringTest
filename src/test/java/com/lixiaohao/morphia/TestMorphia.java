package com.lixiaohao.morphia;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * Created by lixiaohao on 2017/4/28
 *
 * @Description
 * @Create 2017-04-28 13:17
 * @Company
 */
public class TestMorphia {

    @Test
    public void connectMorhpia(){
        ApplicationContext appContext = new ClassPathXmlApplicationContext("/appContext.xml");
        Datastore datastore = appContext.getBean(Datastore.class);
        DB db =datastore.getDB();
        System.out.println( db.getName() );
    }

}
