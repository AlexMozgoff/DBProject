package main.java.ui.tables;

import main.java.database.DatabaseSelect;
import main.java.database.entities.Dealer;
import main.java.database.entities.TestDrive;
import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dealers")
public class DealerList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Logic.isAuthorized(req)) {
            DatabaseSelect db = new DatabaseSelect();
            List<Dealer> dealers = db.getDealersList();

            req.setAttribute("dealersList", dealers);
            req.getRequestDispatcher("dealers.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("authentication.jsp").forward(req, resp);
        }
    }
}

