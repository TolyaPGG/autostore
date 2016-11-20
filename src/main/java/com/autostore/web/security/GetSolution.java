package com.autostore.web.security;

import com.autostore.dao.SolutionsDao;
import com.autostore.dao.DaoFactory;
import com.autostore.pojo.Solution;
import com.autostore.pojo.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;


@WebServlet("/getAnswer")
public class GetSolution extends HttpServlet {

    Logger lg = Logger.getLogger(GetSolution.class);
    SolutionsDao solutionsDao = DaoFactory.getDAOFactory(1).getAnswersDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lg.info("Adding a new Solution of questind id"+request.getSession().getAttribute("user"));
        if(request.getSession().getAttribute("user") == null){
            response.sendRedirect("log.jsp");
        }else{
            Solution newSolution = new Solution();
            newSolution.setAuthor(((User) request.getSession().getAttribute("user")).getUsername());
            newSolution.setText(request.getParameter("text"));
            newSolution.setQuestionId(Integer.parseInt(request.getParameter("id")));
            try {
                solutionsDao.writeNew(newSolution);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            lg.info("Solution written");
            response.sendRedirect("");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");

        lg.info("Answers pull taking");
        int question = Integer.parseInt(request.getParameter("id"));
        List<Solution> solutions = solutionsDao.getAll(question);
        Collections.sort(solutions);
        StringBuilder sb = new StringBuilder();

        for(Solution a : solutions){


            sb.append("<li class=\"clearfix\">\n" +
                    "<img src=\"http://dlm4.meta.ua/pic/0/25/177/ARKuzLYih9.jpg\" class=\"avatar\" alt=\"\">\n" +
                    "<div class=\"post-comments\">\n" +
                    " <p class=\"meta\">"+" <a href=\"#\">"+a.getAuthor()+"</a> says : <i class=\"pull-right\"><a href=\"#\"><small>Reply</small></a></i></p>\n" +
                    "    <p>\n" +a.getText()+
                    "   </p>\n" +
                    " </div>\n");
        }
        lg.info("status ok");
        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().write(sb.toString());
    }
}
