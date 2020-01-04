package main.java.ui.tables;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import main.java.database.DatabaseInsert;
import main.java.database.DatabaseSelect;
import main.java.database.DatabaseUpdate;
import main.java.database.entities.Auto;
import main.java.database.entities.CarSellAgreement;
import main.java.database.entities.Client;
import main.java.logic.Log;
import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/addcarsellagreement")
public class AddCarSellAgreement extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 0;
        int clientId = 0;
        DatabaseSelect dbSelect = new DatabaseSelect();
        List<Client> clients = dbSelect.getAllClients();
        if (Logic.isAuthorized(req)) {
            List<Auto> autos = dbSelect.getAllAutos();

            Map<Integer, String> cars = new HashMap<>();
            for (int i = 0; i < autos.size(); i++) {
                cars.put(autos.get(i).getId(), autos.get(i).getBrand());
            }
            Map<Integer, String> clientMap = new HashMap<>();
            for (int i = 0; i < clients.size(); i++) {
                clientMap.put(clients.get(i).getId(), clients.get(i).getSurname() + " " + clients.get(i).getName() + " " + clients.get(i).getPatronymic());
            }
            String carBrand = req.getParameter("carId");
            String clientName = req.getParameter("clientId");
            for (int i = 0; i < cars.size(); i++) {
                if (cars.values().toArray()[i].equals(carBrand)) {
                    id = (int) cars.keySet().toArray()[i];
                }
            }
            for (int i = 0; i < clientMap.size(); i++) {
                if (clientMap.values().toArray()[i].equals(clientName)) {
                    clientId = (int) clientMap.keySet().toArray()[i];
                }
            }
        }
        boolean isSold = dbSelect.getCarIsSold(id);

        if (!isSold) {
            String date = req.getParameter("date");
            int commission = Integer.parseInt(req.getParameter("commission"));
            String remark = req.getParameter("remark");

            Object[] input = new Object[]{date, commission, remark};
            if (!Logic.isEmpty(input)) {
                if (!Logic.hasRestrictedSymbols(input)) {
                    DatabaseInsert dbInsert = new DatabaseInsert();
                    CarSellAgreement carSellAgreement = new CarSellAgreement(clientId, id, date, commission, remark);
                    dbInsert.insertCarSellAgreement(carSellAgreement);

                    DatabaseUpdate dbUpdate = new DatabaseUpdate();
                    dbUpdate.updateCarSold(id);
                    Log.write(new Date() + ": Car sell agreement added");
                    req.getRequestDispatcher("carsellagreements").forward(req, resp);
                } else {
                    resp.sendRedirect("resrtrictedsymbolserror.jsp");
                }
            } else {
                resp.sendRedirect("emptyfielderror.jsp");
            }
        } else {
            resp.sendRedirect("carsolderror.jsp");
        }
    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
