package com.autostore.web.security;

import org.apache.log4j.Logger;
import com.autostore.dao.DaoFactory;
import com.autostore.dao.UserDao;
import com.autostore.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/checkusername")
public class CheckNick extends HttpServlet {
    static UserDao userDao = DaoFactory.getDAOFactory(1).getUserDao();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doProcess(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doProcess(request, response);
    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String username = request.getParameter("username");
        User result = userDao.read(username);
        Logger lg = Logger.getLogger(CheckNick.class);
        lg.info(request.getParameter("type")+ "!!!!!");
        if (result == null) {
            response.setStatus(200);
                response.getWriter().write("true");
                lg.info("Yes");

        } else {
            response.setStatus(200);

                response.getWriter().write("false");
            lg.info("Fail");
        }

    }
}