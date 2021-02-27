package com.gymtool.dao;

import com.gymtool.DB;
import com.gymtool.model.Esercizio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * La classe DaoEsercizi implementa tutti i metodi CRUD e
 * come per la classe categoria è stato aggiunto il metodo
 * getAll()
 */
public class DaoEsercizi implements DAO<Esercizio> {
    @Override
    public Optional<Esercizio> get(int id) throws SQLException {
        Connection con = DB.getIstances().getConnection();
        String query = "select * from Esercizio where ID=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Esercizio es = new Esercizio(rs.getInt("ID"),rs.getString("Nome"),rs.getString("Descrizione"),rs.getInt("CatEsercizio"));
            ps.close();
            return Optional.of(es);
        }
        ps.close();
        return Optional.empty();
    }

    @Override
    public Optional<Esercizio> get(String username) throws SQLException {
        return Optional.empty();
    }


    public ArrayList<Optional<Esercizio>> getAll(String nameOf) throws SQLException {
        Connection con = DB.getIstances().getConnection();
        String query1 = String.format("Select  ID, Nome, Descrizione, CatEsercizio From %s", nameOf);
        ArrayList<Optional<Esercizio>> esercizi = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(query1);
//        ps.setString(1, nameOf);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            esercizi.add(Optional.of(new Esercizio(rs.getInt("ID"),rs.getString("Nome"),rs.getString("Descrizione"),rs.getInt("CatEsercizio"))));
        }
        //System.out.println(esercizi);
        ps.close();
        return esercizi;
    }


    @Override
    public void Add(Esercizio esercizio) throws SQLException {

    }

    @Override
    public void update(Esercizio esercizio, String[] params) throws SQLException{

    }

    @Override
    public void delete(Esercizio esercizio) throws SQLException{

    }
}
