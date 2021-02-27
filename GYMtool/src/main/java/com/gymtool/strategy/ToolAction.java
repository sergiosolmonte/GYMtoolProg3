package com.gymtool.strategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Implementazione di Action che ritorna la pagina JSP da visualizzare
 */
public class ToolAction implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        return "tool";
    }
}
