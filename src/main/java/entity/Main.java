package entity;

import database.Metod;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
       /* Users users = new Users(2, "sorosh", "hichkas", 20);
        Metod metod = new Metod();
        //metod.insertUsers(users);
        List<Users> userList = metod.selectAll();
        for (Users user : userList) {
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }
        System.out.println("-------------------------------");
        System.out.println(metod.selectById(1).getFirstName() + " " + metod.selectById(1).getLastName());*/
        Metod metod=new Metod();
        //metod.deleteAll();
       // metod.deleteById(2);
        metod.updateByPassword(1,25);
    }
}
