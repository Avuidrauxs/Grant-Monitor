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
public class CHEDOfficers {
    
    private String TAName;
    private Date TADateSign;
    private String DistOfficerName;
    private Date DistOfficerSign;
    private String RegOfficerName;
    private Date RegOfficerSign;
    private String lotNum;
    private String ITVouch;
    private String TRVouch;
    private String RPVouch;

    public CHEDOfficers() {
    }

    public CHEDOfficers(String TAName, Date TADateSign, String DistOfficerName, Date DistOfficerSign, String RegOfficerName, Date RegOfficerSign) {
        this.TAName = TAName;
        this.TADateSign = TADateSign;
        this.DistOfficerName = DistOfficerName;
        this.DistOfficerSign = DistOfficerSign;
        this.RegOfficerName = RegOfficerName;
        this.RegOfficerSign = RegOfficerSign;
    }

  
    public CHEDOfficers(String TAName, Date TADateSign, String DistOfficerName, Date DistOfficerSign, String RegOfficerName, Date RegOfficerSign, String ITVouch, String TRVouch) {
        this.TAName = TAName;
        this.TADateSign = TADateSign;
        this.DistOfficerName = DistOfficerName;
        this.DistOfficerSign = DistOfficerSign;
        this.RegOfficerName = RegOfficerName;
        this.RegOfficerSign = RegOfficerSign;
        this.ITVouch = ITVouch;
        this.TRVouch = TRVouch;
    }

    public String getITVouch() {
        return ITVouch;
    }

    public void setITVouch(String ITVouch) {
        this.ITVouch = ITVouch;
    }

    public String getTRVouch() {
        return TRVouch;
    }

    public void setTRVouch(String TRVouch) {
        this.TRVouch = TRVouch;
    }

    public String getRPVouch() {
        return RPVouch;
    }

    public void setRPVouch(String RPVouch) {
        this.RPVouch = RPVouch;
    }

    
    
    public String getLotNum() {
        return lotNum;
    }

    public void setLotNum(String lotNum) {
        this.lotNum = lotNum;
    }

    
    
    public String getTAName() {
        return TAName;
    }

    public void setTAName(String TAName) {
        this.TAName = TAName;
    }

    public Date getTADateSign() {
        return TADateSign;
    }

    public void setTADateSign(Date TADateSign) {
        this.TADateSign = TADateSign;
    }

    public String getDistOfficerName() {
        return DistOfficerName;
    }

    public void setDistOfficerName(String DistOfficerName) {
        this.DistOfficerName = DistOfficerName;
    }

    public Date getDistOfficerSign() {
        return DistOfficerSign;
    }

    public void setDistOfficerSign(Date DistOfficerSign) {
        this.DistOfficerSign = DistOfficerSign;
    }

    public String getRegOfficerName() {
        return RegOfficerName;
    }

    public void setRegOfficerName(String RegOfficerName) {
        this.RegOfficerName = RegOfficerName;
    }

    public Date getRegOfficerSign() {
        return RegOfficerSign;
    }

    public void setRegOfficerSign(Date RegOfficerSign) {
        this.RegOfficerSign = RegOfficerSign;
    }

    @Override
    public String toString() {
        return "CHEDOfficers{" + "TAName=" + TAName + ", TADateSign=" + TADateSign + ", DistOfficerName=" + DistOfficerName + ", DistOfficerSign=" + DistOfficerSign + ", RegOfficerName=" + RegOfficerName + ", RegOfficerSign=" + RegOfficerSign + '}';
    }
    
    
    
    
}
