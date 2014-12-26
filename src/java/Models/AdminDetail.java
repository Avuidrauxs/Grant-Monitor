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
public class AdminDetail {
    
    private String accOfficer;
    private Date dateSigned;
    private String chequeNum;
    private Date datePaid;
    private String lotNum;

    public AdminDetail() {
    }

    public AdminDetail(String accOfficer, Date dateSigned, String chequeNum, Date datePaid, String lotNum) {
        this.accOfficer = accOfficer;
        this.dateSigned = dateSigned;
        this.chequeNum = chequeNum;
        this.datePaid = datePaid;
        this.lotNum = lotNum;
    }

    public AdminDetail(String accOfficer, Date dateSigned, String chequeNum, Date datePaid) {
        this.accOfficer = accOfficer;
        this.dateSigned = dateSigned;
        this.chequeNum = chequeNum;
        this.datePaid = datePaid;
    }
    
    

    public String getAccOfficer() {
        return accOfficer;
    }

    public void setAccOfficer(String accOfficer) {
        this.accOfficer = accOfficer;
    }

    public Date getDateSigned() {
        return dateSigned;
    }

    public void setDateSigned(Date dateSigned) {
        this.dateSigned = dateSigned;
    }

    public String getChequeNum() {
        return chequeNum;
    }

    public void setChequeNum(String chequeNum) {
        this.chequeNum = chequeNum;
    }

    public Date getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Date datePaid) {
        this.datePaid = datePaid;
    }

    public String getLotNum() {
        return lotNum;
    }

    public void setLotNum(String lotNum) {
        this.lotNum = lotNum;
    }

    @Override
    public String toString() {
        return "AdminDetail{" + "accOfficer=" + accOfficer + ", dateSigned=" + dateSigned + ", chequeNum=" + chequeNum + ", datePaid=" + datePaid + ", lotNum=" + lotNum + '}';
    }
    
    
    
}
