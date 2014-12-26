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
public class CHEDContractor {
    
    private String contractorName;
    private String contractorLocation;
    private String farmNumber;

    public CHEDContractor() {
    }

    public CHEDContractor(String contractorName, String contractorLocation) {
        this.contractorName = contractorName;
        this.contractorLocation = contractorLocation;
    }

    public CHEDContractor(String contractorName, String contractorLocation, String farmNumber) {
        this.contractorName = contractorName;
        this.contractorLocation = contractorLocation;
        this.farmNumber = farmNumber;
    }

    public String getFarmNumber() {
        return farmNumber;
    }

    public void setFarmNumber(String farmNumber) {
        this.farmNumber = farmNumber;
    }
    
    

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public String getContractorLocation() {
        return contractorLocation;
    }

    public void setContractorLocation(String contractorLocation) {
        this.contractorLocation = contractorLocation;
    }

    @Override
    public String toString() {
        return "CHEDContractor{" + "contractorName=" + contractorName + ", contractorLocation=" + contractorLocation + '}';
    }
    
    
    
    
}
