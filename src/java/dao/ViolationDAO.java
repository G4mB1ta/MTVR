package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Violation;

// -- Tạo bảng Violations
// CREATE TABLE Violations (
//     ViolationID INT PRIMARY KEY IDENTITY(1,1),
//     ReportID INT NOT NULL,
//     PlateNumber NVARCHAR(15) NOT NULL,
//     ViolatorID INT NOT NULL,
//     FineAmount DECIMAL(10,2) NOT NULL,
//     FineDate DATETIME DEFAULT GETDATE(),
//     PaidStatus BIT DEFAULT 0,
//     FOREIGN KEY (ReportID) REFERENCES Reports(ReportID),
//     FOREIGN KEY (PlateNumber) REFERENCES Vehicles(PlateNumber),
//     FOREIGN KEY (ViolatorID) REFERENCES Users(UserID)
// );

public class ViolationDAO {
    public static ArrayList<Violation> getViolations() {
        DBContext db = DBContext.getInstance();
        ArrayList<Violation> violations = new ArrayList<>(); 
        try {
            String query = "SELECT * FROM Violations";
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Violation violation = new Violation();
                violation.setViolationId(rs.getInt("ViolationID"));
                violation.setReportId(rs.getInt("ReportID"));
                violation.setPlateNumber(rs.getString("PlateNumber"));
                violation.setViolatorId(rs.getInt("ViolatorID"));
                violation.setFineAmount(rs.getDouble("FineAmount"));
                violation.setFineDate(rs.getTimestamp("FineDate"));
                violation.setPaidStatus(rs.getBoolean("PaidStatus"));
                violations.add(violation);
            }
        } catch (Exception e) {
            return null;
        }
        if (violations.isEmpty()) {
            return null;
        }
        return violations;
    }
    
    public static Violation getViolationById(int id) {  
        DBContext db = DBContext.getInstance();
        ArrayList<Violation> violations = new ArrayList<>();
        try {
            String query = "SELECT * FROM Violations WHERE ViolationID = ?";
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Violation violation = new Violation();
                violation.setViolationId(rs.getInt("ViolationID"));
                violation.setReportId(rs.getInt("ReportID"));
                violation.setPlateNumber(rs.getString("PlateNumber"));
                violation.setViolatorId(rs.getInt("ViolatorID"));
                violation.setFineAmount(rs.getDouble("FineAmount"));
                violation.setFineDate(rs.getTimestamp("FineDate"));
                violation.setPaidStatus(rs.getBoolean("PaidStatus"));
                violations.add(violation);
            }
        } catch (Exception e) {
            return null;
        }
        if (violations.isEmpty()) {
            return null;
        }
        return violations.get(0);
    }
    
    public static Violation addViolation(Violation violation) {
        DBContext db = DBContext.getInstance();
        try {
            String query = """
                           INSERT INTO Violations (ReportID, PlateNumber, ViolatorID, FineAmount, FineDate, PaidStatus)
                           VALUES (?, ?, ?, ?, ?, ?)
                           """;
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setInt(1, violation.getReportId());
            statement.setString(2, violation.getPlateNumber());
            statement.setInt(3, violation.getViolatorId());
            statement.setDouble(4, violation.getFineAmount());
            statement.setString(5, violation.getFineDate().toString());
            statement.setBoolean(6, violation.isPaidStatus());
            statement.executeUpdate();
            return violation;
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Violation updateViolation(Violation violation) {
        DBContext db = DBContext.getInstance();
        int rs = 0;
        try {
            String query = """
                           UPDATE Violations
                           SET ReportID = ?, PlateNumber = ?, ViolatorID = ?, FineAmount = ?, FineDate = ?, PaidStatus = ?
                           WHERE ViolationID = ?
                           """;
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setInt(1, violation.getReportId());
            statement.setString(2, violation.getPlateNumber());
            statement.setInt(3, violation.getViolatorId());
            statement.setDouble(4, violation.getFineAmount());
            statement.setString(5, violation.getFineDate().toString());
            statement.setBoolean(6, violation.isPaidStatus());
            statement.setInt(7, violation.getViolationId());
            rs = statement.executeUpdate();
            return violation;
        } catch (Exception e) {
            return null;
        } 
        if (rs == 0) {
            return null;
        }
        return violation;
    }
    
    public static Violation deleteViolation(Violation violation) {
        DBContext db = DBContext.getInstance();
        int rs = 0;
        try {
            String query = "DELETE FROM Violations WHERE ViolationID = ?";
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setInt(1, violation.getViolationId());
            rs = statement.executeUpdate();
        } catch (Exception e) {
            return null;
        }
        if (rs == 0) {
            return null;
        }
        return violation;
    }
}
