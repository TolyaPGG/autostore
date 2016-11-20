package com.autostore.quartz;

import com.autostore.dao.DaoFactory;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import com.autostore.dao.TokenDao;


public class DeleteAccountsJob implements Job {
    static Logger log = Logger.getLogger(DeleteAccountsJob.class);
    static TokenDao tokenDao = DaoFactory.getDAOFactory(1).getTokenDao();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            java.util.Date newDate=new java.util.Date();
            log.trace("Accounts with tokens not confirmed to this time " + newDate.toString() + "are deleted");
            tokenDao.deleteToken(newDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
