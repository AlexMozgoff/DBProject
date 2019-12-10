package main.java.ui.tables;

import main.java.database.Database;
import main.java.database.objects.Client;

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
        Database db = new Database();
        List<Client> clients = db.getClientsList();

        req.setAttribute("clientsList", clients);
        req.getRequestDispatcher("clients.jsp").forward(req, resp);
    }
}
