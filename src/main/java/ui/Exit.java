package main.java.ui;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exit")
public class Exit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("isAuthorized", false);
        req.getSession().setAttribute("id", "");
        req.getSession().setAttribute("login", "");
        req.getSession().setAttribute("role", "");

        req.getRequestDispatcher("authentication.jsp").forward(req, resp);
    }
}
