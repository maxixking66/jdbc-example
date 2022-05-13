package com.maktabsharif74.jdbcexample.repository;


import com.maktabsharif74.jdbcexample.domain.User;

import java.sql.*;

public class UserRepository {

    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public User insert(User user) throws SQLException {
        String insertQuery = "insert into user_table(" +
                "first_name, last_name, username, password" +
                ") values (? ,?, ?, ?)";

        PreparedStatement preparedStatement =
                connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.executeUpdate();

        user.setId(getMaxId());

        return user;
    }

    public int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from user_table");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }


}
