<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : review
    Created on : Mar 24, 2023, 12:34:58 AM
    Author     : chi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3 style="margin-left: 15rem;">Result Test</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>ExamCode</th>
                    <th>Subject</th>
                    <th>Score</th>
                    <th>Start time</th>
                    <th>End time</th>
                </tr>
            </thead>
            <tbody>
            
            <c:forEach var="o" items="${list}">
                <tr>
                    <td>${o.examId}</td>
                    <td>${o.exam.examId}</td>
                    <td>${o.score}</td>
                    <td>${o.start}</td>
                    <td>${o.end}</td>
                </tr>
            </c:forEach>
                
               
            </tbody>
        </table>

        
    </body>
</html>
