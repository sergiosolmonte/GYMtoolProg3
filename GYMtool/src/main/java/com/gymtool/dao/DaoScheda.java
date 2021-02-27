package com.gymtool.dao;

import com.gymtool.DB;
import com.gymtool.model.Scheda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * DaoScheda utilizza i metodi CRUD e aggiunge metodi come getAllforMe() e getLast()
 * che rispettivamente prendono tutte le schede per un determinato utente e prende l'ultima
 * scheda aggiunta da quell'utente.
 */
public class DaoScheda implements DAO<Scheda>{

    static Connection conn = DB.getIstances().getConnection();

    @Override
    public Optional<Scheda> get(int id) throws SQLException {

        String query = "select * from Scheda where ID="+id;

        Scheda scheda = new Scheda();
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            scheda = new Scheda(rs.getInt("ID"),rs.getInt("IDutente"), rs.getString("Nome"),rs.getBoolean("Share"));
        }
        ps.close();

        return Optional.of(scheda);



    }

    @Override
    public Optional<Scheda> get(String username) throws SQLException {
        return Optional.empty();
    }


    public ArrayList<Optional<Scheda>> getAllforMe(int userID) throws SQLException {

        String query = "select * from Scheda where IDutente="+userID;
        ArrayList<Optional<Scheda>> schede = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            schede.add(Optional.of(new Scheda(rs.getInt("ID"),rs.getInt("IDutente"), rs.getString("Nome"),rs.getBoolean("Share"))));
        }
        ps.close();
        return schede;
    }


    public Optional<Scheda> getLast(int idU) throws SQLException {
        String query = "select * from Scheda where IDutente= ? ORDER BY ID DESC";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, idU);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

           Optional<Scheda> s=Optional.of(new Scheda(rs.getInt("ID"), rs.getInt("idUtente"), rs.getString("Nome"), rs.getBoolean("Share")));
           ps.close();
           return s;
        }
        ps.close();
        return Optional.empty();
    }

    @Override
    public void Add(Scheda newScheda) throws SQLException {

        String query =" INSERT INTO Scheda (idUtente,Nome,Share) VALUES (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,newScheda.getIdUtente());
        ps.setString(2,newScheda.getNome());
        ps.setBoolean(3,newScheda.isShare());



        int row = ps.executeUpdate();
        ps.close();
        // rows affected
        //System.out.println(row); //1

    }

    @Override
    public void update(Scheda scheda, String[] params) throws SQLException {

    }

    public int getCount(int idUtente) throws SQLException{
        String query = "SELECT COUNT (*) AS cont FROM Scheda WHERE idUtente=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,idUtente);
        ResultSet rs ;
        int row = 0;
        rs = ps.executeQuery();

        if(rs.next())
            row = rs.getInt("cont");

        ps.close();
        return row;
    }

    @Override
    public void delete(Scheda scheda) throws SQLException {
        String query="DELETE FROM Allenamento WHERE idScheda=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,scheda.getID());
        ps.executeUpdate();
        ps.close();
        String query2="DELETE FROM Scheda WHERE ID = ?";
        PreparedStatement ps1 = conn.prepareStatement(query2);
        ps1.setInt(1,scheda.getID());
        ps1.executeUpdate();
        ps1.close();
    }
}
