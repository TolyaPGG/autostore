package com.autostore.web.security;

import com.autostore.pojo.Discussion;
import org.apache.log4j.Logger;
import com.autostore.dao.DaoFactory;
import com.autostore.dao.DiscussionsDao;
import com.autostore.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/addDiscuss")
public class AddDiscuss extends HttpServlet {

    Logger lg = Logger.getLogger(AddDiscuss.class);
    DiscussionsDao discussionsDao = DaoFactory.getDAOFactory(1).getQuestionsDao();

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        if(request.getSession().getAttribute("user") == null){
            response.sendRedirect("/autostore/");
        }else {
            if(((User) request.getSession().getAttribute("user")).isDiscusser()) {
                Discussion discussion = new Discussion();
                discussion.setAuthor(((User) request.getSession().getAttribute("user")).getUsername());
                discussion.setDate(new Date());
                discussion.setText(request.getParameter("text"));
                discussion.setTitle(request.getParameter("title"));
                discussion.setTheme(request.getParameter("theme"));
                discussionsDao.add(discussion);
                lg.info("Discussion created and visible for it-pros");
                response.sendRedirect("/autostore/getQuests");
            }else {
                response.sendRedirect("/autostore/");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lg.info("Creating discussion");
        try {
            doProcess(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") != null && ((User) request.getSession().getAttribute("user")).isDiscusser())
            getServletContext().getRequestDispatcher("/discussion.jsp").forward(request, response);
        else
            response.sendRedirect("/autostore/");
    }
}
