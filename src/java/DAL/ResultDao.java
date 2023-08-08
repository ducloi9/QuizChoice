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
import model.Result;

/**
 *
 * @author chi
 */
public class ResultDao extends BaseDAO<Result> {

    public void insertResult(Result s) {
        try {
            String sql = "INSERT INTO [dbo].[Results]\n"
                    + "           ([user_id]\n"
                    + "           ,[exam_id]\n"
                    + "           ,[score]\n"
                    + "           ,[start_time]\n"
                    + "           ,[end_time])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, s.getUserId());
            statement.setString(2, s.getExamId());
            statement.setInt(3, s.getScore());
            statement.setString(4, s.getStart());
            statement.setString(5, s.getEnd());
            statement.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    ExamDao dao = new ExamDao();
    public List<Result> getAllResultByUserId(String userId) {
        List<Result> list = new ArrayList<>();
        try {
            String sql = "SELECT *FROM Results where user_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Result r = new Result();
                r.setUserId(rs.getString(2));
                r.setExamId(rs.getString(3));
                r.setScore(rs.getInt(4));
                r.setStart(rs.getString(5));
                r.setEnd(rs.getString(6));
                r.setExam(dao.getExamById(r.getExamId()));
                list.add(r);
            }
        } catch (SQLException e) {
        }
        return list;

    }
    public static void main(String[] args) {
        ResultDao d = new ResultDao();
        //d.insertResult( new Result("2", "PRJ301_FE_2023_1",2, "2023-03-23 20:49:13", "2023-03-23 20:55:13"));
        List<Result> list = d.getAllResultByUserId("2");
        for (Result result : list) {
            System.out.println(result);
            
        }
    }

}
