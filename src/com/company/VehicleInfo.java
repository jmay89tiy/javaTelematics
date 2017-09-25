package com.company;

public class VehicleInfo {

    //more control over fields, when set to private.

    private String vin;
    private double odometerMilesTraveled;
    private double consumption;
    private double odometerInitialMiles;
    private double engineSize;

    @Override
    public String toString() {
        return "VIN = " + this.vin +
                "\nOdometer Miles Traveled = " + this.odometerMilesTraveled +
                "\nConsumption = " + this.consumption +
                "\nOdometer Initial Miles = " + this.odometerInitialMiles +
                "\nEngine Size = " + this.engineSize;
    }

    //====================================================================================
    //Getters
    //====================================================================================
    public String getVin() {
        return vin;
    }

    public Double getOdometerMilesTraveled() {
        return odometerMilesTraveled;
    }

    public Double getConsumption() {
        return consumption;
    }

    public Double getOdometerInitialMiles() {
        return odometerInitialMiles;
    }

    public Double getEngineSize() {
        return engineSize;
    }

    //=====================================================================================
    //Setters
    //=====================================================================================

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setOdometerMilesTraveled(Double odometerMilesTraveled) {
        this.odometerMilesTraveled = odometerMilesTraveled;
    }

    public void setConsumption(Double consumption) {
        this.consumption = consumption;
    }

    public void setOdometerInitialMiles(Double odometerInitialMiles) {
        this.odometerInitialMiles = odometerInitialMiles;
    }

    public void setEngineSize(Double engineSize) {
        this.engineSize = engineSize;
    }
    //====================================================================================
    //JavaBean aka Pojo below
    //====================================================================================

    public VehicleInfo() { }
}
