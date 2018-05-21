package com.yin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by easony on 05/21/18.
 */
public class MapperProxy<T> implements InvocationHandler {
    private final GPSession gpSession;
    private final Class<T> clazz;

    public MapperProxy(GPSession gpSession, Class<T> clazz) {
        this.gpSession = gpSession;
        this.clazz = clazz;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        MapperRegistor.MapperData mapperData = gpSession.getConfiguration()
                .getMapperRegistor()
                .get(method.getDeclaringClass() + "." +method.getName());
        if (null != mapperData) {
            return gpSession.selectOne(mapperData.getSql(), String.valueOf(args[0]));
        }
        return null;
    }
}
