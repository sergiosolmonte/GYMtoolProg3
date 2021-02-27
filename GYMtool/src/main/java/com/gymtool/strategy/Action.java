package com.gymtool.strategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * L'interfaccia action deriva dal pattern Strategy.
 * Questo metodo "execute" rappresenta l'operazione che le classi concrete
 * andranno ad implementare con il loro algoritmo.
 */
public interface Action {
    String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
