package com.autostore.pojo;


public enum UserTypes {

    SOLUTIONER("SOLUTIONER"),
    DISCUSSER("DISCUSSER"),
    ;

    private final String text;

    /**
     * @param text
     */
    private UserTypes(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
