package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class UserDao extends BaseDAO<User>{
    public User getAccountByUsernameAndPassword(String user, String pass) {
        try {
            String sql = "SELECT *FROM Users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user);
            statement.setString(2, pass);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User a = new User();
                 a.setId(rs.getString(1));
                a.setUsername(rs.getString(2));
                a.setPassword(rs.getString(3));
                a.setFullname(rs.getString(4));
                return a;
            }
        } catch (Exception e) {
        }
        return null;

    }
    public User checkAccountExist(String user) {
        try {
            String sql = "SELECT *FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User a = new User();
                a.setUsername(rs.getString(1));
                a.setPassword(rs.getString(2));
                a.setFullname(rs.getString(3));
                return a;
            }
        } catch (Exception e) {
        }
        return null;

    }
    public User getUserById(String username) {
        try {
            String sql = "SELECT *FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User a = new User();
               a.setUsername(rs.getString(1));
                a.setPassword(rs.getString(2));
                a.setFullname(rs.getString(3));

                return a;
            }
        } catch (Exception e) {
        }
        return null;

    }
    public static void main(String[] args) {
        UserDao d = new UserDao();
        User u = d.getAccountByUsernameAndPassword("dangducloi", "123");
        System.out.println(u);
    }
    
}
