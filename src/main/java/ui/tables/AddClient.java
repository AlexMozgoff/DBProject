package main.java.ui.tables;

import main.java.database.DatabaseInsert;
import main.java.database.entities.Client;
import main.java.logic.Log;
import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

@WebServlet("/addclient")
public class AddClient extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Logic.isAuthorized(req)) {
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            String patronymic = req.getParameter("patronymic");
            String city = req.getParameter("city");
            String address = req.getParameter("address");
            String phone = req.getParameter("phone");
            Client client = new Client(surname, name, patronymic, city, address, phone);

            Object[] input = new Object[] {name, surname, patronymic, city, address, phone};
            if (!Logic.isEmpty(input)) {
                if (!Logic.hasRestrictedSymbols(input)) {
                    DatabaseInsert db = new DatabaseInsert();
                    db.insertClient(client);

                    Log.write(new Date() + ": Client added: " + surname + " " + name);
                    req.getRequestDispatcher("clients").forward(req, resp);
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
        super.doGet(req, resp);
    }
}
