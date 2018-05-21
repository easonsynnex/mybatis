package com.yin;

public class Entry {
    public static void main(String[] args) {
        GPSession session = new GPSession(new GPConfiguration(),
                new simpleExecutor());
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectByPrimaryKey(1);
        System.out.println(user);
    }
}
