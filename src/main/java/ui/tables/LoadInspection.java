package main.java.ui.tables;

import main.java.database.DatabaseSelect;
import main.java.database.entities.Auto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/loadinspection")
public class LoadInspection extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseSelect db = new DatabaseSelect();
        List<Auto> autos = db.getAllAutos();
        Map<Integer, String> cars = new HashMap<>();
        for (int i = 0; i < autos.size(); i++) {
            if (autos.get(i).isSold() == false) {
                cars.put(autos.get(i).getId(), autos.get(i).getBrand());
            }
        }

        req.setAttribute("cars", cars);
        req.getRequestDispatcher("addinspection.jsp").forward(req, resp);
    }
}
