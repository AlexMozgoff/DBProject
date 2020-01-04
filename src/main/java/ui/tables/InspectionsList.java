package main.java.ui.tables;

import main.java.database.DatabaseSelect;
import main.java.database.entities.Inspection;
import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/inspection")
public class InspectionsList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Logic.isAuthorized(req)) {
            DatabaseSelect db = new DatabaseSelect();
            List<Inspection> inspections;
            String login = (String) req.getSession().getAttribute("login");
            if (Logic.getUserRole(login).equals("admin")) {
                inspections = db.getAllInspections();
            } else {
                int id = (int) req.getSession().getAttribute("id");
                inspections = db.getInspections(id);
            }
                req.setAttribute("inspections", inspections);
                req.getRequestDispatcher("inspection.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("authentication.jsp").forward(req, resp);
        }
    }
}
