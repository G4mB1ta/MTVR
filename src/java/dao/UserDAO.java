package dao;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author kminh
 */
public class UserDAO {

    /**
     * Return list of user data
     * 
     * @return an array list contains users data.
     */
    public static ArrayList<User> getUsers() {
        DBContext db = DBContext.getInstance();
        ArrayList<User> users = new ArrayList<>();
        
        try {
            String sql = """
                         SELECT * FROM Users
                         """;
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("UserId"));
                user.setFullName(rs.getString("FullName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setRoleId(rs.getInt("RoleId"));
                user.setPhone(rs.getString("Phone"));
                user.setAddress(rs.getString("Address"));
                users.add(user);
            }
        } catch (SQLException e) {
            return null;
        }
        if (users.isEmpty()) {
            return null;
        } else {
            return users;
        }
        
    }
    
    public static User getUserById(int userId) {
        return null;
    }
    
    public static ArrayList<User> getUsersByRoleId(int roleId) {
        return null;
    }
    
    public static User addUser(User user) {
        return null;
    }
    
    public static User updateUser(User user) {
        return user;
    }
    
    public static User deleteUser(User user) {
        return null;
    }
}
