package com.autostore.dao;

import com.autostore.pojo.User;
import com.autostore.pojo.Token;

import java.util.Date;


public interface TokenDao {

    public void create(Token token);

    public Token readToken(String uuid);

    public void deleteUser(Token token);

    public void deleteToken(Token token);

    public void deleteToken(Date date);

    public User readUser(String uuid);
}
