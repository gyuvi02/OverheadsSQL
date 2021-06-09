package org.gyula;

public class MonthlyData {
    private String address;
    private String subtenant;
    private double rent;
    private double commonCosts;
    private double baseFeeGas;
    private double baseFeeElectricity;
    private double gasLast;
    private double gasPresent;
    private double electricityLast;
    private double electrictiyPresent;


    public MonthlyData(String address, String subtenant, double rent, double commonCosts, double baseFeeGas, double baseFeeElectricity,
                       double gasLast, double gasPresent, double electricityLast, double electrictiyPresent) {
        this.address = address;
        this.subtenant = subtenant;
        this.rent = rent;
        this.commonCosts = commonCosts;
        this.baseFeeGas = baseFeeGas;
        this.baseFeeElectricity = baseFeeElectricity;
        this.gasLast = gasLast;
        this.gasPresent = 0.0;
        this.electricityLast = electricityLast;
        this.electrictiyPresent = 0.0;
    }
}
