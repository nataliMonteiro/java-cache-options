package org.example.service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DataStoreService {

    public DataStoreService(@Qualifier("clientInstance") HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    private final HazelcastInstance hazelcastInstance;

    @PostConstruct
    void testHazel(){
        System.out.println("Setting info");
        setData("test1","Hi!");
        setData("test2","All good!");

        System.out.println("Getting info");
        System.out.println(getData("test1"));
        System.out.println(getData("test2"));
    }


    public String getData(String key) {
        IMap<String, String> map = hazelcastInstance.getMap("data-map");
        return map.get(key);
    }

    public void setData(String key, String value) {
        IMap<String, String> map = hazelcastInstance.getMap("data-map");
        map.put(key, value);
    }
}