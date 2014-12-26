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
public class Replantings {

    private String rpVouch,rpLotNum,farmNum;
    private float areaReplant,
            grossRPay,
            totalRPDeduct,
            netRPay,
            costOfFertAllo;
    private int qtyFreeSeed,
            qtyFreeFert,
            qtyFertPurchase,
            qtySeedPurchase;
    
    private Date rpDate; 

    public Replantings() {
    }

    public Replantings(String rpVouch, String rpLotNum, String farmNum, float areaReplant, float grossRPay, float totalRPDeduct, float netRPay, float costOfFertAllo, int qtyFreeSeed, int qtyFreeFert, int qtyFertPurchase, int qtySeedPurchase, Date rpDate) {
        this.rpVouch = rpVouch;
        this.rpLotNum = rpLotNum;
        this.farmNum = farmNum;
        this.areaReplant = areaReplant;
        this.grossRPay = grossRPay;
        this.totalRPDeduct = totalRPDeduct;
        this.netRPay = netRPay;
        this.costOfFertAllo = costOfFertAllo;
        this.qtyFreeSeed = qtyFreeSeed;
        this.qtyFreeFert = qtyFreeFert;
        this.qtyFertPurchase = qtyFertPurchase;
        this.qtySeedPurchase = qtySeedPurchase;
        this.rpDate = rpDate;
    }

    public Date getRpDate() {
        return rpDate;
    }

    public void setRpDate(Date rpDate) {
        this.rpDate = rpDate;
    }

   
    public String getRpVouch() {
        return rpVouch;
    }

    public void setRpVouch(String rpVouch) {
        this.rpVouch = rpVouch;
    }

    public String getRpLotNum() {
        return rpLotNum;
    }

    public void setRpLotNum(String rpLotNum) {
        this.rpLotNum = rpLotNum;
    }

    public String getFarmNum() {
        return farmNum;
    }

    public void setFarmNum(String farmNum) {
        this.farmNum = farmNum;
    }

    public float getAreaReplant() {
        return areaReplant;
    }

    public void setAreaReplant(float areaReplant) {
        this.areaReplant = areaReplant;
    }

    public float getGrossRPay() {
        return grossRPay;
    }

    public void setGrossRPay(float grossRPay) {
        this.grossRPay = grossRPay;
    }

    public float getTotalRPDeduct() {
        return totalRPDeduct;
    }

    public void setTotalRPDeduct(float totalRPDeduct) {
        this.totalRPDeduct = totalRPDeduct;
    }

    public float getNetRPay() {
        return netRPay;
    }

    public void setNetRPay(float netRPay) {
        this.netRPay = netRPay;
    }

    public float getCostOfFertAllo() {
        return costOfFertAllo;
    }

    public void setCostOfFertAllo(float costOfFertAllo) {
        this.costOfFertAllo = costOfFertAllo;
    }

    public int getQtyFreeSeed() {
        return qtyFreeSeed;
    }

    public void setQtyFreeSeed(int qtyFreeSeed) {
        this.qtyFreeSeed = qtyFreeSeed;
    }

    public int getQtyFreeFert() {
        return qtyFreeFert;
    }

    public void setQtyFreeFert(int qtyFreeFert) {
        this.qtyFreeFert = qtyFreeFert;
    }

    public int getQtyFertPurchase() {
        return qtyFertPurchase;
    }

    public void setQtyFertPurchase(int qtyFertPurchase) {
        this.qtyFertPurchase = qtyFertPurchase;
    }

    public int getQtySeedPurchase() {
        return qtySeedPurchase;
    }

    public void setQtySeedPurchase(int qtySeedPurchase) {
        this.qtySeedPurchase = qtySeedPurchase;
    }
    
    
    
    
    
    

}
