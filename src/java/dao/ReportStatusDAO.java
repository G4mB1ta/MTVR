package dao;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.ReportStatus;

// -- Tạo bảng ReportStatus
// CREATE TABLE ReportStatus (
//     StatusID INT PRIMARY KEY IDENTITY(1,1),
//     StatusName NVARCHAR(20) NOT NULL UNIQUE
// );

// -- Thêm dữ liệu mẫu vào bảng ReportStatus
// INSERT INTO ReportStatus (StatusName)
// VALUES 
// (N'Pending'),
// (N'Approved'),
// (N'Rejected');
public class ReportStatusDAO {
    
    public static ArrayList<ReportStatus> getReportStatus() {
        DBContext db = DBContext.getInstance();
        ArrayList<ReportStatus> reportStatuses = new ArrayList<>();
        try {
            String query = "SELECT * FROM ReportStatus";
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int statusId = rs.getInt("StatusID");
                String statusName = rs.getString("StatusName");
                ReportStatus reportStatus = new ReportStatus(statusId, statusName);
                reportStatuses.add(reportStatus);
            }
        } catch (Exception e) {
            return null;
        }
        if (reportStatuses.isEmpty()) {
            return null;
        }
        return reportStatuses;
    }
    
    public static ReportStatus getReportStatusById(ReportStatus reportStatus) {
        DBContext db = DBContext.getInstance();
        ArrayList<ReportStatus> reportStatuses = new ArrayList<>();
        try {
            String query = "SELECT * FROM ReportStatus WHERE StatusID = ?";
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setInt(1, reportStatus.getStatusId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int statusId = rs.getInt("StatusID");
                String statusName = rs.getString("StatusName");
                ReportStatus r = new ReportStatus(statusId, statusName);
                reportStatuses.add(r);
            }
        } catch (Exception e) {
            return null;
        }
        if (reportStatuses.isEmpty()) {
            return null;
        }
        return reportStatuses.get(0);
    }
}
