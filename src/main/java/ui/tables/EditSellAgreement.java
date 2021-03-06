package main.java.ui.tables;

import main.java.database.DatabaseDelete;
import main.java.database.DatabaseSelect;
import main.java.database.DatabaseUpdate;
import main.java.database.entities.CarSellAgreement;
import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/editsellagreement")
public class EditSellAgreement extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Logic.isAuthorized(req)) {
            String login = (String) req.getSession().getAttribute("login");
            if (Logic.getUserRole(login).equals("admin")) {
                int clientId = Integer.parseInt(Logic.replaceSpace(req.getParameter("clientId")));
                int carId = Integer.parseInt(Logic.replaceSpace(req.getParameter("carId")));
                String date = Logic.replaceSpace(req.getParameter("date"));
                int commission = Integer.parseInt(Logic.replaceSpace(req.getParameter("commission")));
                String remark = Logic.replaceSpace(req.getParameter("remark"));

                DatabaseSelect db = new DatabaseSelect();
                CarSellAgreement carSellAgreement = new CarSellAgreement(clientId, carId, date, commission, remark);
                int agreementId = db.getSellAgreementId(carSellAgreement);

                /*DatabaseUpdate dbUpdate = new DatabaseUpdate();
                dbUpdate.updateSellAgreement(agreementId, carSellAgreement);*/
                
                req.setAttribute("agreementId", agreementId);
                req.setAttribute("clientId", clientId);
                req.setAttribute("carId", carId);
                req.setAttribute("date", date);
                req.setAttribute("commission", commission);
                req.setAttribute("remark", remark);
                req.setAttribute("operation", "carSellAgreement");

                req.getRequestDispatcher("editcarsellagreement.jsp").forward(req, resp);
            }
            else {
                resp.sendRedirect("permissionerror.jsp");
            }
        } else {
            req.getRequestDispatcher("authentication.jsp").forward(req, resp);
        }
    }
}
