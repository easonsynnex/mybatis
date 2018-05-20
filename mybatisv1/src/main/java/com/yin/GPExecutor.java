package com.yin;

public interface GPExecutor {
    <T> T query(String statement, String paramter);
}
