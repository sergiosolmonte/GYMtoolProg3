package com.gymtool.strategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Implementazione dell'Action che restituisce il JSP della pagina di registrazione.
 *
 */
public class registrerAction implements Action{

    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        return "registration";
    }
}
