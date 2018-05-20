package com.yin;

public class GPSqlSession {
    private GPConfiguration gpConfiguration;
    private GPExecutor executor;

    public GPSqlSession(GPConfiguration gpConfiguration, GPExecutor executor) {
        this.gpConfiguration = gpConfiguration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz){
        return gpConfiguration.getMapper(clazz, this);
    }
    /**
     * @Author: eason
     * @Description: 
     * @Date: 16:04 2018/5/19
     */
    public <T> T selectOne(String statement, String paramter) {

        return executor.query(statement, paramter);
    }
}
