package com.gymtool.strategy;

import com.gymtool.dao.DaoUtente;

import com.gymtool.model.Utente;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Classe concreta che implementa l'interfaccia Action del pattern
 * Strategy, sovrascrivendo il metodo execute con l'algoritmo da eseguire.
 * L'azione che esegue è quella di ricevere le informazioni dell'utente da registrare
 * Grazie al DAO è possibile inserire l'utente all'interno del DB.
 */
public class doRegisterAction implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nome = request.getParameter("firstname");
        String cognome = request.getParameter("lastname");
        String username = request.getParameter("username");
        String dataNascita = request.getParameter("birthdate");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
//        System.out.println("Nuovo utente:"+nome+newLine+cognome+newLine+username+newLine+dataNascita+newLine);

        Utente newUt = new Utente();
        newUt.setID(1);
        newUt.setNome(nome);
        newUt.setCognome(cognome);
        newUt.setUsername(username);
        newUt.setEmail(email);
        newUt.setPassword(password1);
        newUt.setDataNascita(dataNascita);

        DaoUtente newutDao = new DaoUtente();
        try {
            newutDao.Add(newUt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "login";
    }
}

