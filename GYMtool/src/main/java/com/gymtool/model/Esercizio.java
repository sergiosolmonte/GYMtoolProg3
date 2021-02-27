package com.gymtool.model;

/**
 * Classe che racchiude la logica dell'applicazione
 * per quanto riguarda il modello Esercizio.
 * La classe rispecchia il principio del'incapsulamento
 * con i vari metodi setter e getter.
 * Consente l'acquisizione dei dati contenuti  DB ottenuti tramite l'interfaccia fornita dal DAO
 * */

public class Esercizio {
    private int ID;
    private String nome;
    private String descrizione;
    private int categoria;

    public Esercizio(){}

    public Esercizio(int newID, String nome, String desc, int cat){
        this.ID=newID;
        this.nome=nome;
        this.descrizione=desc;
        this.categoria=cat;
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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return ("ID:"+this.getID()+
                "Nome:"+this.getNome()+
                "Descrizione:"+this.getDescrizione()+
                "Categoria:"+this.getCategoria());
    }

}
