package com.gymtool.strategy;

import com.gymtool.dao.DaoUtente;
import com.gymtool.model.Utente;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
/**
 * Classe concreta che implementa l'interfaccia Action del pattern
 * Strategy, sovrascrivendo il metodo execute con l'algoritmo da eseguire.
 * L'azione che esegue è quella di ricevere le informazioni utente da aggiornare
 * Grazie al DAO è possibile aggiornare le informazioni all'interno del DB.
 */
public class doEditProfileAction implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String [] myParams = new String[7];
        myParams[0] = request.getParameter("nome");
        myParams[1] = request.getParameter("cognome");
        myParams[2] = request.getParameter("data_nascita");
        myParams[3] = request.getParameter("peso");
        myParams[4] = request.getParameter("altezza");
        myParams[5] = request.getParameter("vita");
        myParams[6] = request.getParameter("collo");
        String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

        HttpSession session = request.getSession(true);
        String username = String.valueOf(session.getAttribute("userName"));


        DaoUtente ut = new DaoUtente();
        Optional<Utente> ut1 = Optional.of(new Utente());

        try {
            ut1 = ut.get(username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            ut.update(ut1.get(),myParams);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            ut1=ut.get(username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        session.setAttribute("utente",ut1.get());
//        System.out.println("Modifche Effettuate");


        return "profile";
    }
}
