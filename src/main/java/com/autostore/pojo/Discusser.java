package com.autostore.pojo;

public class Discusser extends User {

    public Discusser() {
        super(null, null);
    }

    public Discusser(String firstname, String lastname){
        super(firstname, lastname);
        setRole(UserTypes.DISCUSSER.toString());
    }

    @Override
    public boolean isDiscusser() {
        return true;
    }
}
