package database;

import constant.JdbcConnection;
import entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static database.Query.*;

public class Method {

    public void createTable() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JdbcConnection.getConnection();
            if (connection == null) {
                System.out.println("eror");
            }
            preparedStatement = connection.prepareStatement(CREATE_TABLE);
            preparedStatement.executeUpdate();
            System.out.println("created table");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JdbcConnection.closeConnection(connection);
                JdbcConnection.closePreparedStatement(preparedStatement);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void insertUsers(Users users) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JdbcConnection.getConnection();
            if (connection == null) {
                System.out.println("connection is null");
            } else {

                preparedStatement = connection.prepareStatement(INSERTINTO);
                preparedStatement.setInt(1, users.getId());
                preparedStatement.setString(2, users.getFirstName());
                preparedStatement.setString(3, users.getLastName());
                preparedStatement.setInt(4, users.getPassword());
                preparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {

                JdbcConnection.closeConnection(connection);
                JdbcConnection.closePreparedStatement(preparedStatement);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public List<Users> selectAll() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Users> newUsers = new ArrayList<>();

        try {
            connection = JdbcConnection.getConnection();
            if (connection == null) {
                System.out.println("connection is null");
            } else {
                preparedStatement = connection.prepareStatement(SELECTALL);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    Users users1 = new Users();
                    users1.setId(resultSet.getInt("id"));
                    users1.setFirstName(resultSet.getString("firstname"));
                    users1.setLastName(resultSet.getString("lastname"));
                    users1.setPassword(resultSet.getInt("password"));
                    newUsers.add(users1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JdbcConnection.closeConnection(connection);
                JdbcConnection.closePreparedStatement(preparedStatement);
                JdbcConnection.closeResultSet(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return newUsers;
    }


    public Users selectById(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Users users = new Users();

        try {
            connection = JdbcConnection.getConnection();
            if (connection == null) {
                System.out.println("connection is null");
            } else {
                preparedStatement = connection.prepareStatement(SELECTBYID);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    users.setId(resultSet.getInt("id"));
                    users.setFirstName(resultSet.getString("firstname"));
                    users.setLastName(resultSet.getString("lastname"));
                    users.setPassword(resultSet.getInt("password"));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JdbcConnection.closeConnection(connection);
                JdbcConnection.closePreparedStatement(preparedStatement);
                JdbcConnection.closeResultSet(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return users;
    }


    public void deleteAll() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JdbcConnection.getConnection();
            if (connection == null) {
                System.out.println("connection is null");
            } else {
                preparedStatement = connection.prepareStatement(DELETEALL);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JdbcConnection.closeConnection(connection);
                JdbcConnection.closePreparedStatement(preparedStatement);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void deleteById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcConnection.getConnection();
            if (connection == null) {
                System.out.println("connection is null");
            } else {
                preparedStatement = connection.prepareStatement(DELETEBYID);
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JdbcConnection.closeConnection(connection);
                JdbcConnection.closePreparedStatement(preparedStatement);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void updateByPassword(int id, int newPassword) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JdbcConnection.getConnection();
            if (connection == null) {
                System.out.println("connection is null");
            } else {
                preparedStatement = connection.prepareStatement(UPDATEBYPASSWORD);
                preparedStatement.setInt(1, newPassword);
                preparedStatement.setInt(2, id);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JdbcConnection.closeConnection(connection);
                JdbcConnection.closePreparedStatement(preparedStatement);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Users> selectOrderByName() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Users> newUser = new ArrayList<>();

        try {
            connection = JdbcConnection.getConnection();
            if (connection == null) {
                System.out.println("conccection is null");
            } else {
                preparedStatement = connection.prepareStatement(SELECTBYORDERBYNAME);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Users users = new Users();
                    users.setId(resultSet.getInt("id"));
                    users.setFirstName(resultSet.getString("firstname"));
                    users.setLastName(resultSet.getString("lastname"));
                    users.setPassword(resultSet.getInt("password"));
                    newUser.add(users);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JdbcConnection.closeConnection(connection);
                JdbcConnection.closePreparedStatement(preparedStatement);
                JdbcConnection.closeResultSet(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return newUser;
    }
}

