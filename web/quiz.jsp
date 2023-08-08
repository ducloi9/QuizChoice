<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : question
    Created on : Mar 21, 2023, 8:16:30 PM
    Author     : chi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Quiz - EOS</title>
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
    <link rel="stylesheet" href="./css/quiz.css" type="text/css">
</head>
<body>
<form action="result?exam=${exam.examId}" method="POST">
    <div class="container mb-5">
        <div class="row"style=" padding: 1rem; background-color: rgba(144,144,144,.075); margin-left: 3rem; margin-right: 3rem; margin-top: 2rem; ">
            <div  class="col-4" style=" background-color: lightblue;">
                <h3 style="text-align: center; margin-top: 2.3rem;" >${exam.subject}</h3>
            </div>
            <div class="col-4" style=" border-right: solid #000 3px;">
                <p style="color: blue; font-weight: bold; margin-bottom: 1rem;">Duration : ${exam.timeLimit} minutes</p>
                <p style="color: blue; font-weight: bold; margin-bottom: 1rem;">Total: ${count} questions </p>
                <p style="color: blue; font-weight: bold; margin-bottom: 1rem;">Start: ${start}  </p>
            </div>
            <div class="col-4" style="border-right-color: black;">

                <p style="color: blue; font-weight: bold; margin-bottom: 1rem;"> Student : ${sessionScope.user.fullname}</p>

                <p style="color: blue; font-weight: bold; margin-bottom: 1rem;">Exam Code : ${exam.examId} </p>

                <p>
                    <c:if test="${correctNumber!= null}"> <span style="display: none;"  id="countdown"></span> </c:if>
                    <c:if test="${correctNumber== null}"> <span style="font-size: 30px; font-weight: bold; color: blue;" id="countdown"></span> </c:if>
                </p>
            </div>

        </div>
        <div class="row">
            <c:forEach var="a" items="${requestScope.listQ}" varStatus="loop">
                <div class="col-12">
                    <p class="fw-bold mt-5">${loop.index + 1}. ${a.qText}</p>
                    <div>
                        <div class="row">
                            <div class="col-md-6">

                                <label class="box fifth w-100">
                                    <div class="course">
                                        <input  name="option_${a.id}" value="${a.o1}" type="radio">
                                        <span style="margin-left: 10px;" class="subject">A. ${a.o1}</span>
                                    </div>
                                </label>
                            </div>
                            <div class="col-md-6">

                                <label class="box sixth w-100">
                                    <div class="course">
                                        <input type="radio"  name="option_${a.id}" value="${a.o2}"">
                                        <span style="margin-left: 10px;" class="subject"> B. ${a.o2} </span>
                                    </div>
                                </label>
                            </div>
                            <div class="col-md-6">

                                <label class="box seveth w-100">
                                    <div class="course">
                                        <input type="radio" name="option_${a.id}" value="${a.o3}">
                                        <span style="margin-left: 10px;" class="subject"> C. ${a.o3} </span>
                                    </div>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label class="box eighth w-100">
                                    <div class="course">
                                        <input type="radio" name="option_${a.id}"value="${a.o4}" >
                                        <span style="margin-left: 10px;" class="subject">D. ${a.o4}</span>
                                    </div>
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <div class="col-12">
                <div class="d-flex justify-content-center">
                    <input type="checkbox" id="confirm-checkbox"> I want to finish the exam
                </div>
            </div>
            <div class="col-12">
                <div class="d-flex justify-content-center">
                    <input type="submit" id="submit-button" class="btn btn-primary px-4 py-2 fw-bold" value="Submit" disabled>
                </div>
            </div>
        </div>
    </div>
</form>
<script>
    const confirmCheckbox = document.getElementById('confirm-checkbox');
    const submitButton = document.getElementById('submit-button');

    confirmCheckbox.addEventListener('change', (event) => {
        if (event.target.checked) {
            submitButton.disabled = false;
        } else {
            submitButton.disabled = true;
        }
    });

    submitButton.addEventListener('click', (event) => {
        if (!confirmCheckbox.checked) {
            event.preventDefault();
            alert('Please check finish before submit');
        }
    });
</script>

<script>
    function confirmCheck() {
        var result = confirm("Are you sure to submit?");
        if (result) {
            document.querySelector("input[type='submit']").click();
        }
    }
</script>
<script>
    var timeLeft = ${exam.timeLimit*60};
    function countdown() {
        var countdownTimer = document.getElementById("countdown");
        if (timeLeft > 0) {
            var minutes = Math.floor(timeLeft / 60);
            var seconds = timeLeft % 60;
            countdownTimer.innerHTML = minutes + " : " + seconds + "";
            timeLeft--;
        } else {
            countdownTimer.innerHTML = "Timeout!";
            submitBtn.click();
            return;
        }
    }
    setInterval(countdown, 1000);
</script>
</body>
</html>