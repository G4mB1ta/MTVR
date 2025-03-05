package model;

import java.util.Date;

/**
 *
 * @author kminh
 */
public class Violation {
    private int violationId;
    private int reportId;
    private String plateNumber;
    private int violatorId;
    private double fineAmount;
    private Date fineDate;
    private boolean paidStatus;

    public Violation() {
    }

    public Violation(int violationId, int reportId, String plateNumber, int violatorId, double fineAmount, Date fineDate, boolean paidStatus) {
        this.violationId = violationId;
        this.reportId = reportId;
        this.plateNumber = plateNumber;
        this.violatorId = violatorId;
        this.fineAmount = fineAmount;
        this.fineDate = fineDate;
        this.paidStatus = paidStatus;
    }

    public int getViolationId() {
        return violationId;
    }

    public void setViolationId(int violationId) {
        this.violationId = violationId;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getViolatorId() {
        return violatorId;
    }

    public void setViolatorId(int violatorId) {
        this.violatorId = violatorId;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public Date getFineDate() {
        return fineDate;
    }

    public void setFineDate(Date fineDate) {
        this.fineDate = fineDate;
    }

    public boolean isPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(boolean paidStatus) {
        this.paidStatus = paidStatus;
    }
    
}
