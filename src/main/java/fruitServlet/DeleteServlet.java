package fruitServlet;


import fruitBean.FruitBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

    @EJB
    private FruitBean fruitBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("id").equals("") && req.getParameter("id") != null){
            long id = Long.valueOf(req.getParameter("id"));
            fruitBean.delete(id);
        }
        resp.sendRedirect("list");
    }
}
