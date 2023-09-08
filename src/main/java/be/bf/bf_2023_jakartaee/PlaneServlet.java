package be.bf.bf_2023_jakartaee;

import be.bf.bf_2023_jakartaee.freemarker.ModelAndView;
import freemarker.template.TemplateException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "plane", urlPatterns = {"/plane"})
public class PlaneServlet extends HttpServlet {

    private List<String> strs = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        strs = new ArrayList<>();
    }

    @Override
    protected void doGet(
            HttpServletRequest req, //Correspond à la demande du client
            HttpServletResponse resp //Correspond à ce que vous envoyez au client
    ) throws ServletException, IOException {
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        if (name != null && !name.equals("")) {
            strs.add(name);
        }


        ModelAndView mv = new ModelAndView("planes/index");
        mv.put("name", name);
        mv.put("names", strs);
        mv.put("contextPath", req.getContextPath());

        try {
            mv.process(resp.getOutputStream());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String line = req.getReader().readLine();

        resp.getWriter().println("OK");

        resp.sendRedirect(req.getContextPath()+ "/plane");
    }
}

