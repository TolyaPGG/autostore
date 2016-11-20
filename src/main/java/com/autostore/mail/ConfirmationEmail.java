package com.autostore.mail;

import java.util.HashMap;
import java.util.Map;


public class ConfirmationEmail extends EmailTemplate {

    private String user;

    @Override
    public String getSubject() {
        return "Confirmation email";
    }

    @Override
    public String getTemplateAddress() {
        return "confirmation.ftl";
    }

    @Override
    public Map<String, String> getParametersMap() {
        Map<String, String> rootMap = new HashMap<String, String>();
        rootMap.put("user", this.user);
        return rootMap;
    }

    public ConfirmationEmail( String to, String user)
    {
        super(to);
        this.user=user;
    }

}
