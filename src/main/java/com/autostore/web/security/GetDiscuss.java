package com.autostore.web.security;

import org.apache.log4j.Logger;
import com.autostore.dao.DaoFactory;
import com.autostore.dao.DiscussionsDao;
import com.autostore.pojo.Discussion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/getQuests")
public class GetDiscuss extends HttpServlet {
    Logger lg = Logger.getLogger(GetDiscuss.class);
    DiscussionsDao discussionsDao = DaoFactory.getDAOFactory(1).getQuestionsDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lg.info("Making a discuss list");
        List<Discussion> discussions = discussionsDao.getAll();
        Collections.sort(discussions);
        Collections.reverse(discussions);
        request.setAttribute("discussions", discussions);
        getServletContext().getRequestDispatcher("/discussions.jsp").forward(request, response);
        lg.info("status 200");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
