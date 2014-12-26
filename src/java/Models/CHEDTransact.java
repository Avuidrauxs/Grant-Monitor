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
public class CHEDTransact {
    
    
    private int numberOFTrees;
    private String lotNumber;
    private String iTvoucher;
    private String tRvoucher;
    private Date iTDate;
    private float amountPayable;
    private String farmNum;
    private float  itRate;
    private float TRPayable;

    public CHEDTransact() {
    }

    public CHEDTransact(int numberOFTrees, String iTvoucher, String tRvoucher, Date iTDate, float amountPayable, String farmNum, float TRPayable) {
        this.numberOFTrees = numberOFTrees;
        this.iTvoucher = iTvoucher;
        this.tRvoucher = tRvoucher;
        this.iTDate = iTDate;
        this.amountPayable = amountPayable;
        this.farmNum = farmNum;
       
        this.TRPayable = TRPayable;
    }

 

    public float getItRate() {
        return itRate;
    }

    public void setItRate(float itRate) {
        this.itRate = itRate;
    }

    public float getTRPayable() {
        return TRPayable;
    }

    public void setTRPayable(float TRPayable) {
        this.TRPayable = TRPayable;
    }

    
    
    
    public String getFarmNum() {
        return farmNum;
    }

    public void setFarmNum(String farmNum) {
        this.farmNum = farmNum;
    }

    
    
    public int getNumberOFTrees() {
        return numberOFTrees;
    }

    public void setNumberOFTrees(int numberOFTrees) {
        this.numberOFTrees = numberOFTrees;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getiTvoucher() {
        return iTvoucher;
    }

    public void setiTvoucher(String iTvoucher) {
        this.iTvoucher = iTvoucher;
    }

    public String gettRvoucher() {
        return tRvoucher;
    }

    public void settRvoucher(String tRvoucher) {
        this.tRvoucher = tRvoucher;
    }

    public Date getiTDate() {
        return iTDate;
    }

    public void setiTDate(Date iTDate) {
        this.iTDate = iTDate;
    }

    public float getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(float amountPayable) {
        this.amountPayable = amountPayable;
    }

    @Override
    public String toString() {
        return "CHEDTransact{" + "numberOFTrees=" + numberOFTrees + ", lotNumber=" + lotNumber + ", iTvoucher=" + iTvoucher + ", tRvoucher=" + tRvoucher + ", iTDate=" + iTDate + ", amountPayable=" + amountPayable + '}';
    }

   
    
}
