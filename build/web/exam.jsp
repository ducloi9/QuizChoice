<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : exam
    Created on : Mar 23, 2023, 9:07:05 PM
    Author     : chi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exam - EOS</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
              integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.css"
              integrity="sha512-UTNP5BXLIptsaj5WdKFrkFov94lDx+eBvbKyoe1YAfjeRPC+gT5kyZ10kOHCfNZqEui1sxmqvodNUx3KbuYI/A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css"
              integrity="sha512-sMXtMNL1zRzolHYKEujM2AqCLUR9F2C4/05cdbxjjLSRvMQIciEPCQZo++nk7go3BtSuK9kfa/s+a4f4i5pLkw=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"
        integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="./css/search.css" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mb-5">
            <div class="row"style=" padding: 1rem; background-color: rgba(144,144,144,.075); margin-left: 3rem; margin-right: 3rem; margin-top: 2rem; ">
                <div  class="col-4" style=" background-color: lightblue;">
                    <h3 style="text-align: center;" >EOS</h3>
                </div>
                <div class="col-4" style=" border-right: solid #000 3px;">
                    <p style="color: blue; font-weight:  bold; text-align: center; margin-top: 8px;">Student : ${sessionScope.user.fullname}</p>
                </div>
                <div class="col-4" style="border-right-color: black; background-color: lightblue; " >
                    <a href="review">
                        <p style="color: blue; font-weight:  bold; text-align: center; margin-top: 8px;">Review</p>
                    </a>
                </div>

            </div>
        </div>
        <section class="search">
            <div class="container">

                <div class="row">
                    <div class="room-des row">
                        <c:forEach var="a" items="${listE}">
                            <div class="col-md-4">
                                <form action="listexam?id=${a.examId}" method="POST">
                                    <img src="${a.image}"alt=""/>
                                    <div class="room-text">
                                        <h3>${a.name}</h3>
                                        <p>Subject: ${a.subject}</p>
                                        <p>Time limit: ${a.timeLimit} minutes</p>
                                        <input type="submit" name="test" value="Click to test">
                                        <span></span>
                                    </div>
                                </form> 
                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>

        </div>
    </section>
</body>
</html>
