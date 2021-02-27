package com.gymtool.strategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Action che ritorna la pagina contenete il survey per eseguire la creazione automatica della scheda.
 */
public class EditorProAction implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        String userName = String.valueOf(session.getAttribute("userName"));

        if(userName.equals("null")){
            return "index";
        }

        return "editorPro";
    }
}
