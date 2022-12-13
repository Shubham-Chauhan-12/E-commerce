package com.vehicleservice.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class VehiclesData {

    @Id
    private int vehicleId;
    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleVariant;
    private String vehicleColor;
    private int manufactureYear;
    private long price;
    private String emailOfAdmin;
    private String passwordOfAdmin;

    public VehiclesData() {
    }

    public VehiclesData(int vehicleId, String vehicleBrand, String vehicleModel, String vehicleVariant, String vehicleColor, int manufactureYear, long price, String emailOfAdmin, String passwordOfAdmin) {
        this.vehicleId = vehicleId;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.vehicleVariant = vehicleVariant;
        this.vehicleColor = vehicleColor;
        this.manufactureYear = manufactureYear;
        this.price = price;
        this.emailOfAdmin = emailOfAdmin;
        this.passwordOfAdmin = passwordOfAdmin;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleVariant() {
        return vehicleVariant;
    }

    public void setVehicleVariant(String vehicleVariant) {
        this.vehicleVariant = vehicleVariant;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getEmailOfAdmin() {
        return emailOfAdmin;
    }

    public void setEmailOfAdmin(String emailOfAdmin) {
        this.emailOfAdmin = emailOfAdmin;
    }

    public String getPasswordOfAdmin() {
        return passwordOfAdmin;
    }

    public void setPasswordOfAdmin(String passwordOfAdmin) {
        this.passwordOfAdmin = passwordOfAdmin;
    }

    @Override
    public String toString() {
        return "VehiclesData{" +
                "vehicleId=" + vehicleId +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleVariant='" + vehicleVariant + '\'' +
                ", vehicleColor='" + vehicleColor + '\'' +
                ", manufactureYear=" + manufactureYear +
                ", price=" + price +
                ", emailOfAdmin='" + emailOfAdmin + '\'' +
                ", passwordOfAdmin='" + passwordOfAdmin + '\'' +
                '}';
    }
}
