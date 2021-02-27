package com.gymtool.strategy;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Classe concreta che implementa l'interfaccia Action del pattern
 * Strategy, sovrascrivendo il metodo execute con l'algoritmo da eseguire
 * Futura implementazione che consentirà agli utenti di comunicare tra loro.
 */
public class messaggiAction implements Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        return "messaggi";
    }
}
