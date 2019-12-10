package main.java.ui.tables;

import main.java.database.Database;
import main.java.database.objects.CarPurchaseAgreement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/carpurchaseagreements")
public class CarPurchaseAgreementList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database db = new Database();
        int id = (int) req.getSession().getAttribute("id");
        List<CarPurchaseAgreement> carPurchaseAgreementList = db.getCarPurchaseAgreementList(id);

        req.setAttribute("carPurchaseAgreementsList", carPurchaseAgreementList);
        req.getRequestDispatcher("carpurchaseagreements.jsp").forward(req, resp);
    }
}
