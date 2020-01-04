package main.java.ui.tables;

import main.java.database.DatabaseSelect;
import main.java.database.entities.CarPurchaseAgreement;
import main.java.database.entities.Client;
import main.java.database.entities.Dealer;
import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editdealer")
public class EditDealer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Logic.isAuthorized(req)) {
            String login = (String) req.getSession().getAttribute("login");
            if (Logic.getUserRole(login).equals("admin")) {
                String surname = Logic.replaceSpace(req.getParameter("surname"));
                String name = Logic.replaceSpace(req.getParameter("name"));
                String patronymic = Logic.replaceSpace(req.getParameter("patronymic"));
                String address = Logic.replaceSpace(req.getParameter("address"));
                String phone = Logic.replaceSpace(req.getParameter("phone"));

                DatabaseSelect db = new DatabaseSelect();
                Dealer dealer = new Dealer(surname, name, patronymic, address, phone);
                int dealerId = db.getDealerId(dealer);

                /*DatabaseUpdate dbUpdate = new DatabaseUpdate();
                dbUpdate.updateSellAgreement(agreementId, carSellAgreement);*/

                req.setAttribute("dealerId", dealerId);
                req.setAttribute("surname", surname);
                req.setAttribute("name", name);
                req.setAttribute("patronymic", patronymic);
                req.setAttribute("address", address);
                req.setAttribute("phone", phone);
                req.setAttribute("operation", "dealer");

                req.getRequestDispatcher("editdealer.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("permissionerror.jsp");
            }
        } else {
            req.getRequestDispatcher("authentication.jsp").forward(req, resp);
        }
    }
}
