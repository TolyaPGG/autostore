package com.autostore.web.security;

import com.autostore.dao.DaoFactory;
import com.autostore.dao.UserDao;
import com.autostore.pojo.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    static Logger log = Logger.getLogger(Login.class);
    static UserDao userDao = DaoFactory.getDAOFactory(1).getUserDao();

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("j_username");
        String password = req.getParameter("j_password");
        String referer = req.getHeader("Referer");

        if (username != null) {
            if (password != null) {
                User sessionUser = userDao.read(username, password);
                if (sessionUser != null) {
                    if (sessionUser.isConfirmed()) {
                        if (sessionUser == null) {
                            req.setAttribute("error", "Incorrect username or password");
                            getServletContext().getRequestDispatcher("/log.jsp").forward(req, resp);
                        } else {
                            req.getSession().setAttribute("user", sessionUser);
                            req.getSession().setMaxInactiveInterval(345600);
                            if (referer.contains("login")) {
                                resp.sendRedirect(referer.replace("login", ""));
                                log.info("The referer is passed to redirect here: " + referer.replace("login", ""));
                            } else {
                                req.getSession().setAttribute("url", referer);
                                resp.sendRedirect(referer.replace("login", ""));
                                log.info("The referer is passed to redirect here: " + referer);
                            }
                        }

                    } else {
                        req.setAttribute("error", "User is not confirmed yet");
                        getServletContext().getRequestDispatcher("/log.jsp").forward(req, resp);
                    }
                } else {
                    req.setAttribute("error", "Incorrect username or password");
                    getServletContext().getRequestDispatcher("/log.jsp").forward(req, resp);
                }

            } else {
                req.setAttribute("error", "Username or password was not passed");
                getServletContext().getRequestDispatcher("/log.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("error", "Username or password was not passed");
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
