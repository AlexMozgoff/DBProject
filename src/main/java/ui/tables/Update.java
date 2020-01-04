package main.java.ui.tables;

import main.java.database.DatabaseUpdate;
import main.java.database.entities.CarPurchaseAgreement;
import main.java.database.entities.CarSellAgreement;
import main.java.database.entities.Client;
import main.java.database.entities.Dealer;
import main.java.logic.Logic;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class Update extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Logic.isAuthorized(req)) {
            String login = (String) req.getSession().getAttribute("login");
            if (Logic.getUserRole(login).equals("admin")) {
                String operation = req.getParameter("operation");

                switch (operation) {
                    case "carSellAgreement": {
                        int agreementId = Integer.parseInt(req.getParameter("agreementId"));
                        int carId = Integer.parseInt(Logic.replaceSpace(req.getParameter("carId")));
                        int clientId = Integer.parseInt(Logic.replaceSpace(req.getParameter("clientId")));
                        String date = Logic.replaceSpace(req.getParameter("date"));
                        int commission = Integer.parseInt(Logic.replaceSpace(req.getParameter("commission")));
                        String remark = req.getParameter("remark");

                        CarSellAgreement agreement = new CarSellAgreement(clientId, carId, date, commission, remark);
                        DatabaseUpdate db = new DatabaseUpdate();
                        db.updateSellAgreement(agreementId, agreement);

                        req.getRequestDispatcher("carsellagreements").forward(req, resp);
                    }

                    case "carPurchaseAgreement": {
                        int agreementId = Integer.parseInt(req.getParameter("agreementId"));
                        int carId = Integer.parseInt(Logic.replaceSpace(req.getParameter("carId")));
                        String brand = Logic.replaceSpace(req.getParameter("brand"));
                        String date = Logic.replaceSpace(req.getParameter("date"));
                        int commission = Integer.parseInt(Logic.replaceSpace(req.getParameter("commission")));
                        String remark = req.getParameter("remark");

                        CarPurchaseAgreement agreement = new CarPurchaseAgreement(carId, brand, date, commission, remark);
                        DatabaseUpdate db = new DatabaseUpdate();
                        db.updatePurchaseAgreement(agreementId, agreement);

                        req.getRequestDispatcher("carpurchaseagreements").forward(req, resp);
                    }

                    case "client": {
                        int clientId = Integer.parseInt(req.getParameter("clientId"));
                        String surname = req.getParameter("surname");
                        String name = req.getParameter("name");
                        String patronymic = req.getParameter("patronymic");
                        String city = req.getParameter("city");
                        String address = req.getParameter("address");
                        String phone = req.getParameter("phone");

                        Client client = new Client(surname, name, patronymic, city, address, phone);
                        DatabaseUpdate db = new DatabaseUpdate();
                        db.updateClient(clientId, client);

                        req.getRequestDispatcher("clients").forward(req, resp);
                    }

                    case "dealer": {
                        int dealerId = Integer.parseInt(req.getParameter("dealerId"));
                        String surname = req.getParameter("surname");
                        String name = req.getParameter("name");
                        String patronymic = req.getParameter("patronymic");
                        String address = req.getParameter("address");
                        String phone = req.getParameter("phone");

                        Dealer dealer = new Dealer(surname, name, patronymic, address, phone);
                        DatabaseUpdate db = new DatabaseUpdate();
                        db.updateDealer(dealerId, dealer);

                        req.getRequestDispatcher("dealers").forward(req, resp);
                    }
                }

            }
        }
    }
}
