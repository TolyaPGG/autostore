package com.autostore.dao;

import com.autostore.pojo.User;

import java.sql.SQLException;
import java.util.List;


public interface UserDao {

    public void create(User user) throws SQLException;

    public User read(int key);

    public void update(User user);

    public void delete(User user);

    public List<User> getAll();

    public User read(String login, String password);

    public User read(String login);

}
