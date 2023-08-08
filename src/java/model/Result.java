/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author chi
 */
public class Result {
    private int id;
    private String userId;
    private User user;
    private String examId;
    private Exam exam;
    private int score;
    private String start;
    private String end;

    public Result() {
    }

    public Result(String userId, String examId, int score, String start, String end) {
        this.userId = userId;
        this.examId = examId;
        this.score = score;
        this.start = start;
        this.end = end;
    }

    public Result(String userId, User user, String examId, Exam exam, int score, String start, String end) {
        this.userId = userId;
        this.user = user;
        this.examId = examId;
        this.exam = exam;
        this.score = score;
        this.start = start;
        this.end = end;
    }

    public Result(int id, String userId, User user, String examId, Exam exam, int score, String start, String end) {
        this.id = id;
        this.userId = userId;
        this.user = user;
        this.examId = examId;
        this.exam = exam;
        this.score = score;
        this.start = start;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
    
    
}
