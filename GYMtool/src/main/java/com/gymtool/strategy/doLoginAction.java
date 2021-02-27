package com.gymtool.strategy;

import com.gymtool.dao.*;
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
 * L'azione che esegue è quella di ricevere le credenziali dell'utente da autenticare
 * Il controllo delle informazioni è affidato al DAO.
 */
public class doLoginAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        DaoLogin logDao = new DaoLogin();

        Optional<Boolean> res = Optional.of(false);
        try {
            res = logDao.get(username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (!res.get()) {
            return "login";
        } else {
            DAO utDao = new DaoUtente();
            Optional ut = Optional.of(new Utente());

            try {
                ut = utDao.get(username);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            HttpSession session = request.getSession(true);
            session.setAttribute("userName",username);
            session.setAttribute("utente",ut.get());

            return "index";
        }


    }
}
