/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author audax
 */
public class FirstComponentRehab {
    
    
    private String rehFarmNo,
            rehVoucher,
            rehDistOfficer,
            rehTAname,
            rehOldFarmID,
            rehLot,
            cType,
            cAge,
            cutBy,
            region,
            rehdistrict;

    private float rehFarmSize,
            rehArea,
            trPay,
            rehSeedSupply;
    
    private int rehTreesCut;
    
    private Date taDate;

    public FirstComponentRehab() {
    }

    public FirstComponentRehab(String rehFarmNo, String rehVoucher, String rehDistOfficer, 
            String rehTAname, String rehOldFarmID, String rehLot, String cType, String cAge, String rehdistrict, 
            float rehFarmSize, float rehArea, 
            float rehSeedSupply, int rehTreesCut,
            Date taDate,String cutBy,String region,Float trPay) {
        this.rehFarmNo = rehFarmNo;
        this.rehVoucher = rehVoucher;
        this.rehDistOfficer = rehDistOfficer;
        this.rehTAname = rehTAname;
        this.rehOldFarmID = rehOldFarmID;
        this.rehLot = rehLot;
        this.cType = cType;
        this.cAge = cAge;
        this.rehdistrict = rehdistrict;
        this.rehFarmSize = rehFarmSize;
        this.rehArea = rehArea;
        this.rehSeedSupply = rehSeedSupply;
        this.rehTreesCut = rehTreesCut;
        this.taDate = taDate;
        this.cutBy = cutBy;
        this.region = region;
        this.trPay = trPay;
    }

    
    
    public String getCutBy() {
        return cutBy;
    }

    public void setCutBy(String cutBy) {
        this.cutBy = cutBy;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getTrPay() {
        return trPay;
    }

    public void setTrPay(float trPay) {
        this.trPay = trPay;
    }

    
    
    
    public String getRehFarmNo() {
        return rehFarmNo;
    }

    public void setRehFarmNo(String rehFarmNo) {
        this.rehFarmNo = rehFarmNo;
    }

    public String getRehVoucher() {
        return rehVoucher;
    }

    public void setRehVoucher(String rehVoucher) {
        this.rehVoucher = rehVoucher;
    }

    public String getRehDistOfficer() {
        return rehDistOfficer;
    }

    public void setRehDistOfficer(String rehDistOfficer) {
        this.rehDistOfficer = rehDistOfficer;
    }

    public Date getTaDate() {
        return taDate;
    }

    public void setTaDate(Date taDate) {
        this.taDate = taDate;
    }
    
    

    public String getRehTAname() {
        return rehTAname;
    }

    public void setRehTAname(String rehTAname) {
        this.rehTAname = rehTAname;
    }

    public String getRehOldFarmID() {
        return rehOldFarmID;
    }

    public void setRehOldFarmID(String rehOldFarmID) {
        this.rehOldFarmID = rehOldFarmID;
    }

    public String getRehLot() {
        return rehLot;
    }

    public void setRehLot(String rehLot) {
        this.rehLot = rehLot;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getcAge() {
        return cAge;
    }

    public void setcAge(String cAge) {
        this.cAge = cAge;
    }

    public String getRehdistrict() {
        return rehdistrict;
    }

    public void setRehdistrict(String rehdistrict) {
        this.rehdistrict = rehdistrict;
    }

    public float getRehFarmSize() {
        return rehFarmSize;
    }

    public void setRehFarmSize(float rehFarmSize) {
        this.rehFarmSize = rehFarmSize;
    }

    public float getRehArea() {
        return rehArea;
    }

    public void setRehArea(float rehArea) {
        this.rehArea = rehArea;
    }

    public float getRehSeedSupply() {
        return rehSeedSupply;
    }

    public void setRehSeedSupply(float rehSeedSupply) {
        this.rehSeedSupply = rehSeedSupply;
    }

    public int getRehTreesCut() {
        return rehTreesCut;
    }

    public void setRehTreesCut(int rehTreesCut) {
        this.rehTreesCut = rehTreesCut;
    }
    
    
    
    
}
