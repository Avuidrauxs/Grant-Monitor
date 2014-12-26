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
public class Farmer {
    
    private String regID;
    private String distID ;
    private String farmerSName;
    private String farmerOName;
    private String Gender;
    private String idType;
    private int farmerAge;
    private String idNumber;
    private String farmNumber;
    private String farmerAddress;

    public Farmer() {
    }

    public Farmer(String regID, String distID, String farmerSName, String farmerOName, String Gender, String idType, int farmerAge, String idNumber, String farmerAddress) {
        this.regID = regID;
        this.distID = distID;
        this.farmerSName = farmerSName;
        this.farmerOName = farmerOName;
        this.Gender = Gender;
        this.idType = idType;
        this.farmerAge = farmerAge;
        this.idNumber = idNumber;
        this.farmerAddress = farmerAddress;
    }

    //Alternatively
    public Farmer(String regID, String distID, String farmerSName, String farmerOName, String Gender, String idType, int farmerAge, String idNumber, String farmNumber, String farmerAddress) {
        this.regID = regID;
        this.distID = distID;
        this.farmerSName = farmerSName;
        this.farmerOName = farmerOName;
        this.Gender = Gender;
        this.idType = idType;
        this.farmerAge = farmerAge;
        this.idNumber = idNumber;
        this.farmNumber = farmNumber;
        this.farmerAddress = farmerAddress;
    }
    
    
    public String getRegID() {
        return regID;
    }

    public String getDistID() {
        return distID;
    }

    public String getFarmerSName() {
        return farmerSName;
    }

    public String getFarmerOName() {
        return farmerOName;
    }

    public String getGender() {
        return Gender;
    }

    public String getIdType() {
        return idType;
    }

    public int getFarmerAge() {
        return farmerAge;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getFarmNumber() {
        return farmNumber;
    }

    public String getFarmerAddress() {
        return farmerAddress;
    }

    public void setRegID(String regID) {
        this.regID = regID;
    }

    public void setDistID(String distID) {
        this.distID = distID;
    }

    public void setFarmerSName(String farmerSName) {
        this.farmerSName = farmerSName;
    }

    public void setFarmerOName(String farmerOName) {
        this.farmerOName = farmerOName;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public void setFarmerAge(int farmerAge) {
        this.farmerAge = farmerAge;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setFarmNumber(String farmNumber) {
        this.farmNumber = farmNumber;
    }

    public void setFarmerAddress(String farmerAddress) {
        this.farmerAddress = farmerAddress;
    }

    @Override
    public String toString() {
        return "Farmer{" + "regID=" + regID + ", distID=" + distID + ", farmerSName=" + farmerSName + ", farmerOName=" + farmerOName + ", Gender=" + Gender + ", idType=" + idType + ", farmerAge=" + farmerAge + ", idNumber=" + idNumber + ", farmNumber=" + farmNumber + ", farmerAddress=" + farmerAddress + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
}
