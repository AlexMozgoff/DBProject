package main.java.logic;

import main.java.database.DatabaseSelect;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;

public class Logic {

    public static int getUserId(String login) {
        DatabaseSelect db = new DatabaseSelect();
        return db.getUserId(login);
    }

    public static Date getDate(String date) {
        String[] values = date.split("\\.");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Integer.parseInt(values[0]), ((Integer.parseInt(values[1])) - 1),
                Integer.parseInt(values[2]));
        long millis = calendar.getTimeInMillis();
        java.sql.Date date1 = new Date(millis);
        return date1;
    }

    public static Date getDateFromDate(String date) {
        date = date.replaceAll("'", "");
        String[] values = date.split("-");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Integer.parseInt(values[0]), ((Integer.parseInt(values[1])) - 1),
                Integer.parseInt(values[2]));
        long millis = calendar.getTimeInMillis();
        java.sql.Date date1 = new Date(millis);
        return date1;
    }

    public static String replaceSpace(String parameter) {
        while (parameter.charAt(parameter.length() - 1) == ' ') {
            parameter = parameter.substring(0, parameter.length() - 1);
        }
        return parameter;
    }

    public static String getUserRole(String login) {
        DatabaseSelect db = new DatabaseSelect();
        return db.getUserRole(login);
    }

    public static boolean isAuthorized(HttpServletRequest request) {
        Enumeration<String> attributeNames = request.getSession().getAttributeNames();
        int i = 0;
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            if (name.equals("isAuthorized") || name.equals("login") || name.equals("id")) {
                i++;
            }
        }
        if (i == 3) {
            if (request.getSession().getAttribute("isAuthorized").equals(true)
                    && (request.getSession().getAttribute("login") != null)
                    && (request.getSession().getAttribute("id") != null)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isEmpty(Object[] objects) {
        for (int i = 0; i < objects.length; i++) {
            if ((objects[i].toString()).equals("")) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasRestrictedSymbols(Object[] objects) {
       /* for (int i = 0; i < objects.length; i++) {
            if (!((String) objects[i]).matches("[a-zA-z0-9]")) {
                return true;
            }
        }*/
        return false;
    }
}
