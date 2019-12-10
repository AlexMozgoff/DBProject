package main.java.ui.tables;

import main.java.database.Database;
import main.java.database.objects.TestDrive;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/testdrive")
public class TestDriveList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database db = new Database();
        int id = (int) req.getSession().getAttribute("id");
        List<TestDrive> testDriveList = db.getTestDriveList(id);

        req.setAttribute("testDriveList", testDriveList);
        req.getRequestDispatcher("testdrive.jsp").forward(req, resp);
    }
}
