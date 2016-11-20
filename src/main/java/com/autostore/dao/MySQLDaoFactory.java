package com.autostore.dao;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class MySQLDaoFactory extends DaoFactory {

    public static final String JNDI_MYSQL_RESOURCE = "java:comp/env/jdbc/wsite";

    public Connection createConnection() {

        Context ctx = null;
        try {
            ctx = new InitialContext();
            return ((DataSource) ctx.lookup(JNDI_MYSQL_RESOURCE)).getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return createConnection();
    }

    @Override
    public UserDao getUserDao() {
        return new MySQLUserDao();
    }

    @Override
    public TokenDao getTokenDao() {
        return new MySQLTokenDao();
    }

    @Override
    public DiscussionsDao getQuestionsDao() {
        return new MySQLDiscussionsDao();
    }
    @Override
    public SolutionsDao getAnswersDao() {
        return new MySQLSolutionsDao();
    }
}
