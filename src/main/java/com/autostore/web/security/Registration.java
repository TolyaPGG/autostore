package com.autostore.web.security;

import com.autostore.dao.DaoFactory;
import com.autostore.dao.TokenDao;
import com.autostore.dao.UserDao;
import com.autostore.mail.GreetingEmail;
import com.autostore.pojo.Discusser;
import com.autostore.pojo.Token;
import com.autostore.pojo.User;
import com.autostore.pojo.UserTypes;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;


@WebServlet("/register")
public class Registration extends HttpServlet {

    static Logger log = Logger.getLogger(Registration.class);
    static UserDao userDao = DaoFactory.getDAOFactory(1).getUserDao();
    static TokenDao tokenDao = DaoFactory.getDAOFactory(1).getTokenDao();

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user;
        if(req.getParameter("status").equals("discusser")){
            log.info("Discusser");
            user = new Discusser();
            user.setRole(UserTypes.DISCUSSER.toString());
        }else{
            log.info("solutioner");
            user = new User();
            user.setRole(UserTypes.SOLUTIONER.toString()  );
        }
        log.info("Starting registering user");
        log.debug("Retrieving user name from session");
        user.setUsername(req.getParameter("username"));
        user.setFirstname(req.getParameter("firstname"));
        user.setLastname(req.getParameter("lastname"));

        try {
            user.setPassword(req.getParameter("password"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
         }
        user.setEmail(req.getParameter("email"));
        log.debug("Retrieving user email from request");
        try {
            log.info(user.getUsername() + " " +
                    user.getPassword() + " " +
                    user.getFirstname() + " " +
                    user.getLastname() + " " +
                    user.getRole() + " " +
                    user.isActive() + " "+
                    user.isConfirmed() + " "+
                    user.getEmail() + " ");
            userDao.create(user);
            user=userDao.read(user.getUsername());
            log.info("Saving user "+user.getUsername()+" succeed");
            Token tk=new Token();
            tk.setUuid(java.util.UUID.randomUUID().toString());
            Calendar c = Calendar.getInstance();
            c.setTime(new java.util.Date()); // Now use today date.
            c.add(Calendar.DATE, 5);
            java.util.Date now_plus_5_days=c.getTime();
            tk.setDeleteDate(now_plus_5_days);
            tk.setUser(user);
            tokenDao.create(tk);
            getServletContext().getRequestDispatcher("/userCreated.jsp").forward(req, resp);
            GreetingEmail ge=new GreetingEmail(user.getEmail(), user.getUsername(), req.getParameter("password"),tk.getUuid());
            ge.send();
        }
        catch (Exception ex)
        {
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
