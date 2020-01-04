package main.java.ui;

import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mainpage")
public class MainPage extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Logic.isAuthorized(request)) {
            request.getRequestDispatcher("mainpage.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("authentication.jsp").forward(request, response);
        }
    }
}

