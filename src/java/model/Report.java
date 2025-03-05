package model;

import java.util.Date;

/**
 *
 * @author kminh
 */
public class Report {
    private int reportId;
    private int reporterId;
    private String violationType;
    private String description;
    private String plateNumber;
    private String imageỦrl;
    private String videoỦrl;
    private String location;
    private Date date;
    private int statusId;
    private int processedBy;

    public Report() {
    }

    public Report(int reportId, int reporterId, String violationType, String description, String plateNumber, String imageỦrl, String videoỦrl, String location, Date date, int statusId, int processedBy) {
        this.reportId = reportId;
        this.reporterId = reporterId;
        this.violationType = violationType;
        this.description = description;
        this.plateNumber = plateNumber;
        this.imageỦrl = imageỦrl;
        this.videoỦrl = videoỦrl;
        this.location = location;
        this.date = date;
        this.statusId = statusId;
        this.processedBy = processedBy;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getReporterId() {
        return reporterId;
    }

    public void setReporterId(int reporterId) {
        this.reporterId = reporterId;
    }

    public String getViolationType() {
        return violationType;
    }

    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getImageỦrl() {
        return imageỦrl;
    }

    public void setImageỦrl(String imageỦrl) {
        this.imageỦrl = imageỦrl;
    }

    public String getVideoỦrl() {
        return videoỦrl;
    }

    public void setVideoỦrl(String videoỦrl) {
        this.videoỦrl = videoỦrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(int processedBy) {
        this.processedBy = processedBy;
    }
    
}
