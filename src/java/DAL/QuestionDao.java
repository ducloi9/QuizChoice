package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Exam;
import model.Question;
import model.User;

public class QuestionDao extends BaseDAO<Question> {

    public UserDao userDao = new UserDao();
    public ExamDao examDao = new ExamDao();

    public List<Question> getAllQuestionByExamId(String examId) {
        List<Question> list = new ArrayList<>();
        try {
            String sql = "SELECT *FROM Questions where exam_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, examId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Question r = new Question();
                r.setId(rs.getInt(1));
                r.setExamId(rs.getString(2));
                r.setqText(rs.getString(3));
                r.setO1(rs.getString(4));
                r.setO2(rs.getString(5));
                r.setO3(rs.getString(6));
                r.setO4(rs.getString(7));
                r.setCorrectAns(rs.getString(8));
                Exam exam = examDao.getExamById(r.getExamId());
                r.setExam(exam);
                list.add(r);
            }
        } catch (Exception e) {
        }
        return list;

    }

    public List<String> getCorrectAnswerByExamId(String examId) {
        List<String> list = new ArrayList<>();
        try {
            String sql = "SELECT [correct]\n"
                    + "  FROM [Eos].[dbo].[Questions]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String r = rs.getString(1);
                list.add(r);
            }
        } catch (Exception e) {
        }
        return list;

    }

    public static void main(String[] args) {
        QuestionDao qDao = new QuestionDao();
        for (Question question : qDao.getAllQuestionByExamId("PRJ301_FE_2023_1")) {
            System.out.println(question);
        }
    }

}
