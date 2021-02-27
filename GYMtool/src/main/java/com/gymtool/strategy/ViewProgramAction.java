package com.gymtool.strategy;

import com.gymtool.dao.DaoAllenamento;
import com.gymtool.dao.DaoEsercizi;
import com.gymtool.dao.DaoScheda;
import com.gymtool.model.Allenamento;
import com.gymtool.model.Esercizio;
import com.gymtool.model.Scheda;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Classe che implementa l'execute della interfaccia Action.
 * Prende in input (direttamente dall'URL) l'ID della scheda che vogliamo andare a rappresentare.
 * Dopo aver raccolto tutti gli esercizi in un JSON, con rispettivo Nome, numero totale di esercizi e numero di giorni,
 * viene settato nella sessione in modo tale che nella pagina JSP sarà possibile costruire la scheda dinamicamente.
 */
public class ViewProgramAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestURI();
        DaoScheda daoS = new DaoScheda();
        int idscheda= Integer.parseInt(request.getParameter("ID"));
        DaoAllenamento aDao = new DaoAllenamento();
        DaoEsercizi eDao = new DaoEsercizi();
        Optional<Scheda> myscheda = Optional.of(new Scheda());

        try {
            myscheda =  daoS.get(idscheda);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        JSONArray myjsonArray = new JSONArray();

        ArrayList<Optional<Allenamento>> myArray = null;
        try {
           myArray = aDao.getAllforMe(idscheda);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (Optional<Allenamento> all : myArray) {
               JSONObject json = new JSONObject();
            Optional<Esercizio> myEx = Optional.of(new Esercizio());
            try {
                myEx = eDao.get(all.get().getIDesercizio());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            json.put("name", myEx.get().getNome());
            json.put("set", all.get().getSerie());
            json.put("rep", all.get().getRipetizioni());
            json.put("time", all.get().getTempo());
            json.put("exNum", all.get().getNumero());
            json.put("day", all.get().getGiorno());

            myjsonArray.put(json);

        }
        String stringifiedJson = myjsonArray.toString();

        String schedaTitle= myscheda.get().getNome();
        HttpSession session = request.getSession();
        session.setAttribute("schedaID", idscheda);
        session.setAttribute("nomeScheda",schedaTitle);
        session.setAttribute("JSON",stringifiedJson);

        return "archivio/viewProgram";
    }
}
