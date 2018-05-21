package com.yin;

/**
 * Created by easony on 05/21/18.
 */
public interface GPExecutor {
    public <E> E query(String statement, String parameter);
}
