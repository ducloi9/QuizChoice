/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Exam;
import model.User;

/**
 *
 * @author chi
 */
public class ExamDao extends BaseDAO<Exam> {
    public Exam getExamById(String id) {
        try {
            String sql = "SELECT *FROM Exams WHERE [exam_id] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Exam r = new Exam();
                r.setExamId(rs.getString(1));
                r.setName(rs.getString(2));
                r.setSubject(rs.getString(3));
                r.setTimeLimit(rs.getString(4));
                r.setImage(rs.getString(5));
                return r;
            }
        } catch (Exception e) {
        }
        return null;

    }
    public List<Exam> getAllExam() {
        List<Exam> list = new ArrayList<>();
        try {
            String sql = "SELECT *FROM Exams";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Exam r = new Exam();
                r.setExamId(rs.getString(1));
                r.setName(rs.getString(2));
                r.setSubject(rs.getString(3));
                r.setTimeLimit(rs.getString(4));
                r.setImage(rs.getString(5));
                list.add(r);
            }
        } catch (SQLException e) {
        }
        return list;

    }
    public static void main(String[] args) {
        ExamDao d = new ExamDao();
       List<Exam> list = d.getAllExam();
        for (Exam exam : list) {
            System.out.println(exam);
        }
    }
}
