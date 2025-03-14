package dao;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import model.Notification;

// -- Tạo bảng Notifications
// CREATE TABLE Notifications (
//     NotificationID INT PRIMARY KEY IDENTITY(1,1),
//     UserID INT NOT NULL,
//     Message NVARCHAR(MAX) NOT NULL,
//     PlateNumber NVARCHAR(15),
//     SentDate DATETIME DEFAULT GETDATE(),
//     IsRead BIT DEFAULT 0,
//     FOREIGN KEY (UserID) REFERENCES Users(UserID),
//     FOREIGN KEY (PlateNumber) REFERENCES Vehicles(PlateNumber)
// );
public class NotificationDAO {

    public static ArrayList<Notification> getNotifications() {
        DBContext db = DBContext.getInstance();
        ArrayList<Notification> notifications = new ArrayList<>();
        try {
            String query = "SELECT * FROM Notifications";
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Notification notification = new Notification();
                notification.setNotificationId(rs.getInt("NotificationID"));
                notification.setUserId(rs.getInt("UserID"));
                notification.setMessage(rs.getString("Message"));
                notification.setPlateNumber(rs.getString("PlateNumber"));
                notification.setSentDate(rs.getTimestamp("SentDate"));
                notification.setIsRead(rs.getBoolean("IsRead"));
                notifications.add(notification);
            }
        } catch (Exception e) {
            return null;
        }
        if (notifications.isEmpty()) {
            return null;
        }
        return notifications;
    }
    
    public static ArrayList<Notification> getNotificationsByUserId(int userId) {
        DBContext db = DBContext.getInstance();
        ArrayList<Notification> notifications = new ArrayList<>();
        try {
            String query = "SELECT * FROM Notifications WHERE UserID = ?";
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Notification notification = new Notification();
                notification.setNotificationId(rs.getInt("NotificationID"));
                notification.setUserId(rs.getInt("UserID"));
                notification.setMessage(rs.getString("Message"));
                notification.setPlateNumber(rs.getString("PlateNumber"));
                notification.setSentDate(rs.getTimestamp("SentDate"));
                notification.setIsRead(rs.getBoolean("IsRead"));
                notifications.add(notification);
            }
        } catch (Exception e) {
            return null;
        }
        if (notifications.isEmpty()) {
            return null;
        }
        return notifications;
    }
    
    public static Notification getNotificationsById(int notId) {
        DBContext db = DBContext.getInstance();
        ArrayList<Notification> notifications = new ArrayList<>();
        try {
            String query = "SELECT * FROM Notifications WHERE NotificationID = ?";
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setInt(1, notId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Notification notification = new Notification();
                notification.setNotificationId(rs.getInt("NotificationID"));
                notification.setUserId(rs.getInt("UserID"));
                notification.setMessage(rs.getString("Message"));
                notification.setPlateNumber(rs.getString("PlateNumber"));
                notification.setSentDate(rs.getTimestamp("SentDate"));
                notification.setIsRead(rs.getBoolean("IsRead"));
                notifications.add(notification);
            }
        } catch (Exception e) {
            return null;
        }
        if (notifications.isEmpty()) {
            return null;
        }
        return notifications.get(0);
    }
    
    public static Notification addNotification(Notification not) {
        DBContext db = DBContext.getInstance();
        int rs = 0;
        try {
            String query = """ 
                           INSERT INTO Notifications (UserID, Message, PlateNumber, SentDate, IsRead)
                           VALUES (?, ?, ?, GETDATE(), 0)
                           """;
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setInt(1, not.getUserId());
            statement.setString(2, not.getMessage());
            statement.setString(3, not.getPlateNumber());
            rs = statement.executeUpdate();
        } catch (Exception e) {
            return null;
        }
        if (rs == 0) {
            return null;
        } else {
            return not;
        }
    }
    
    public static Notification updateNotification(Notification not) {
        DBContext db = DBContext.getInstance();
        int rs = 0;
        try {
            String query = """
                           UPDATE Notifications 
                           SET UserID = ?, Message = ?, PlateNumber = ?, SentDate = ?, IsRead = ?
                           WHERE NotificationID = ?
                           """;
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setInt(1, not.getNotificationId());
            statement.setInt(2, not.getUserId());
            statement.setString(3, not.getMessage());
            statement.setString(4, not.getPlateNumber());
            statement.setTimestamp(5, new Timestamp(not.getSentDate().getTime()));
            statement.setBoolean(6, not.isIsRead());
            rs = statement.executeUpdate();    
        } catch (Exception e) {
        }
        if (rs == 0) {
            return null;
        } else {
            return not;
        }
    }
    
    public static Notification deleteNotification(Notification not) {
        return null;
    }
    
}
