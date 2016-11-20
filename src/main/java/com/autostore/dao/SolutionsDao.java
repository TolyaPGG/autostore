package com.autostore.dao;

import com.autostore.pojo.Solution;

import java.sql.SQLException;
import java.util.List;


public interface SolutionsDao {
    public List<Solution> getAll(int dialogId);
    public void writeNew(Solution solution) throws SQLException;
}
