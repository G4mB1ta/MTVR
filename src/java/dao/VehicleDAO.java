package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Vehicle;

// -- Tạo bảng Vehicles
// CREATE TABLE Vehicles (
//     VehicleID INT PRIMARY KEY IDENTITY(1,1),
//     PlateNumber NVARCHAR(15) NOT NULL UNIQUE,
//     OwnerID INT NOT NULL,
//     Brand NVARCHAR(50),
//     Model NVARCHAR(50),
//     ManufactureYear INT CHECK (ManufactureYear BETWEEN 1500 AND YEAR(GETDATE())),
//     FOREIGN KEY (OwnerID) REFERENCES Users(UserID)
// );
public class VehicleDAO {

    public static ArrayList<Vehicle> getVehicles() {
        DBContext db = DBContext.getInstance();
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try {
            String query = "SELECT * FROM Vehicles";
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(rs.getInt("VehicleID"));
                vehicle.setPlateNumber(rs.getString("PlateNumber"));
                vehicle.setOwnerId(rs.getInt("OwnerID"));
                vehicle.setBrand(rs.getString("Brand"));
                vehicle.setModel(rs.getString("Model"));
                vehicle.setManufactureYear(rs.getInt("ManufactureYear"));
                vehicles.add(vehicle);
            }

        } catch (Exception e) {
            return null;
        }

        if (vehicles.isEmpty()) {
            return null;
        }
        return vehicles;
    }

    public static Vehicle getVehicleById(int vId) {
        DBContext db = DBContext.getInstance();
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try {
            String query = "SELECT * FROM Vehicles WHERE VehicleID = ?";
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setInt(1, vId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(rs.getInt("VehicleID"));
                vehicle.setPlateNumber(rs.getString("PlateNumber"));
                vehicle.setOwnerId(rs.getInt("OwnerID"));
                vehicle.setBrand(rs.getString("Brand"));
                vehicle.setModel(rs.getString("Model"));
                vehicle.setManufactureYear(rs.getInt("ManufactureYear"));
                vehicles.add(vehicle);
            }

        } catch (Exception e) {
            return null;
        }

        if (vehicles.isEmpty()) {
            return null;
        }
        return vehicles.get(0);
    }

    public static ArrayList<Vehicle> getVehiclesByOwnerId(int ownerId) {
        DBContext db = DBContext.getInstance();
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try {
            String query = "SELECT * FROM Vehicles WHERE OwnerID = ?";
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setInt(1, ownerId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(rs.getInt("VehicleID"));
                vehicle.setPlateNumber(rs.getString("PlateNumber"));
                vehicle.setOwnerId(rs.getInt("OwnerID"));
                vehicle.setBrand(rs.getString("Brand"));
                vehicle.setModel(rs.getString("Model"));
                vehicle.setManufactureYear(rs.getInt("ManufactureYear"));
                vehicles.add(vehicle);
            }

        } catch (Exception e) {
            return null;
        }

        if (vehicles.isEmpty()) {
            return null;
        }
        return vehicles;
    }

    public static Vehicle getVehicleByPlateNumber(String plateNumber) {
        DBContext db = DBContext.getInstance();
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try {
            String query = "SELECT * FROM Vehicles WHERE PlateNumber = ?";
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setString(1, plateNumber);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(rs.getInt("VehicleID"));
                vehicle.setPlateNumber(rs.getString("PlateNumber"));
                vehicle.setOwnerId(rs.getInt("OwnerID"));
                vehicle.setBrand(rs.getString("Brand"));
                vehicle.setModel(rs.getString("Model"));
                vehicle.setManufactureYear(rs.getInt("ManufactureYear"));
                vehicles.add(vehicle);
            }

        } catch (Exception e) {
            return null;
        }

        if (vehicles.isEmpty()) {
            return null;
        }
        return vehicles.get(0);
    }

    public static Vehicle addVehicle(Vehicle vehicle) {
        DBContext db = DBContext.getInstance();

        try {
            String query = "INSERT INTO Vehicles (PlateNumber, OwnerID, Brand, Model, ManufactureYear) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setString(1, vehicle.getPlateNumber());
            statement.setInt(2, vehicle.getOwnerId());
            statement.setString(3, vehicle.getBrand());
            statement.setString(4, vehicle.getModel());
            statement.setInt(5, vehicle.getManufactureYear());
            statement.executeUpdate();
        } catch (Exception e) {
            return null;
        }

        return getVehicleByPlateNumber(vehicle.getPlateNumber());
    }

    public static Vehicle updateVehicle(Vehicle vehicle) {
        DBContext db = DBContext.getInstance();
        int rs = 0;
        try {
            String query = "UPDATE Vehicles SET PlateNumber = ?, OwnerID = ?, Brand = ?, Model = ?, ManufactureYear = ? WHERE VehicleID = ?";
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setString(1, vehicle.getPlateNumber());
            statement.setInt(2, vehicle.getOwnerId());
            statement.setString(3, vehicle.getBrand());
            statement.setString(4, vehicle.getModel());
            statement.setInt(5, vehicle.getManufactureYear());
            rs = statement.executeUpdate();
        } catch (Exception e) {
            return null;
        }
        if (rs == 0) {
            return null;
        }
        return vehicle;
    }

    public static Vehicle deleteVehicle(Vehicle vehicle) {
        DBContext db = DBContext.getInstance();
        int rs = 0;
        try {
            String query = "DELETE FROM Vehicles WHERE VehicleID = ?";
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setInt(1, vehicle.getVehicleId());
            rs = statement.executeUpdate();

        } catch (Exception e) {
            return null;
        }
        if (rs == 0) {
            return null;
        }
        return vehicle;
    }
}
