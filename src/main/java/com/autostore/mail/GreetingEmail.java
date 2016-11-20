package com.autostore.mail;

import java.util.HashMap;
import java.util.Map;


public class GreetingEmail extends EmailTemplate {

    private String user;
    private String password;
    private String uuid;

    @Override
    public String getSubject() {
        return "Greeting email";
    }

    @Override
    public String getTemplateAddress() {
        return "greeting.ftl";
    }

    @Override
    public Map<String, String> getParametersMap() {
        Map<String, String> rootMap = new HashMap<String, String>();
        rootMap.put("user", this.user);
        rootMap.put("password", this.password);
        rootMap.put("uuid", this.uuid);
        return rootMap;
    }

    public GreetingEmail(String to, String user, String password, String uuid)
    {
        super(to);
        this.user=user;
        this.password=password;
        this.uuid=uuid;
    }



}
