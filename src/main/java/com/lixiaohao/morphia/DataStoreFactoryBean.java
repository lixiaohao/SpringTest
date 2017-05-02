package com.lixiaohao.morphia;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * Created by lixiaohao on 2017/4/28
 *
 * @Description
 * @Create 2017-04-28 15:53
 * @Company
 */
public class DataStoreFactoryBean extends AbstractFactoryBean<Datastore> {

    private Morphia morphia;    	//morphia实例，最好是单例
    private MongoClient mongoClient;    //mongo实例，最好是单例
    private String      dbName;
    //True would force Mongo DB to create Index , not suggest, if index needed, create index
    private boolean toEnsureIndexes=false;
    //True would force Mongo DB to create a Capped Collection, length limited, when full, new replaces the old
    private boolean toEnsureCaps=false;       //是否确认caps存在，默认false
    public Class<?> getObjectType() {
        return Datastore.class;
    }

    protected Datastore createInstance() throws Exception {

        Datastore ds = morphia.createDatastore( mongoClient, dbName );

        if(toEnsureIndexes){
            ds.ensureIndexes();
        }
        if(toEnsureCaps){
            ds.ensureCaps();
        }

        return ds;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        super.afterPropertiesSet();

        if ( mongoClient == null ) {

            throw new IllegalStateException("mongo is not set");
        }
        if ( morphia == null ) {

            throw new IllegalStateException("morphia is not set");
        }
    }

    /*----------------------setters-----------------------*/

    public Morphia getMorphia() {
        return morphia;
    }

    public void setMorphia(Morphia morphia) {
        this.morphia = morphia;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
