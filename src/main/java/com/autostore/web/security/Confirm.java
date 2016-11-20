package com.autostore.web.security;

import com.autostore.mail.ConfirmationEmail;
import org.apache.log4j.Logger;
import com.autostore.dao.DaoFactory;
import com.autostore.dao.TokenDao;
import com.autostore.dao.UserDao;
import com.autostore.pojo.Token;
import com.autostore.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/confirm")
public class Confirm extends HttpServlet {

    static Logger log = Logger.getLogger(Confirm.class);
    static UserDao userDao = DaoFactory.getDAOFactory(1).getUserDao();
    static TokenDao tokenDao = DaoFactory.getDAOFactory(1).getTokenDao();

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String uuid = req.getParameter("uuid");
        String referer = req.getHeader("referer");
        log.trace("User has accessed the confirmation service from " + referer);
        if (uuid != null) {
            Token tk = tokenDao.readToken(uuid);
            if (tk != null) {
                User sessionUser = tk.getUser();
                if (sessionUser == null) {
                    req.setAttribute("error", "Yor confirmation link has expired");
                    getServletContext().getRequestDispatcher("/log.jsp").forward(req, resp);
                } else {
                    if (!sessionUser.isConfirmed()) {
                        req.getSession().setAttribute("user", sessionUser);
                        tokenDao.deleteToken(tk);
                        sessionUser.setConfirmed(true);
                        userDao.update(sessionUser);
                        ConfirmationEmail ce = new ConfirmationEmail(sessionUser.getEmail(), sessionUser.getUsername());
                        getServletContext().getRequestDispatcher("/confirmed.jsp").forward(req, resp);
                        ce.send();
                    } else {
                        req.setAttribute("error", "User was already confirmed before");
                        getServletContext().getRequestDispatcher("/log.jsp").forward(req, resp);
                    }
                }
            } else {
                req.setAttribute("error", "Yor confirmation link has expired");
                getServletContext().getRequestDispatcher("/log.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("error", "Yor confirmation link has expired");
            getServletContext().getRequestDispatcher("/log.jsp").forward(req, resp);

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
