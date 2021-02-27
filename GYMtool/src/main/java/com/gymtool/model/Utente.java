package com.gymtool.model;

import java.time.LocalDate;

/**
 * Classe che racchiude la logica dell'applicazione
 * per quanto riguarda il modello Utente.
 * La classe rispecchia il principio del'incapsulamento
 * con i vari metodi setter e getter.
 * Consente l'acquisizione dei dati contenuti nel DB ottenuti tramite l'interfaccia fornita dal DAO.
 * Consente operazioni quali la registrazione e l'autenticazione.
 * */


public class Utente {
    private int ID;
    private String Nome;
    private String Cognome;
    private String Username;
    private String Email;
    private String Password;
    private String dataNascita;
    private double Altezza;
    private double Peso;
    private double Vita;
    private double Collo;

    public Utente() {}

    public Utente(int myID, String myName, String myPass) {
        this.ID = myID;
        this.Nome = myName;
        this.Password = myPass;
    }

    public int getID() { return this.ID; }

    public String getNome() { return this.Nome; }

    public String getCognome() { return this.Cognome; }

    public String getUsername() { return this.Username; }

    public String getPassword() { return this.Password; }

    public String getDataNascita() { return this.dataNascita;}

    public void setID(int newID) { this.ID = newID; }

    public void setNome(String newName) {this.Nome = newName;}

    public void setCognome(String newCognome) {this.Cognome = newCognome;}

    public void setUsername(String newUsername) {this.Username = newUsername;}

    public void setDataNascita(String newData) { this.dataNascita = newData;}

    public void setPassword(String newPass) {this.Password = newPass;}

    public double getAltezza() {
        return Altezza;
    }

    public void setAltezza(double altezza) {
        Altezza = altezza;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double peso) {
        Peso = peso;
    }

    public double getVita() {
        return Vita;
    }

    public void setVita(double vita) {
        Vita = vita;
    }

    public double getCollo() {
        return Collo;
    }

    public void setCollo(double collo) {
        Collo = collo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getAge(){
        LocalDate d = LocalDate.now();
        int year=d.getYear();
        LocalDate myDate = LocalDate.of(Integer.parseInt(getDataNascita().substring(0,4)),Integer.parseInt(getDataNascita().substring(5,7)),Integer.parseInt(getDataNascita().substring(8,10)));
        int age = year - myDate.getYear() ;

        return age;
    }
}


