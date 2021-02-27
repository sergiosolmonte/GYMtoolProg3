package com.gymtool.model;

/**
 * Classe che racchiude la logica dell'applicazione
 * per quanto riguarda il modello Categoria.
 * La classe rispecchia il principio del'incapsulamento
 * con i vari metodi setter e getter.
 * Consente l'acquisizione dei dati contenuti  DB ottenuti tramite l'interfaccia fornita dal DAO
 * */

public class Categoria {

    private int ID;
    private String nome;
    public Categoria() {}

    public Categoria(int myID, String Nome){
        this.ID=myID;
        this.nome=Nome;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return ("ID:"+this.getID()+
                "Nome:"+this.getNome());
    }

}
