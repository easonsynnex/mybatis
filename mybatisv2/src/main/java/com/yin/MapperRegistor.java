package com.yin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by easony on 05/21/18.
 */
public class MapperRegistor {
    private static final Map<String, MapperData> methodSqlMapping = new HashMap<>();

    public MapperRegistor() {
        methodSqlMapping.put("com.yin.UserMapper.selectByPrimaryKey",
                new MapperData("SELECT * FROM user where id = %d", User.class));
    }

    public class MapperData<T> {
        private String sql;
        private Class<T> clazz;

        public MapperData(String sql, Class<T> clazz) {
            this.sql = sql;
            this.clazz = clazz;
        }

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }

        public Class<T> getClazz() {
            return clazz;
        }

        public void setClazz(Class<T> clazz) {
            this.clazz = clazz;
        }
    }

    public static MapperData get(String name) {
        return methodSqlMapping.get(name);
    }
}
