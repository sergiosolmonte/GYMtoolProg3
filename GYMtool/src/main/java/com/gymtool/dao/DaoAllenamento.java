package com.gymtool.dao;

import com.gymtool.DB;
import com.gymtool.model.Allenamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

/**
 *  La classe DaoAllenamento implementa i metodi definiti dall'interfaccia
 *  aggiungendo il metodo getAllforMe, utilizzato per ricavare tutti gli allenamenti per un
 *  determinato idScheda.
 */
public class DaoAllenamento implements DAO<Allenamento> {

    static Connection conn = DB.getIstances().getConnection();

    @Override
    public Optional<Allenamento> get(int id) throws SQLException {
        String query = "select * from Allenamento where ID= ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            return Optional.of(new Allenamento(rs.getInt("ID"), rs.getInt("idEsercizio"), rs.getInt("idScheda"), rs.getInt("Serie"), rs.getInt("Ripetizioni"), rs.getInt("Giorno"), rs.getInt("Riga"), rs.getInt("Tempo")));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Allenamento> get(String username) throws SQLException {
        return Optional.empty();
    }

    public ArrayList<Optional<Allenamento>> getAllforMe(int schedaID) throws SQLException {

        String query = "select * from Allenamento where idScheda="+schedaID;
        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        ArrayList<Optional<Allenamento>> array= new ArrayList<>();
        while (rs.next()) {

//            return Optional.of(new Allenamento(rs.getInt("idEsercizio"),  rs.getInt("Serie"), rs.getInt("Ripetizioni"), rs.getInt("Giorno"), rs.getInt("Riga"), rs.getInt("Tempo")));
            Allenamento a1 = new Allenamento();
            a1.setIDesercizio(rs.getInt("idEsercizio"));
            a1.setSerie(rs.getInt("Serie"));
            a1.setRipetizioni(rs.getInt("Ripetizioni"));
            a1.setGiorno(rs.getInt("Giorno"));
            a1.setNumero(rs.getInt("Riga"));
            a1.setTempo(rs.getInt("Tempo"));
            array.add(Optional.of(a1));
        }
        ps.close();
        return array;

    }

    @Override
    public void Add(Allenamento newAll) throws SQLException {

        String query =" INSERT INTO Allenamento (idEsercizio,idScheda,Serie,Ripetizioni,Giorno,Riga,Tempo) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,newAll.getIDesercizio());
        ps.setInt(2,newAll.getIDscheda());
        ps.setInt(3,newAll.getSerie());
        ps.setInt(4, newAll.getRipetizioni());
        ps.setInt(5, newAll.getGiorno());
        ps.setInt(6, newAll.getNumero());
        ps.setInt(7, newAll.getTempo());

        int row = ps.executeUpdate();
        // rows affected
        //System.out.println(row); //1

    }

    @Override
    public void update(Allenamento allenamento, String[] params) {

    }

    @Override
    public void delete(Allenamento allenamento) throws SQLException{

    }
}
