package com.yin;

import java.sql.*;

public class simpleExecutor implements GPExecutor {
    @Override
    public <E> E query(String statement, String parameter) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        User user = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gp?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "mysql");
            String sql = String.format(statement, Integer.parseInt(parameter));
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setAge(rs.getInt(3));
                user.setName(rs.getString(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (E) user;
    }
}
