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
public class CHEDStaff {
    
    private String staffID;
    private String staffSName;
    private String staffFName;
    private String userName;
    private String passKey;

    public CHEDStaff() {
    }

    public CHEDStaff(String staffID, String staffSName, String staffFName, String userName, String passKey) {
        this.staffID = staffID;
        this.staffSName = staffSName;
        this.staffFName = staffFName;
        this.userName = userName;
        this.passKey = passKey;
    }

    @Override
    public String toString() {
        return "CHEDStaff{" + "staffID=" + staffID + ", staffSName=" + staffSName + ", staffFName=" + staffFName + ", userName=" + userName + ", passKey=" + passKey + '}';
    }

    
    
    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffSName() {
        return staffSName;
    }

    public void setStaffSName(String staffSName) {
        this.staffSName = staffSName;
    }

    public String getStaffFName() {
        return staffFName;
    }

    public void setStaffFName(String staffFName) {
        this.staffFName = staffFName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassKey() {
        return passKey;
    }

    public void setPassKey(String passKey) {
        this.passKey = passKey;
    }

    
}
