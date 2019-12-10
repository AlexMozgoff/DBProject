package main.java.ui;

import main.java.database.Database;
import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authentication")
public class Authentication extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Database database = new Database();
        String passwordFromDB = database.getUserPassword(login);
        String role = database.getUserRole(login);
        int id = Logic.getUserId(login, role);

        if (password.equals(passwordFromDB) && !(role == null) && !(id == 0)) {
            request.getSession().setAttribute("isAuthorized", true);
            request.getSession().setAttribute("id", id);
            request.getSession().setAttribute("login", login);
            request.getSession().setAttribute("role", role);
            request.getRequestDispatcher("mainpage").forward(request, response);
        } else {
            //FIXME(отправить сообщение о неверном логине или пароле)
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
