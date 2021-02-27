package com.gymtool.model;

/**
 * Classe che racchiude la logica dell'applicazione
 * per quanto riguarda il modello Scheda.
 * La classe rispecchia il principio del'incapsulamento
 * con i vari metodi setter e getter.
 * Consente l'acquisizione dei dati contenuti  DB ottenuti tramite l'interfaccia fornita dal DAO
 * */

public class Scheda {
    private int ID;
    private int idUtente;
    private String Nome;
    private boolean share;

    public Scheda(){};
    public Scheda(int newID, int newidUtente, String newName, boolean newShare){
        this.ID=newID;
        this.idUtente=newidUtente;
        this.Nome=newName;
        this.share=newShare;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getNome() {
        return Nome;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    public boolean isShare() {
        return share;
    }
}



