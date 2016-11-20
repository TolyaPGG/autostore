package com.autostore.dao;

import com.autostore.pojo.Discussion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLDiscussionsDao extends MySQLDaoFactory implements DiscussionsDao {
    @Override
    public void add(Discussion discussion) throws SQLException {
        PreparedStatement stmt = null;
        Connection con = getConnection();
        try {
            stmt = con.prepareStatement("INSERT INTO quests "
                    + "(text, author, date, theme, title)"
                    + "VALUES( ?,?,?,?,?)");

            stmt.setString(1, discussion.getText());
            stmt.setString(2, discussion.getAuthor());
            stmt.setTimestamp(3, new Timestamp(discussion.getDate().getTime()));
            stmt.setString(4, discussion.getTheme());
            stmt.setString(5, discussion.getTitle());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Discussion> getAll() {
        List<Discussion> discussions = new ArrayList<>();
        String sql = "SELECT * FROM quests";
        Discussion s = null;
        PreparedStatement stm = null;
        Connection con = null;
        try {
            con = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                s = new Discussion();
                s.setTitle(rs.getString("title"));
                s.setTheme(rs.getString("theme"));
                s.setQ_id(rs.getInt("q_id"));
                s.setAuthor(rs.getString("author"));
                s.setText(rs.getString("text"));
                s.setDate(rs.getTimestamp("date"));
                discussions.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return discussions;
    }

    @Override
    public List<Discussion> getQuestionByTheme(String theme) {
        List<Discussion> discussions = new ArrayList<>();
        String sql = "SELECT * FROM quests WHERE theme=?";
        Discussion s = null;
        PreparedStatement stm = null;
        Connection con = null;
        try {
            con = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, theme);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                s = new Discussion();
                s.setTitle(rs.getString("title"));
                s.setTheme(rs.getString("theme"));
                s.setQ_id(rs.getInt("q_id"));
                s.setAuthor(rs.getString("author"));
                s.setText(rs.getString("text"));
                s.setDate(rs.getTimestamp("date"));
                discussions.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return discussions;
    }
}
