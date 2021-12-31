package controller;

import model.HocVien;
import service.ClassRoomService;
import service.HocVienService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    HocVienService hocVienService = new HocVienService();
    ClassRoomService classRoomService = new ClassRoomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }
        RequestDispatcher requestDispatcher;
        switch (action) {
            case "create":
                req.setAttribute("listClass", classRoomService.getAll());
                requestDispatcher = req.getRequestDispatcher("/view/createHocVien.jsp");
                requestDispatcher.forward(req, resp);
                break;
            default:
                req.setAttribute("listHV", hocVienService.getAll());
                requestDispatcher = req.getRequestDispatcher("/view/showHocVien.jsp");
                requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }

        RequestDispatcher requestDispatcher;

        switch (action) {
            case "create":
                String name = req.getParameter("name");
                String address = req.getParameter("address");
                Date date = Date.valueOf(req.getParameter("date"));
                String phone = req.getParameter("phone");
                String email = req.getParameter("email");
                int idClassRoom = Integer.parseInt(req.getParameter("idClassRoom"));

                hocVienService.save(new HocVien(name, address, date, phone, email, idClassRoom));
                resp.sendRedirect("/home");
                break;

            case "search":
                String nameSearch = req.getParameter("search");
                req.setAttribute("listHV", hocVienService.findByName(nameSearch));
                requestDispatcher = req.getRequestDispatcher("/view/showHocVien.jsp");
                requestDispatcher.forward(req, resp);
                break;
        }

    }
}
