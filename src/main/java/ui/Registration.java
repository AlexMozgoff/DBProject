package main.java.ui;

import main.java.database.DatabaseInsert;
import main.java.database.entities.Dealer;
import main.java.database.entities.User;
import main.java.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String patronymic = req.getParameter("patronymic");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeatPassword");

        Object[] input = new Object[] {name, surname, patronymic, login, password, repeatPassword, address, phone};
        if (!Logic.isEmpty(input)) {
            if (!Logic.hasRestrictedSymbols(input)) {

                Dealer dealer = new Dealer(surname, name, patronymic, address, phone, login);
                DatabaseInsert dbInsert = new DatabaseInsert();
                dbInsert.insertDealer(dealer);

                User user = new User(login, password, "user");
                dbInsert.insertUser(user);

                int id = Logic.getUserId(user.getLogin());
                String role = Logic.getUserRole(user.getLogin());

                req.getSession().setAttribute("isAuthorized", true);
                req.getSession().setAttribute("id", id);
                req.getSession().setAttribute("login", login);
                req.getSession().setAttribute("role", role);

                if (Logic.isAuthorized(req)) {
                    req.getRequestDispatcher("mainpage.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher("authentication,jsp").forward(req, resp);
                }
            } else {
                resp.sendRedirect("restrictedsymbolserror.jsp");
            }
        } else {
            resp.sendRedirect("emptyfielderror.jsp");
        }
    }
}
