package main.java.ui.tables;

import main.java.database.DatabaseInsert;
import main.java.database.DatabaseSelect;
import main.java.database.entities.Auto;
import main.java.database.entities.Client;
import main.java.database.entities.TestDrive;
import main.java.logic.Log;
import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/addtestdrive")
public class AddTestDrive extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Logic.isAuthorized(req)) {
            int id = 0;
            int clientId = 0;
            DatabaseSelect dbSelect = new DatabaseSelect();
            List<Auto> autos = dbSelect.getAllAutos();
            List<Client> clients = dbSelect.getClientsList();
            Map<Integer, String> cars = new HashMap<>();
            Map<Integer, String> clientMap = new HashMap<>();
            for (int i = 0; i < autos.size(); i++) {
                cars.put(autos.get(i).getId(), autos.get(i).getBrand());
            }
            for (int i = 0; i < clients.size(); i++) {
                clientMap.put(clients.get(i).getId(), clients.get(i).getSurname() + clients.get(i).getName() + clients.get(i).getPatronymic());
            }
            String clientName = req.getParameter("clientId");
            String carBrand = req.getParameter("carId");

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
            String date = req.getParameter("date");

            Object[] input = new Object[] {id, clientId, date};
            if (!Logic.isEmpty(input)) {
                if (!Logic.hasRestrictedSymbols(input)) {

                    TestDrive testDrive = new TestDrive(id, clientId, date);
                    DatabaseInsert dbInsert = new DatabaseInsert();
                    dbInsert.insertTestdrive(testDrive);

                    Log.write(new Date() + ": Test-drive added");
                    req.getRequestDispatcher("testdrive").forward(req, resp);

                } else {
                    resp.sendRedirect("restrictedsymbolserror.jsp");
                }
            } else {
                resp.sendRedirect("emptyfielderror.jsp");
            }
        } else {
            req.getRequestDispatcher("authentication.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
