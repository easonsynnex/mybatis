package com.yin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * @Author: eason
 * @Description: MapperProxy生成对应的mapper实例
 * @Date: 20:51 2018/5/19
 */
public class GPMapperProxy implements InvocationHandler {
    private GPSqlSession gpSqlSession;

    public GPMapperProxy(GPSqlSession gpSqlSession) {
        this.gpSqlSession = gpSqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (method.getDeclaringClass().getName().equals(GPConfiguration.UserMapperXML.namespace)){
        String sql = GPConfiguration.UserMapperXML.methodSqlMapping.get(method.getName());
        return gpSqlSession.selectOne(sql, String.valueOf(args[0]));
    }

        return method.invoke(this, args);
    }
}
