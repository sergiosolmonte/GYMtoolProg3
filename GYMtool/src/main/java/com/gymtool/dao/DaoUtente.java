package com.gymtool.dao;

import com.gymtool.DB;
import com.gymtool.model.Utente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/** DaoUtente implementa tutte le funzioni CRUD dell'interfaccia.
 *  DaoUtente effettua un overload sul metodo get() in modo da prendere l'utente in base all'username
 *  e non in base all'id. Utilizzato nel DaoLogin.
 */
public class DaoUtente implements DAO<Utente>{

    static Connection conn = DB.getIstances().getConnection();

    @Override
    public Optional<Utente> get(int id)
            throws SQLException {
        String query = "select * from utente where ID= ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Utente ut = new Utente();
            ut.setID(rs.getInt("IDutente"));
            ut.setNome(rs.getString("NomeUtente"));
            ut.setPassword(rs.getString("Password"));
            ps.close();
            return Optional.of(ut);
        }
        ps.close();
        return Optional.empty();
    }

    @Override
    public void Add(Utente newUt) throws SQLException{

        String query =" INSERT INTO Utente (Nome,Cognome,Username,Password,Email,DataNascita) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1,newUt.getNome());
        ps.setString(2,newUt.getCognome());
        ps.setString(3,newUt.getUsername());
        ps.setString(4,newUt.getPassword());
        ps.setString(5,newUt.getEmail());
        ps.setString(6, newUt.getDataNascita());
        int row = ps.executeUpdate();
        ps.close();
        // rows affected
        System.out.println(row); //1
    }

    @Override
    public void update(Utente utente, String[] params) throws SQLException {

        System.out.println("Dentro Update Utente: "+params);


        String query = "UPDATE Utente " +
                       "SET " +
                       "DataNascita=?," +
                       "Altezza=?," +
                       "Peso=?," +
                       "Vita=?," +
                       "Collo=?" +
                       "WHERE ID=?";

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1,params[2] );
        ps.setString(2,params[4] );
        ps.setString(3,params[3] );
        ps.setString(4,params[5] );
        ps.setString(5,params[6] );
        ps.setInt(6,utente.getID() );
        ps.executeQuery();
        ps.close();





    }

    @Override
    public void delete(Utente utente) {

    }

    @Override
    public Optional<Utente> get(String username)
            throws SQLException {
            String query = "select ID,Nome,Cognome,DataNascita,Password,Email,Altezza,Peso,Vita,Collo from Utente where Username= ?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Utente ut = new Utente();
                ut.setID(rs.getInt("ID"));
                ut.setNome(rs.getString("Nome"));
                ut.setCognome(rs.getString("Cognome"));
                ut.setDataNascita(rs.getString("DataNascita"));
                ut.setPassword(rs.getString("Password"));
                ut.setEmail(rs.getString("Email"));
                if((rs.getString("Altezza") != null) && (!rs.getString("Altezza").equals("")))
                    ut.setAltezza(Double.parseDouble(rs.getString("Altezza")));
                if((rs.getString("Peso") != null) && (!rs.getString("Peso").equals("")))
                    ut.setPeso(Double.parseDouble(rs.getString("Peso")));
                if((rs.getString("Vita") != null) && (!rs.getString("Vita").equals("")))
                    ut.setVita(Double.parseDouble(rs.getString("Vita")));
                if((rs.getString("Collo") != null) && (!rs.getString("Collo").equals("")))
                    ut.setCollo(Double.parseDouble(rs.getString("Collo")));

                ps.close();
                return Optional.of(ut);
            }
            ps.close();
            return Optional.empty();
    }




}
