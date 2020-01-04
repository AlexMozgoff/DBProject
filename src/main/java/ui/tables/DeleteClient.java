package main.java.ui.tables;

import main.java.database.DatabaseDelete;
import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteclient")
public class DeleteClient extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Logic.isAuthorized(req)) {
            String login = (String) req.getSession().getAttribute("login");
            if (Logic.getUserRole(login).equals("admin")) {
                String surname = req.getParameter("surname");
                String name = req.getParameter("name");
                DatabaseDelete dbDelete = new DatabaseDelete();
                dbDelete.deleteClient(surname, name);

                req.getRequestDispatcher("clients").forward(req, resp);
            }
            else {
                resp.sendRedirect("permissionerror.jsp");
            }
        } else {
            req.getRequestDispatcher("authentication.jsp").forward(req, resp);
        }
    }
}
