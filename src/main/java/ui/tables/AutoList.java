package main.java.ui.tables;

import main.java.database.Database;
import main.java.database.objects.Auto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dealersAuto")
public class AutoList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database db = new Database();
        int id = (int) req.getSession().getAttribute("id");
        List<Auto> dealersAuto = db.getDealersAuto(id);

        req.setAttribute("autoList", dealersAuto);
        req.getRequestDispatcher("dealersauto.jsp").forward(req, resp);
    }
}
