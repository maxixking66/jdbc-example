package com.maktabsharif74.jdbcexample.repository;


import com.maktabsharif74.jdbcexample.domain.Article;
import com.maktabsharif74.jdbcexample.domain.User;

import java.sql.*;

public class ArticleRepository {

    private Connection connection;

    public ArticleRepository(Connection connection) {
        this.connection = connection;
    }

    public Article[] getAllByWriterId(int writerId) throws SQLException {
        int countAll = countAllByWriterId(writerId);
        if (countAll > 0) {

            Article[] articles = new Article[countAll];
            int emptyIndex = 0;

            String query =
                    "select * from article as a join user_table as u " +
                            "on a.writer_id = u.id " +
                            "where writer_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, writerId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                articles[emptyIndex] =
                        new Article(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                new User(
                                        resultSet.getInt(5),
                                        resultSet.getString(6),
                                        resultSet.getString(7),
                                        resultSet.getString(8),
                                        resultSet.getString(9)
                                )
                        );
                emptyIndex++;
            }
            return articles;
        } else {
            return new Article[0];
        }

    }

    public int countAllByWriterId(int writerId) throws SQLException {
        String query = "select count(*) from article where writer_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, writerId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public Article insert(Article article) throws SQLException {
        String query = "insert into article(" +
                "title, content, writer_id" +
                ") values (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, article.getTitle());
        preparedStatement.setString(2, article.getContent());
        preparedStatement.setInt(3, article.getWriter().getId());
        preparedStatement.executeUpdate();
        article.setId(getMaxId());
        return article;
    }

    public int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from article");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

}
