package main.java.ui.tables;

import main.java.database.DatabaseSelect;
import main.java.database.entities.CarPurchaseAgreement;
import main.java.database.entities.CarSellAgreement;
import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/carpurchaseagreements")
public class CarPurchaseAgreementList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Logic.isAuthorized(req)) {
            List<CarPurchaseAgreement> agreements = new ArrayList<>();
            DatabaseSelect db = new DatabaseSelect();
            String login = (String) req.getSession().getAttribute("login");
            if (Logic.getUserRole(login).equals("admin")) {
                agreements = db.getAllPurchaseAgreements();
            } else {
                int id = (int) req.getSession().getAttribute("id");
                agreements = db.getCarPurchaseAgreementList(id);
            }

            req.setAttribute("carPurchaseAgreementsList", agreements);
            req.getRequestDispatcher("carpurchaseagreements.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("authentication.jsp").forward(req, resp);
        }
    }
}
