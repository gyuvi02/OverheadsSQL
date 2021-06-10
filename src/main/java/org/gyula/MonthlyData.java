package org.gyula;

import java.sql.Date;

public class MonthlyData {
    private String address;
    private String subtenant;
    private double rent;
    private double commonCosts;
    private double baseFeeGas;
    private double baseFeeElectricity;
    private double gasLast;
    private double gasPresent;
    private java.sql.Date gasLastDate;
    private double electricityLast;
    private double electrictiyPresent;
    private java.sql.Date electricityLastDate;
    private double gasCostPerUnit;
    private double electricityCostPerUnit;

    public MonthlyData(String address, String subtenant, double rent, double commonCosts, double baseFeeGas, double baseFeeElectricity,
                       double gasLast, java.sql.Date gasLastDate, double electricityLast, Date electricityLastDate,
                       double gasCostPerUnit, double electricityCostPerUnit) {
        this.address = address;
        this.subtenant = subtenant;
        this.rent = rent;
        this.commonCosts = commonCosts;
        this.baseFeeGas = baseFeeGas;
        this.baseFeeElectricity = baseFeeElectricity;
        this.gasLast = gasLast;
        this.gasPresent = 0.0;
        this.gasLastDate = gasLastDate;
        this.electricityLast = electricityLast;
        this.electrictiyPresent = 0.0;
        this.electricityLastDate = electricityLastDate;
        this.gasCostPerUnit = gasCostPerUnit;
        this.electricityCostPerUnit = electricityCostPerUnit;
    }

    public String getAddress() {
        return address;
    }

    public String getSubtenant() {
        return subtenant;
    }

    public double getRent() {
        return rent;
    }

    public double getCommonCosts() {
        return commonCosts;
    }

    public double getBaseFeeGas() {
        return baseFeeGas;
    }

    public double getBaseFeeElectricity() {
        return baseFeeElectricity;
    }

    public double getGasLast() {
        return gasLast;
    }

    public double getGasPresent() {
        return gasPresent;
    }

    public Date getGasLastDate() {
        return gasLastDate;
    }

    public double getElectricityLast() {
        return electricityLast;
    }

    public double getElectrictiyPresent() {
        return electrictiyPresent;
    }

    public Date getElectricityLastDate() {
        return electricityLastDate;
    }

    public double getGasCostPerUnit() {
        return gasCostPerUnit;
    }

    public double getElectricityCostPerUnit() {
        return electricityCostPerUnit;
    }
}
