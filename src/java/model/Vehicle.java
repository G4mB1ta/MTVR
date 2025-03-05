package model;

/**
 *
 * @author kminh
 */
public class Vehicle {
    private int vehicleId;
    private String plateNumber;
    private int ownerId;
    private String brand;
    private String model;
    private int manufacureYear;

    public Vehicle() {
    }

    public Vehicle(int vehicleId, String plateNumber, int ownerId, String brand, String model, int manufacureYear) {
        this.vehicleId = vehicleId;
        this.plateNumber = plateNumber;
        this.ownerId = ownerId;
        this.brand = brand;
        this.model = model;
        this.manufacureYear = manufacureYear;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManufacureYear() {
        return manufacureYear;
    }

    public void setManufacureYear(int manufacureYear) {
        this.manufacureYear = manufacureYear;
    }
}
