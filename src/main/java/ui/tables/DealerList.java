package main.java.ui.tables;

import main.java.database.Database;
import main.java.database.objects.Dealer;

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
        Database db = new Database();
        List<Dealer> dealers = db.getDealersList();

        req.setAttribute("dealersList", dealers);
        req.getRequestDispatcher("dealers.jsp").forward(req, resp);
    }
}

