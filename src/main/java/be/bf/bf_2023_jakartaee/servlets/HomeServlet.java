package be.bf.bf_2023_jakartaee.servlets;

import be.bf.bf_2023_jakartaee.controllers.HomeController;
import be.bf.bf_2023_jakartaee.freemarker.ModelAndView;
import freemarker.template.TemplateException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "home", urlPatterns = {"/home/*"})
public class HomeServlet extends HttpServlet {
    @PersistenceContext(unitName = "bfjpa")
    private EntityManager manager;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> model = new HashMap<>();
        HomeController controller = new HomeController();

        String[] pattern = req.getRequestURI().split("/");
        String view = "error/404";

        if (pattern.length == 4) {
            String id = pattern[3];
            view = controller.detailAction(model, Integer.parseInt(id));
        } else {
            view = controller.indexAction(model);
        }

        ModelAndView mv = new ModelAndView(view, model);
        try {
            mv.process(resp.getOutputStream());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}

