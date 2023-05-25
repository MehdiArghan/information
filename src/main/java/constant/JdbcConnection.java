package constant;

import java.sql.*;

import static constant.JdbcConstant.*;

public class JdbcConnection {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        return connection;
    }

    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }

}
