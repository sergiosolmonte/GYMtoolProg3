package com.gymtool.strategy;


import com.gymtool.dao.DaoUtente;
import com.gymtool.model.Utente;
import com.gymtool.myProgram.MyProgram;
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
 * Classe concreta che implementa l'interfaccia Action del pattern
 * Strategy, sovrascrivendo il metodo execute con l'algoritmo da eseguire.
 * L'azione che esegue è quella di prendere tutte le informazioni del survey,
 * inserirle in un array di Integer e far partire il metodo doAutomaticProgram
 * della classe MyProgram().
 */
public class doEditorProAction implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession(true);
        String userName = String.valueOf(session.getAttribute("userName"));
        DaoUtente ut = new DaoUtente();
        Optional<Utente> ut1= Optional.of(new Utente());
        try {
            ut1= ut.get(userName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String json = request.getParameter("survey");

        JSONObject j = new JSONObject(json);

        JSONArray jsonArray = new JSONArray();
        ArrayList<Integer> surveyResult = new ArrayList<>();

        jsonArray.put(j.get("first"));
        jsonArray.put(j.get("second"));

        if(j.get("impegno")!=null)
            jsonArray.put(j.get("impegno"));
        else
            jsonArray.put(0);
        if(j.get("sforzo")!=null)
            jsonArray.put(j.get("sforzo"));
        else
            jsonArray.put(0);
        if (j.get("consistenza1")!=null)
        jsonArray.put(j.get("consistenza1"));
        else
            jsonArray.put(0);
        if(j.get("consistenza2")!=null)
            jsonArray.put(j.get("consistenza2"));
        else
            jsonArray.put(0);

        for (int i=0;i<jsonArray.length();i++){
            surveyResult.add(jsonArray.getInt(i));;
        }


        ArrayList<Integer> creationResult;
        //get survey result into an arraylist of Integer
        MyProgram myP = new MyProgram(surveyResult);
        creationResult = myP.doAutomaticProgram(ut1.get().getID());


        return "index";
    }
}
