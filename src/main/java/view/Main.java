package view;

import database.Method;
import entity.Users;

public class Main {
    public static void main(String[] args) {
        Method method = new Method();
        method.createTable();
        method.insertUsers(new Users(1, "mehdi", "arghan", 12345));
        method.insertUsers(new Users(2, "erfan", "navab", 6789));
    }
}
