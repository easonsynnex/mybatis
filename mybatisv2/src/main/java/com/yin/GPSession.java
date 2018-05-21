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

    public <T> T getMapper(Class<T> clazz){
        return Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz},
                new MapperPeoxy(this));
    }

    public <E> E selectOne() {
        return executor.query();
    }

}
