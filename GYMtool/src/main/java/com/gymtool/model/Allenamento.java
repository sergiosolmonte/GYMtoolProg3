package com.gymtool.model;

/**
 * Classe che racchiude la logica dell'applicazione
 * per quanto riguarda il modello Allenamento.
 * La classe rispecchia il principio del'incapsulamento
 * con i vari metodi setter e getter.
 * Consente l'acquisizione dei dati contenuti  DB ottenuti tramite l'interfaccia fornita dal DAO
 * */

public class Allenamento {
    private int ID;
    private int IDesercizio;
    private int IDscheda;
    private int serie;
    private int ripetizioni;
    private int tempo;
    private int giorno;
    private int numero;

    public Allenamento() {}

    public Allenamento( int myID, int IDesercizio, int IDscheda, int serie, int ripetizioni, int tempo, int giorno, int numero){
        this.ID=myID;
        this.IDesercizio=IDesercizio;
        this.IDscheda=IDscheda;
        this.serie =serie;
        this.ripetizioni=ripetizioni;
        this.tempo=tempo;
        this.giorno=giorno;
        this.numero=numero;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }
    public void setIDesercizio(int IDesercizio) {
        this.IDesercizio = IDesercizio;
    }

    public int getIDesercizio() {
        return IDesercizio;
    }

    public void setIDscheda(int IDscheda) {
        this.IDscheda = IDscheda;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getIDscheda() {
        return IDscheda;
    }

    public int getSerie() {
        return serie;
    }

    public void setRipetizioni(int ripetizioni) {
        this.ripetizioni = ripetizioni;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getTempo() {
        return tempo;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    public int getGiorno() {
        return giorno;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getRipetizioni() {
        return ripetizioni;
    }

    public int getNumero() {
        return numero;
    }

}
