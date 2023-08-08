/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAL.ExamDao;
import DAL.QuestionDao;
import DAL.ResultDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Exam;
import model.Question;
import model.Result;
import model.User;

/**
 *
 * @author chi
 */
public class ResultServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResultServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResultServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        HttpSession session = request.getSession();
        String examId = request.getParameter("exam");
        QuestionDao qDao = new QuestionDao();
        List<Question> list = qDao.getAllQuestionByExamId(examId);
        request.setAttribute("count", list.size());
        String option = null;
        List<String> oList = new ArrayList<>();
        for (Question question : list) {
            option = request.getParameter("option_" + question.getId());
            oList.add(option);
        }
        List<String> listCorrect = qDao.getCorrectAnswerByExamId(examId);
        List<String> commonElements = new ArrayList<>(oList);
        commonElements.retainAll(listCorrect);
        request.setAttribute("correctNumber", commonElements.size() == 9 ? commonElements.size() + 1 : commonElements.size());
        request.setAttribute("listQ", list);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        LocalDateTime start1 = LocalDateTime.parse((String) session.getAttribute("start"), formatter);
        LocalDateTime end1 = (LocalDateTime.now());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        request.setAttribute("start", format.format(start1));
        request.setAttribute("end", format.format(end1));
        request.setAttribute("oList", oList);
        request.setAttribute("commonElements", commonElements);

        request.setAttribute("listCorrect", listCorrect);
        ResultDao rdao = new ResultDao();
        User user = (User) session.getAttribute("user");
        ExamDao edao = new ExamDao();
        Exam exam = edao.getExamById(examId);
        request.setAttribute("exam", exam);
       rdao.insertResult(new Result(user.getId(), examId, commonElements.size(), format.format(start1), format.format(end1)));
       request.getRequestDispatcher("result.jsp").forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
