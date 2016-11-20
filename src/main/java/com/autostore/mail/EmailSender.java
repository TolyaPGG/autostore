package com.autostore.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.log4j.Logger;

import java.io.*;


public class EmailSender {
    static Logger log = Logger.getLogger(EmailSender.class);

    MailUtil mu = null;
    EmailTemplate et = null;
    Template temp = null;
    String to = null;

    EmailSender( String to, EmailTemplate emailTemplate) {
        this.to = to;
        et = emailTemplate;
        Configuration cfg = new Configuration();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            cfg.setDefaultEncoding("UTF-8");
            cfg.setDirectoryForTemplateLoading(new File(classLoader.getResource("").getFile()));
            temp = cfg.getTemplate(emailTemplate.getTemplateAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send() {
        Writer out = new StringWriter();
        try {
            temp.process(et.getParametersMap(), out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.trace("The message to be sent:" +out.toString());
        mu = new MailUtil(to, et.getSubject(), out.toString());
        mu.start();
    }


}
