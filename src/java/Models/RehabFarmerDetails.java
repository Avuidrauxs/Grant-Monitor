/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author audax
 */
public class RehabFarmerDetails {
    
    
    private String farmerName,
            farmerAddress,
            farmerSex,
            rehNumber;
    
    private int farmerAge;

    public RehabFarmerDetails() {
    }

    public RehabFarmerDetails(String farmerName, String farmerAddress, String farmerSex, String rehNumber, int farmerAge) {
        this.farmerName = farmerName;
        this.farmerAddress = farmerAddress;
        this.farmerSex = farmerSex;
        this.rehNumber = rehNumber;
        this.farmerAge = farmerAge;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFarmerAddress() {
        return farmerAddress;
    }

    public void setFarmerAddress(String farmerAddress) {
        this.farmerAddress = farmerAddress;
    }

    public String getFarmerSex() {
        return farmerSex;
    }

    public void setFarmerSex(String farmerSex) {
        this.farmerSex = farmerSex;
    }

    public String getRehNumber() {
        return rehNumber;
    }

    public void setRehNumber(String rehNumber) {
        this.rehNumber = rehNumber;
    }

    public int getFarmerAge() {
        return farmerAge;
    }

    public void setFarmerAge(int farmerAge) {
        this.farmerAge = farmerAge;
    }
    
    
    
}
