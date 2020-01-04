package main.java.ui.tables;

import main.java.database.DatabaseInsert;
import main.java.database.DatabaseSelect;
import main.java.database.entities.Auto;
import main.java.database.entities.CarPurchaseAgreement;
import main.java.logic.Log;
import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addcarpurchaseagreement")
public class AddCarPurchaseAgreement extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Logic.isAuthorized(req)) {
            String brand = req.getParameter("brand");
            int dateOfRelease = Integer.parseInt(req.getParameter("dateOfRelease"));
            int mileage = Integer.parseInt(req.getParameter("mileage"));
            int price = Integer.parseInt(req.getParameter("price"));
            String date = req.getParameter("date");
            int commission = Integer.parseInt(req.getParameter("commission"));
            String remark = req.getParameter("remark");

            Object[] input = new Object[] {brand, dateOfRelease, mileage, price, date, commission, remark};
            if (!Logic.isEmpty(input)) {
                if (!Logic.hasRestrictedSymbols(input)) {

                    int dealerId = (int) req.getSession().getAttribute("id");

                    Auto auto = new Auto(dealerId, brand, dateOfRelease, mileage, price, false);
                    DatabaseInsert db = new DatabaseInsert();
                    db.insertAuto(auto);
                    DatabaseSelect dbSelect = new DatabaseSelect();
                    int carId = dbSelect.getAutoId(auto);

                    CarPurchaseAgreement carPurchaseAgreement = new CarPurchaseAgreement(carId, date, commission, remark);
                    db.insertCarPurchaseAgreement(carPurchaseAgreement);

                    Log.write(new Date() + ": Car purchase agreement added");
                    req.getRequestDispatcher("carpurchaseagreements").forward(req, resp);
                } else {
                    resp.sendRedirect("restrictedsymbolserror.jsp");
                }
            } else {
                resp.sendRedirect("emptyfielderror");
            }
        } else {
            req.getRequestDispatcher("authentication.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
