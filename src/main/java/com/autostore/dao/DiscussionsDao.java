package com.autostore.dao;

import com.autostore.pojo.Discussion;

import java.sql.SQLException;
import java.util.List;


public interface DiscussionsDao {
    public void add(Discussion post) throws SQLException;

    public List<Discussion> getAll();

    public List<Discussion> getQuestionByTheme(String tag);
}
