package com.gymtool.factory;

import com.gymtool.strategy.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe che è realizzata seguendo il pattern Factory.
 * A seconda del metodo utilizzato e della
 * pagina richiesta viene creata l'Action corrispondente.
 * Si utilizza una sola istanza della Factory alla quale si accede con il metodo getInstance()
 * il metodo getAction() restituisce l'istanza della classe che implementa Action.
 * */

public class ActionFactory {

    Map<String,Action> actions;
    private static ActionFactory instance;

    private ActionFactory(){
        actions = new HashMap<>();
        actions.put("GET/content", new HomeAction());
        actions.put("GET/index", new HomeAction());
        actions.put("GET/gruppimuscolari", new GruppiAction());
        actions.put("GET/login", new LoginAction());
        actions.put("GET/editor", new EditorAction());
        actions.put("POST/editor", new saveEditorAction());
        actions.put("POST/login", new doLoginAction());
        actions.put("GET/registration", new registrerAction());
        actions.put("POST/registration", new doRegisterAction());
        actions.put("GET/profile", new ProfileAction());
        actions.put("GET/messaggi", new messaggiAction());
        actions.put("GET/archivio", new ArchivioAction());
        actions.put("GET/logout", new LogoutAction());
        actions.put("GET/editorPro", new EditorProAction());
        actions.put("POST/editorPro", new doEditorProAction());
        actions.put("GET/archivio/viewProgram", new ViewProgramAction());
        actions.put("POST/profile", new doEditProfileAction());
        actions.put("GET/tool", new ToolAction());
        actions.put("GET/tool/bmi", new BmiAction());
        actions.put("GET/tool/bodyfat", new BodyfatAction());
        actions.put("GET/tool/idealWeight", new IdealweightAction());
        actions.put("GET/tool/macros", new MacrosAction());
        actions.put("GET/tool/kcal", new KcalAction());

    }

    public static ActionFactory getInstance(){
        if (instance == null)
            instance = new ActionFactory();
        return instance;
    }

    public Action getAction(HttpServletRequest request) throws ServletException {

        if (request.getPathInfo().contains("pages")) {
            if (actions.get(request.getMethod() + request.getPathInfo().substring(6)) != null) {
                return actions.get(request.getMethod() + request.getPathInfo().substring(6));
            }
        } else {
            if (actions.get(request.getMethod() + request.getPathInfo()) != null)
                return actions.get(request.getMethod() + request.getPathInfo());
        }
        return new HomeAction();
    }
}
