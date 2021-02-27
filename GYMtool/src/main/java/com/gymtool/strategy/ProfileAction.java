package com.gymtool.strategy;

import com.gymtool.md5.MD5Util;
import com.gymtool.model.Utente;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Action che restituisce la pagina "index" in caso di utente non loggato e il profilo personale
 * nel caso di utente noto.
 *
 */
public class ProfileAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession(true);
        String userName = String.valueOf(session.getAttribute("userName"));
        String email = ((Utente) session.getAttribute("utente")).getEmail();
        session.setAttribute("avatar", MD5Util.md5Hex(email));

        if(userName.equals("null")){
            return "index";
        }
        return "profile";
    }
}
