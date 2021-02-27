package com.gymtool.dao;

import com.gymtool.model.Utente;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

/**
 * DaoLogin è stata creata come validator dell'operazione
 * di Login effettuata da un utente. Si potrebbe definire come
 * un'estensione della classe DaoUtente
 */
public class DaoLogin implements DAO<Boolean>{

    static DaoUtente ut = new DaoUtente();
    static Optional<Utente> ut1 = Optional.of(new Utente());

    @Override
    public Optional<Boolean> get(int id) throws SQLException {
        return Optional.of(false);
    }

    @Override
    public Optional<Boolean> get(String username) throws SQLException {
        return Optional.empty();
    }

    public Optional<Boolean> get(String user, String pass) throws SQLException {




        ut1 = ut.get(user);

        if (ut1.isPresent()) {
            if (Objects.equals(pass,  ut1.get().getPassword())) {
//                System.out.println(ut1.get().getNome());

                return Optional.of(true);
            }
        }
        return Optional.of(false);
    }

    @Override
    public void Add(Boolean bool) throws SQLException {
            //Nothing to do
    }

    @Override
    public void update(Boolean aBoolean, String[] params) throws SQLException{

    }

    @Override
    public void delete(Boolean aBoolean) throws SQLException{

    }
}
