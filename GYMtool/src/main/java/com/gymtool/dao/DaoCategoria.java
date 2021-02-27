package com.gymtool.dao;

import com.gymtool.DB;
import com.gymtool.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ArrayList;

/**
 *  La classe Dao Categoria implementa tutti i metodi dell'interfaccia
 *  aggiungendo il metodo getAll() che restituisce tutte le categorie, utilizzato
 *  sia per la pagina dei gruppi muscolari che per l'editor.
 */
public class DaoCategoria implements DAO<Categoria> {
    @Override
    public Optional<Categoria> get(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<Categoria> get(String username) throws SQLException {
        return Optional.empty();
    }

    public ArrayList<Optional<Categoria>> getAll(String nameOf) throws SQLException {
        Connection con = DB.getIstances().getConnection();
        String query1 = "Select ID, Nome From "+nameOf;
        ArrayList<Optional<Categoria>> categorie = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(query1);

        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            categorie.add(Optional.of(new Categoria(rs.getInt("ID"), rs.getString("Nome"))));
        }
        ps.close();
        return categorie;
    }


    @Override
    public void Add(Categoria categoria) throws SQLException {

    }

    @Override
    public void update(Categoria categoria, String[] params) throws SQLException {

    }

    @Override
    public void delete(Categoria categoria) throws SQLException {

    }
}
