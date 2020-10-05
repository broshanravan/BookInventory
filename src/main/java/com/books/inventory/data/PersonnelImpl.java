package com.books.inventory.data;

import com.books.inventory.beans.User;
import com.books.inventory.enums.UserRole;

import java.util.HashMap;
import java.util.Map;

public class PersonnelImpl {


    private static Map<Integer, User> systemUsers = new HashMap<Integer,User>();

    public User GetUser(int userId){
        User user = systemUsers.get(userId);
        return user;
    }


    static{

        User Bruce = new User(1, "Bruce", "Roshanravan", "broshanravan", UserRole.Admin);
        User Homer = new User(2, "Homer", "Simpson", "doughnuts", UserRole.opeator);

        systemUsers.put(Bruce.getUserId(),Bruce);
        systemUsers.put(Homer.getUserId(),Homer);

    }
}
