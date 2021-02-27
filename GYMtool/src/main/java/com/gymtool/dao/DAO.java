package com.gymtool.dao;

import java.sql.SQLException;
import java.util.Optional;

/**
 * L'interfaccia DAO, si basa appunto sulla struttura dell'ominimo Pattern (Data Access Objcet)
 * dichiara al suo interno i metodi CRUD (create, retrive, update e delete)
 * Rappresenta il punto di connessione tra il Database e il Model
 * Ogni accesso al DB passa per una implementazione dell'interfaccia DAO.
 */
public interface DAO<T> {

    Optional<T> get(int id) throws SQLException;

    void Add(T t) throws SQLException;

    void update(T t, String[] params) throws SQLException;

    void delete(T t) throws SQLException;

    Optional<T> get(String name) throws SQLException;

}
