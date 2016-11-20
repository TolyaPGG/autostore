package com.autostore.dao;

import java.sql.Connection;
import java.sql.SQLException;


public abstract class DaoFactory  {

    public static final int MYSQL = 1;

    public static DaoFactory getDAOFactory(int whichFactory) {

        switch (whichFactory) {
            case 1:
                return new MySQLDaoFactory();
            default           :
                return null;
        }
    }
    public abstract Connection getConnection() throws SQLException;

    public abstract UserDao getUserDao();
    public abstract TokenDao getTokenDao();
    public abstract DiscussionsDao getQuestionsDao();
    public abstract SolutionsDao getAnswersDao();

}
