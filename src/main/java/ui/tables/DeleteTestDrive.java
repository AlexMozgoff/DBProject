package main.java.ui.tables;

import main.java.database.DatabaseDelete;
import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/deletetestdrive")
public class DeleteTestDrive extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Logic.isAuthorized(req)) {
            String login = (String) req.getSession().getAttribute("login");
            if (Logic.getUserRole(login).equals("admin")) {
                int carId = Integer.parseInt(req.getParameter("carId"));
                String date = req.getParameter("date");
                DatabaseDelete dbDelete = new DatabaseDelete();
                dbDelete.deleteTestDrive(carId, date);

                req.getRequestDispatcher("testdrive").forward(req, resp);
            }
            else {
                resp.sendRedirect("permissionerror.jsp");
            }
        } else {
            req.getRequestDispatcher("authentication.jsp").forward(req, resp);
        }
    }
}
