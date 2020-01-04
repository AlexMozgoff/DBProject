package main.java.ui.tables;

import main.java.database.DatabaseInsert;
import main.java.database.DatabaseSelect;
import main.java.database.entities.Auto;
import main.java.database.entities.Inspection;
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

@WebServlet("/addinspection")
public class AddInspection extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Logic.isAuthorized(req)) {
            int id = 0;
            DatabaseSelect dbSelect = new DatabaseSelect();
            List<Auto> autos = dbSelect.getAllAutos();
            Map<Integer, String> cars = new HashMap<>();
            for (int i = 0; i < autos.size(); i++) {
                cars.put(autos.get(i).getId(), autos.get(i).getBrand());
            }
            String carBrand = req.getParameter("carId");

            for (int i = 0; i < cars.size(); i++) {
                if (cars.values().toArray()[i].equals(carBrand)) {
                    id = (int) cars.keySet().toArray()[i];
                }
            }

            String date = req.getParameter("date");
            int mileage = Integer.parseInt(req.getParameter("mileage"));
            String equipment = req.getParameter("equipment");
            int seats = Integer.parseInt(req.getParameter("seats"));
            int numberOfOwners = Integer.parseInt(req.getParameter("numberOfOwners"));
            String gearbox = req.getParameter("gearbox");
            float engineVolume = Float.parseFloat(req.getParameter("engineVolume"));
            String vin = req.getParameter("vin");

            Object[] input = new Object[] {id, date, mileage, equipment, seats, numberOfOwners, gearbox, engineVolume, vin};
            if (!Logic.isEmpty(input)) {
                if (!Logic.hasRestrictedSymbols(input)) {

                    Inspection inspection = new Inspection(id, date, mileage, equipment, seats, numberOfOwners, gearbox, engineVolume, vin);
                    DatabaseInsert dbInsert = new DatabaseInsert();
                    dbInsert.insertInspection(inspection);

                    Log.write(new Date() + ": Inspection added");
                    req.getRequestDispatcher("inspection").forward(req, resp);

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
        if (Logic.isAuthorized(req)) {
            int carId = Integer.parseInt(req.getParameter("carId"));
            String date = req.getParameter("date");
            int mileage = Integer.parseInt(req.getParameter("mileage"));
            String equipment = req.getParameter("equipment");
            int seats = Integer.parseInt(req.getParameter("seats"));
            int numberOfOwners = Integer.parseInt(req.getParameter("numberOfOwners"));
            String gearbox = req.getParameter("gearbox");
            float engineVolume = Float.parseFloat(req.getParameter("engineVolume"));
            String vin = req.getParameter("vin");

            Inspection inspection = new Inspection(carId, date, mileage, equipment, seats, numberOfOwners, gearbox, engineVolume, vin);
            DatabaseInsert dbInsert = new DatabaseInsert();
            dbInsert.insertInspection(inspection);

            req.getRequestDispatcher("inspection").forward(req, resp);
        } else {
            req.getRequestDispatcher("authentication.jsp").forward(req, resp);
        }
    }
}
