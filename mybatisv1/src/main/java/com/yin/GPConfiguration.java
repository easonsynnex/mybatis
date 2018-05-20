package com.yin;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class GPConfiguration {
    public <T> T getMapper(Class<T> clazz, GPSqlSession gpSqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new GPMapperProxy(gpSqlSession));
    }

    static class UserMapperXML {
        public static final String namespace = "com.yin.UserMapper";
        public static Map<String, String> methodSqlMapping = new HashMap<>(1);

        static{
            methodSqlMapping.put("selectByPrimaryKey", "select * from user where id = %d");
        }
    }
}
