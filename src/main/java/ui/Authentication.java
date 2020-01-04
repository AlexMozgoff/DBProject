package main.java.ui;

import main.java.database.DatabaseSelect;
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

        Object[] input = new Object[]{login, password};
        if (!Logic.isEmpty(input)) {
            if (!Logic.hasRestrictedSymbols(input)) {

                DatabaseSelect database = new DatabaseSelect();
                String passwordFromDB = database.getUserPassword(login);
                String role = database.getUserRole(login);

                if (password.equals(passwordFromDB)) {
                    int id;
                    if (role.equals("admin")) {
                        id = -1;
                    } else {
                        id = Logic.getUserId(login);
                    }

                    if (!(role == null) && !(id == 0)) {
                        request.getSession().setAttribute("isAuthorized", true);
                        request.getSession().setAttribute("id", id);
                        request.getSession().setAttribute("login", login);
                        request.getSession().setAttribute("role", role);
                        request.getRequestDispatcher("mainpage").forward(request, response);
                    } else {
                        response.sendRedirect("something");
                    }
                } else {
                    response.sendRedirect("passworderror.jsp");
                }
            } else {
                response.sendRedirect("restrictedsymbolserror.jsp");
            }
        } else {
            response.sendRedirect("emptyfielderror.jsp");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
