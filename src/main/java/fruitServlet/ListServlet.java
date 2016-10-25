package fruitServlet;

import fruitBean.FruitBean;
import fruitEntity.Fruit;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet{

    @EJB
    FruitBean fruitBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<Fruit> allFruit = fruitBean.getAll();

        req.setAttribute("fruits",allFruit);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<Fruit> allFruit = fruitBean.getAll();

        req.setAttribute("fruits",allFruit);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}
