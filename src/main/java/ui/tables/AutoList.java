package main.java.ui.tables;

import main.java.database.DatabaseSelect;
import main.java.database.entities.Auto;
import main.java.database.entities.CarPurchaseAgreement;
import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/dealersAuto")
public class AutoList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Logic.isAuthorized(req)) {
            List<Auto> autos = new ArrayList<>();
            DatabaseSelect db = new DatabaseSelect();
            String login = (String) req.getSession().getAttribute("login");
            if (Logic.getUserRole(login).equals("admin")) {
                autos = db.getAllAutos();
            } else {
                int id = (int) req.getSession().getAttribute("id");
                autos = db.getDealersAuto(id);
            }

            req.setAttribute("autoList", autos);
            req.getRequestDispatcher("dealersauto.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("authentication.jsp").forward(req, resp);
        }
    }
}
