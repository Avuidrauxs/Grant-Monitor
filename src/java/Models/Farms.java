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
public class Farms {

    private float totalFSize;
    private float treatedFsize;
    private float untreatedFSize;
    private String cocoaTypeID;
    private int treesCut;
    private String oldFNumber;
    private String farmNo;
    private String lotNumber;
    private int estTreesOb;
    
    public Farms() {
    }

    public Farms(float totalFSize, float treatedFsize, float untreatedFSize, String cocoaTypeID, int treesCut, String oldFNumber, String farmNo) {
        this.totalFSize = totalFSize;
        this.treatedFsize = treatedFsize;
        this.untreatedFSize = untreatedFSize;
        this.cocoaTypeID = cocoaTypeID;
        this.treesCut = treesCut;
        this.oldFNumber = oldFNumber;
        this.farmNo = farmNo;
    }

    public Farms(float totalFSize, float treatedFsize, float untreatedFSize, String cocoaTypeID, int treesCut, String oldFNumber, String farmNo, String lotNumber, int estTreesOb) {
        this.totalFSize = totalFSize;
        this.treatedFsize = treatedFsize;
        this.untreatedFSize = untreatedFSize;
        this.cocoaTypeID = cocoaTypeID;
        this.treesCut = treesCut;
        this.oldFNumber = oldFNumber;
        this.farmNo = farmNo;
        this.lotNumber = lotNumber;
        this.estTreesOb = estTreesOb;
    }

    public int getEstTreesOb() {
        return estTreesOb;
    }

    public void setEstTreesOb(int estTreesOb) {
        this.estTreesOb = estTreesOb;
    }

 

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    
    
    public String getFarmNo() {
        return farmNo;
    }

    public void setFarmNo(String farmNo) {
        this.farmNo = farmNo;
    }

 

    public float getTotalFSize() {
        return totalFSize;
    }

    public void setTotalFSize(float totalFSize) {
        this.totalFSize = totalFSize;
    }

    public float getTreatedFsize() {
        return treatedFsize;
    }

    public void setTreatedFsize(float treatedFsize) {
        this.treatedFsize = treatedFsize;
    }

    public float getUntreatedFSize() {
        return untreatedFSize;
    }

    public void setUntreatedFSize(float untreatedFSize) {
        this.untreatedFSize = untreatedFSize;
    }

    public String getCocoaTypeID() {
        return cocoaTypeID;
    }

    public void setCocoaTypeID(String cocoaTypeID) {
        this.cocoaTypeID = cocoaTypeID;
    }

    public int getTreesCut() {
        return treesCut;
    }

    public void setTreesCut(int treesCut) {
        this.treesCut = treesCut;
    }

    public String getOldFNumber() {
        return oldFNumber;
    }

    public void setOldFNumber(String oldFNumber) {
        this.oldFNumber = oldFNumber;
    }

    @Override
    public String toString() {
        return "Farms{" + "totalFSize=" + totalFSize + ", treatedFsize=" + treatedFsize + ", untreatedFSize=" + untreatedFSize + ", cocoaTypeID=" + cocoaTypeID + ", treesCut=" + treesCut + ", oldFNumber=" + oldFNumber + '}';
    }
    
    
    
    
    
}
