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
public class CocoaType {
    
    private String typeCode;
    private String typeName;
    private String farmNumber;
    

    public CocoaType() {
    }

    public CocoaType(String typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public CocoaType(String typeCode, String typeName, String farmNumber) {
        this.typeCode = typeCode;
        this.typeName = typeName;
        this.farmNumber = farmNumber;
    }

    public String getFarmNumber() {
        return farmNumber;
    }

    public void setFarmNumber(String farmNumber) {
        this.farmNumber = farmNumber;
    }
    
    

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "CocoaType{" + "typeCode=" + typeCode + ", typeName=" + typeName + '}';
    }

    
        
        
}
