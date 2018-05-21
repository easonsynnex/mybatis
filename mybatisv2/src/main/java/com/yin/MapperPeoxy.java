package com.yin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by easony on 05/21/18.
 */
public class MapperPeoxy implements InvocationHandler {
    GPSession gpSession;

    public <T> MapperPeoxy(GPSession gpSession) {
        this.gpSession = gpSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return null;
    }
}
