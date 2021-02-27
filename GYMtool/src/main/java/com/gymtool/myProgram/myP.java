package com.gymtool.myProgram;

import java.util.ArrayList;

/**
 * Classe astratta che rappresenta i passi dell'algoritmo di creazione automatica
 * della scheda e del miglioramento automatico.
 */
public abstract class myP {

    public abstract void Assign_initial_value();

    public abstract ArrayList<Integer> doAutomaticProgram(int id);

    public abstract void getRandomProgram();

    public abstract void updateProgram();

}
