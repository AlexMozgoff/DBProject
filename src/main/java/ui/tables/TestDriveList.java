package main.java.ui.tables;

import main.java.database.DatabaseSelect;
import main.java.database.entities.TestDrive;
import main.java.logic.Logic;
import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/testdrive")
public class TestDriveList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Logic.isAuthorized(req)) {
            DatabaseSelect db = new DatabaseSelect();
            List<TestDrive> testDrives;
            String login = (String) req.getSession().getAttribute("login");
            if (Logic.getUserRole(login).equals("admin")) {
                testDrives = db.getAllTestDrives();
            } else {
                int id = (int) req.getSession().getAttribute("id");
                testDrives = db.getTestDriveList(id);
            }

            req.setAttribute("testDriveList", testDrives);
            req.getRequestDispatcher("testdrive.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("authentication.jsp").forward(req, resp);
        }
    }
}
