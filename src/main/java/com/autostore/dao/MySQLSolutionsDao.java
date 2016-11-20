package com.autostore.dao;

import com.autostore.pojo.Solution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySQLSolutionsDao extends MySQLDaoFactory implements SolutionsDao {
    @Override
    public List<Solution> getAll(int qId) {
        List<Solution> messages = new ArrayList<>();
        String sql = "SELECT * FROM answers WHERE q_id = ?";
        Solution s = null;
        PreparedStatement stm = null;
        Connection con = null;
        try {
            con = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, qId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                s = new Solution();
                s.setAuthor(rs.getString("author"));
                s.setText(rs.getString("text"));
                s.setQuestionId(rs.getInt("q_id"));
                s.setAnswerId(rs.getInt("a_id"));
                messages.add(s);
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

        return messages;
    }

    @Override
    public void writeNew(Solution solution) throws SQLException {
        PreparedStatement stmt = null;
        Connection con = getConnection();
        try {
            stmt = con.prepareStatement("INSERT INTO answers "
                    + "(author, q_id, text)"
                    + "VALUES( ?,?,?)");

            stmt.setString(1, solution.getAuthor());
            System.out.println(solution.getAuthor());
            stmt.setInt(2, solution.getQuestionId());
            System.out.println(solution.getQuestionId());
            stmt.setString(3, solution.getText());
            System.out.println(solution.getText());
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
}
