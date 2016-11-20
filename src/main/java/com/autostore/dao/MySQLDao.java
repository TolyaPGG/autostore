package com.autostore.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLDao {
    Connection getConnection()
    {
        try {
            return DaoFactory.getDAOFactory(1).getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
