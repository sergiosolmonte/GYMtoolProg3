package com.gymtool.servlet;

import com.gymtool.factory.ActionFactory;
import com.gymtool.strategy.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Classe che realizza il pattern Front Controller (un caso particolare del
 * design pattern Mediator) che consiste nel creare un unico handler
 * per gestire tutte le richieste.
 * In questo caso, il front controller impelmenta sia la parte del Controller,
 * sia la parte del View (facendo riferimento alla struttura MVC).
 * Questo perchè le view sono state realizzate tramite pagine .jsp dunque prodotte lato-server.
 *
 */
@WebServlet(name = "FrontControllerServlet",urlPatterns="/pages/*")
public class FrontControllerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
            try {
                Action action = ActionFactory.getInstance().getAction(request);
                String view = action.execute(request, response);

                if (view.equals("index")) {
                    response.sendRedirect(request.getContextPath() + "/");
                }
                else if (view.equals(request.getPathInfo().substring(1))){

                    request.getRequestDispatcher("/WEB-INF/" + view + ".jsp").forward(request, response);
                }
                else if(request.getPathInfo().substring(1).contains("pages")) {
                    if(view.equals(request.getPathInfo().substring(7))) {
                        response.sendRedirect(request.getContextPath()+request.getPathInfo());
                    }
                    else {
                           response.sendRedirect(request.getContextPath() + "/");
                    }
                }
                else {
                    response.sendRedirect(request.getContextPath()+"/");
                }
            }
            catch (Exception e) {
                throw new ServletException("Executing action failed.", e);
            }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }//
    public void destroy() {}

}