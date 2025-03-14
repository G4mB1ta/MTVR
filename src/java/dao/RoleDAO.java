package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Role;

// -- Tạo bảng Roles
// CREATE TABLE Roles (
//     RoleID INT PRIMARY KEY IDENTITY(1,1),
//     RoleName NVARCHAR(20) NOT NULL UNIQUE
// );
// -- Thêm dữ liệu mẫu vào bảng Roles
// INSERT INTO Roles (RoleName)
// VALUES 
// (N'Citizen'),
// (N'TrafficPolice'),
// (N'Administrator');
public class RoleDAO {

    public static ArrayList<Role> getRoles() {
        DBContext db = DBContext.getInstance();
        ArrayList<Role> roles = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Roles";
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int roleId = rs.getInt("RoleID");
                String roleName = rs.getString("RoleName");
                Role role = new Role(roleId, roleName);
                roles.add(role);
            }
        } catch (SQLException e) {
            return null;
        }
        if (roles.isEmpty()) {
            return null;
        } else {
            return roles;
        }
    }

    public static Role getRoleById(int roleId) {
        DBContext db = DBContext.getInstance();
        ArrayList<Role> roles = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Roles WHERE RoleID = ?";
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            statement.setInt(1, roleId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("RoleID");
                String roleName = rs.getString("RoleName");
                Role role = new Role(id, roleName);
                roles.add(role);
            }
        } catch (SQLException e) {
            return null;
        }
        if (roles.isEmpty()) {
            return null;
        } else {
            return roles.get(0);
        }
    }
}
