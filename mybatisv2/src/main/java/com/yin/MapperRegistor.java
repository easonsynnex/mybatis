package com.yin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by easony on 05/21/18.
 */
public class MapperRegistor {
    private static final Map<String, MapperData> methodSqlMapping = new HashMap<>();

    public MapperRegistor() {

    }

    public class MapperData<T> {
        private String sql;
        private Class<T> clazz;

        public MapperData(String sql, Class<T> clazz) {
            this.sql = sql;
            this.clazz = clazz;
        }
    }

}
