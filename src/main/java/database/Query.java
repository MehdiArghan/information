package database;

public class Query {
    public static final String CREATE_TABLE = "create table users" +
            "(id int ," +
            "firstname varchar(50)," +
            "lastname varchar(50)," +
            "password int)";

    public static final String DROP_TABLE = "drop table users";
    public static final String INSERTINTO = "insert into users values (?,?,?,?)";
    public static final String SELECTALL = "select * from users";
    public static final String SELECTBYID = "select * from users where id = ?";
    public static final String DELETEALL = "truncate table users";

    public static final String DELETEBYID = "delete from users where id=?";
    public static final String UPDATEBYPASSWORD = "update users set password=? where id=?";
}
