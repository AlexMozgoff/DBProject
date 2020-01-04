package main.java.ui.tables;

import main.java.database.DatabaseSelect;
import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/agreementscount")
public class AgreementsCount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Logic.isAuthorized(req)) {
            String login = (String) req.getSession().getAttribute("login");
            if (Logic.getUserRole(login).equals("admin")) {
                int dealerId = Integer.parseInt(req.getParameter("dealerId"));
                DatabaseSelect db = new DatabaseSelect();
                int count = db.getAmountOfAgreements(dealerId);

                req.setAttribute("amount", count);
                req.getRequestDispatcher("agreementsamount.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("permissionerror.jsp");
            }
        } else {
            req.getRequestDispatcher("authentication.jsp").forward(req, resp);
        }
    }

}
