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

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    @EJB
    private FruitBean fruitBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        if (req.getParameter("edit") != null){
            long id = Long.valueOf(req.getParameter("edit"));
            Fruit fruit = fruitBean.get(id);
            req.setAttribute("caption", "Edit");
            req.setAttribute("fruit", fruit);
        }
        else req.setAttribute("caption", "Adding");

        req.getRequestDispatcher("/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        double calories;

        if (req.getParameter("calories").trim().equals(""))
             calories = 0.0;
        else calories = Double.valueOf(req.getParameter("calories").replace(",",".").trim());

        String fruitName = req.getParameter("fruit").trim();
        String color = req.getParameter("color").trim();


        if (fruitName.equals("") || color.equals(""))
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        else{
        if (!req.getParameter("id").equals("")){
            long id = Long.valueOf(req.getParameter("id"));
            Fruit fruit = fruitBean.get(id);
            fruit.setName(fruitName);
            fruit.setColor(color);
            fruit.setCalories(calories);
            fruitBean.update(fruit);
        } else {
            fruitBean.add(new Fruit(fruitName, color, calories));
        }
        resp.sendRedirect("list");
        }
    }
}
