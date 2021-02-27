package com.gymtool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private Connection Database;
    private static DB istance;
    String user = "sqladmin";
    String passwd = "admin";
    String url = "jdbc:mariadb://localhost:3306/gymtool";
    String driver = "org.mariadb.jdbc.Driver";

    /**
     * Costruttore che inizializza la connessione al DB utilizzando i driver del database in uso.
     * Il nostro schema nel DB si chiama "gymtool", per un altro schema basta cambiare il nome dopo "/"
     * nella stringa URL.
     */
    private DB() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Database = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connection estabilished!");
        } catch (SQLException   e) {
            System.out.println("Connection failed!");
        } catch (ClassNotFoundException e1){
            System.out.println("ERRORE NEL DB!");
        }
    }

    /**
     * Metodo che ritorna l'istanza di DB statica, l'unico punto di accesso.
     * @return
     */
    public final static DB getIstances() {
        if (istance == null)
            istance = new DB();
        return istance;
    }

    /**
     * Questo metodo viene utilizzato nel DAO per ricavare il canale di comuncazione
     * con l'istanza del DB.
     * @return la connessione al DB.
     * Se la connessione è stata chiusa, viene ricreata sulla stessa istanza di DB.
     */
    public Connection getConnection(){
        try {
            if (Database.isClosed()) {
                this.Database = DriverManager.getConnection(url, user,passwd);
                return Database;
        }} catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        
        return Database;
    }
}