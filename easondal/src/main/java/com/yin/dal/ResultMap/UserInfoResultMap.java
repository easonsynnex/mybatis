package com.yin.dal.ResultMap;

import com.yin.dal.dao.Class;
import lombok.Data;

@Data
public class UserInfoResultMap {
    private Integer id;
    private String name;
    private Class aclass;

    @Override
    public String toString() {
        return "UserInfoResultMap{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", aclass=" + aclass +
                '}';
    }
}
