package dao;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;

// -- Tạo bảng Users
// CREATE TABLE Users (
//     UserID INT PRIMARY KEY IDENTITY(1,1),
//     FullName NVARCHAR(100) NOT NULL,
//     Email NVARCHAR(100) NOT NULL UNIQUE,
//     Password NVARCHAR(255) NOT NULL,
//     RoleID INT NOT NULL,
//     Phone NVARCHAR(15) NOT NULL UNIQUE,
//     Address NVARCHAR(MAX),
//     FOREIGN KEY (RoleID) REFERENCES Roles(RoleID)
// );
public class UserDAO {

    /**
     * Return list of user data.
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
        DBContext db = DBContext.getInstance();
        ArrayList<User> users = new ArrayList<>();

        try {
            String sql = """
                         SELECT * FROM Users WHERE UserID = ?
                         """;
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            statement.setInt(1, userId);
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
            return users.get(0);
        }
    }

    public static ArrayList<User> getUsersByRoleId(int roleId) {
        DBContext db = DBContext.getInstance();
        ArrayList<User> users = new ArrayList<>();

        try {
            String sql = """
                         SELECT * FROM Users Where RoleID = ?
                         """;
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            statement.setInt(1, roleId);
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

    public static User addUser(User user) {
        DBContext db = DBContext.getInstance();
        int rs = 0;
        try {
            String sql = """
                         INSERT INTO Users (FullName, Email, Password, RoleID, Phone, Address) 
                         VALUES 
                         (?, ?, ?, ?, ?, ?)
                         """;
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRoleId());
            statement.setString(5, user.getPhone());
            statement.setString(6, user.getAddress());
            rs = statement.executeUpdate();

        } catch (SQLException e) {
            return null;
        }
        if (rs == 0) {
            return null;
        } else {
            return user;
        }
    }

    public static User updateUser(User user) {
        DBContext db = DBContext.getInstance();
        int rs = 0;
        try {
            String sql = """
                         UPDATE Users
                         SET FullName = ?, Email = ?, Password = ?, RoleID = ?, Phone = ?, Address = ?
                         WHERE UserID = ?
                         """;
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRoleId());
            statement.setString(5, user.getPhone());
            statement.setString(6, user.getAddress());
            statement.setInt(7, user.getUserId());
            rs = statement.executeUpdate();
        } catch (SQLException e) {
            return null;
        }
        if (rs == 0) {
            return null;
        } else {
            return user;
        }
    }

    public static User deleteUser(User user) {
        DBContext db = DBContext.getInstance();
        int rs = 0;
        try {
            String sql = """
                         DELETE FROM Users WHERE UserID = ?
                         """;
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            statement.setInt(1, user.getUserId());
            rs = statement.executeUpdate();
        } catch (SQLException e) {
            return null;
        }
        if (rs != 0) {
            return user;
        } else {
            return null;
        }
        
    }
}
