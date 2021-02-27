package com.gymtool.strategy;

import com.gymtool.DB;
import com.gymtool.dao.DaoCategoria;
import com.gymtool.dao.DaoEsercizi;
import com.gymtool.model.Categoria;
import com.gymtool.model.Esercizio;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
/**
 * Classe concreta che implementa l'interfaccia Action del pattern
 * Strategy, sovrascrivendo il metodo execute con l'algoritmo da eseguire.
 * L'azione che esegue è quella di restituire la lista di tutti gli esercizi con le relative categorie
 * alla pagina editor.
 * L'accesso alle informazioni contenute nel DB avviene grazie al DAO.
 */
public class EditorAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession(true);
        String userName = String.valueOf(session.getAttribute("userName"));
        if(userName.equals("null")){
            return "index";
        }

        ArrayList<Optional<Categoria>> categorie = null;
        try {
            categorie = new DaoCategoria().getAll("Categoria");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ArrayList<Optional<Esercizio>> esercizi = null;
        try {
            esercizi = new DaoEsercizi().getAll("Esercizio");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("categorie", categorie);
        request.setAttribute("esercizi", esercizi);
        return "editor";
    }
}
