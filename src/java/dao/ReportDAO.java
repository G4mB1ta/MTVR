package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Report;

// -- Tạo bảng Reports
// CREATE TABLE Reports (
//     ReportID INT PRIMARY KEY IDENTITY(1,1),
//     ReporterID INT NOT NULL,
//     ViolationType NVARCHAR(50) NOT NULL,
//     Description NVARCHAR(MAX) NOT NULL,
//     PlateNumber NVARCHAR(15) NOT NULL,
//     ImageURL NVARCHAR(MAX),
//     VideoURL NVARCHAR(MAX),
//     Location NVARCHAR(255) NOT NULL,
//     ReportDate DATETIME DEFAULT GETDATE(),
//     StatusID INT NOT NULL DEFAULT 1,  -- Thay thế Status bằng StatusID
//     ProcessedBy INT,
//     FOREIGN KEY (ReporterID) REFERENCES Users(UserID),
//     FOREIGN KEY (ProcessedBy) REFERENCES Users(UserID),
//     FOREIGN KEY (PlateNumber) REFERENCES Vehicles(PlateNumber),
//     FOREIGN KEY (StatusID) REFERENCES ReportStatus(StatusID)  -- Thêm khóa ngoại tham chiếu đến ReportStatus
// );

public class ReportDAO {
    public static ArrayList<Report> getReports() {
        DBContext db = DBContext.getInstance();
        ArrayList<Report> reports = new ArrayList<>();
        try {
            String query = "SELECT * FROM Reports";
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Report report = new Report();
                report.setReportId(rs.getInt("ReportID"));
                report.setReporterId(rs.getInt("ReporterID"));
                report.setViolationType(rs.getString("ViolationType"));
                report.setDescription(rs.getString("Description"));
                report.setPlateNumber(rs.getString("PlateNumber"));
                report.setImageURL(rs.getString("ImageURL"));
                report.setVideoURL(rs.getString("VideoURL"));
                report.setLocation(rs.getString("Location"));
                report.setReportDate(rs.getTimestamp("ReportDate"));
                report.setStatusId(rs.getInt("StatusID"));
                report.setProcessedBy(rs.getInt("ProcessedBy"));
                reports.add(report);
            }
        } catch (Exception e) {
            return null;
        }
        if (reports.isEmpty()) {
            return null;
        }
        return reports;
    }
    
    public static ArrayList<Report> getReportsByProcessorId(int processorId) {
        return null;
    }
    
    public static ArrayList<Report> getReportsByPlateNumber(String plateNumber) {
        return null;
    }
    
    public static ArrayList<Report> getReportsByStatusId(int statusId) {
        return null;
    }
    
    public static Report getReportById(int id) {
        return null;
    }
    
    public static Report addReport(Report report) {
        return null;
    }
    
    public static Report updateReport(Report report) {
        return null;
    }
    
    public static Report deleteReport(Report report) {
        return null;
    }
}
