package com.gymtool.strategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Classe concreta che implementa l'interfaccia Action del pattern
 * Strategy, sovrascrivendo il metodo execute con l'algoritmo da eseguire.
 * Restituisce la vista della homepage.
 */
public class HomeAction implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        return "index";
    }
}
