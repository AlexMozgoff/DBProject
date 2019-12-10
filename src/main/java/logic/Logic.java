package main.java.logic;

import main.java.database.Database;

public class Logic {

    public static int getUserId(String login, String role) {
        if (role.equals("admin")) {
            return -1;
        } else if (role.equals("user")) {
            Database db = new Database();
            return db.getUserId(login);
        } else throw new IllegalArgumentException("Wrong user role");
    }

}
