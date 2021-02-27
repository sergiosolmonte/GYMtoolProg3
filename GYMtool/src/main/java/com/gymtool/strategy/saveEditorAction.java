package com.gymtool.strategy;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gymtool.dao.*;
import com.gymtool.model.Allenamento;
import com.gymtool.model.Scheda;
import com.gymtool.model.Utente;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Questa action permette di ricevere un JSON contenete la scheda creata manuealmente
 * dall'utente tramite AJAX, va ad analizzare ogni riga del JSON convertendolo in allenamento.
 * Prima di ciò però viene creata una scheda contenete il nome scelto dall'utente, in modo da
 * ricavare l'id per poi assegnarlo ad ogni allenamento.
 * Questi scambi di informazioni tra DB ed Action vengono fatti tramite DAO.
 *
 */
public class saveEditorAction implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        HttpSession session = request.getSession(true);
        String userName = String.valueOf(session.getAttribute("userName"));
        if(userName.equals("null")){
            return "index";
        }

        DAO utDao = new DaoUtente();
        Optional<Utente> ut = Optional.of(new Utente());

        try {
            ut = utDao.get(userName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        int idUtente= ut.get().getID();

        String json = request.getParameter("jsonArray");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        JsonNode node;

        node = jsonNode.get(0);
        String title = node.get("title").asText();

        Scheda scheda = new Scheda();

        scheda.setIdUtente(idUtente);
        scheda.setNome(title);
        scheda.setShare(false);

        DaoScheda sDao = new DaoScheda();


        try {
            sDao.Add(scheda);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        int idScheda;

        try {
            idScheda = sDao.getLast(ut.get().getID()).get().getID();
            DaoAllenamento aDao =new DaoAllenamento();
            Allenamento a = new Allenamento();
            for(int i=1;i<jsonNode.size();i++){
                node =jsonNode.get(i);
                a.setIDscheda(idScheda);
                a.setIDesercizio(node.get("exercise").asInt());
                a.setSerie(node.get("set").asInt());
                a.setRipetizioni(node.get("rep").asInt());
                a.setTempo(node.get("time").asInt());
                a.setGiorno(node.get("day").asInt());
                a.setNumero(node.get("exNum").asInt());
                aDao.Add(a);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "editor";
    }
}
