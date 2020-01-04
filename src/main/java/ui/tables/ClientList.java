package main.java.ui.tables;

import main.java.database.DatabaseSelect;
import main.java.database.entities.Client;
import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/clients")
public class ClientList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Logic.isAuthorized(req)) {
            DatabaseSelect db = new DatabaseSelect();
            List<Client> clients = db.getClientsList();

            req.setAttribute("clientsList", clients);
            req.getRequestDispatcher("clients.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("authentication.jsp").forward(req, resp);
        }
    }
}
