package com.yin;

import java.lang.reflect.Proxy;

/**
 * Created by easony on 05/21/18.
 */
public class GPSession {
    private GPConfiguration configuration;
    private GPExecutor executor;

    public GPSession(GPConfiguration configuration, GPExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz) throws IllegalArgumentException{
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MapperProxy(this, clazz));
    }

    public <E> E selectOne(String statement, String parameter) {
        return executor.query(statement, parameter);
    }

    public GPConfiguration getConfiguration() {
        return configuration;
    }
}
