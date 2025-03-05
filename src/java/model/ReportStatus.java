package model;

/**
 *
 * @author kminh
 */
public class ReportStatus {
    private int statusId;
    private String statusName;

    public ReportStatus() {
    }

    public ReportStatus(int statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
