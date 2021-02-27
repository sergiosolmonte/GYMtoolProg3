package com.gymtool.strategy;

import com.gymtool.dao.DAO;
import com.gymtool.dao.DaoCategoria;
import com.gymtool.dao.DaoScheda;
import com.gymtool.dao.DaoUtente;
import com.gymtool.model.Categoria;
import com.gymtool.model.Scheda;
import com.gymtool.model.Utente;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Classe concreta che implementa l'interfccia Action del pattern
 * Strategy, sovrascrivendo il metodo execute con l'algoritmo da eseguire.
 * L'azione che esegue è quella di prendere tutte le schede di quell'utente
 * nel DB e restituirle alla pagina archivio.
 */

public class ArchivioAction implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession(true);
        String userName = String.valueOf(session.getAttribute("userName"));

        DAO utDao = new DaoUtente();
        Optional<Utente> ut = Optional.of(new Utente());

        try {
            ut = utDao.get(userName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        int idUtente= ut.get().getID();
        ArrayList<Optional<Scheda>> schede = null;
        try {
            schede = new DaoScheda().getAllforMe(idUtente);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("schede", schede);

        return "archivio";
    }
}
