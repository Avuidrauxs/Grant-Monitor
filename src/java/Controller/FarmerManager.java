/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.AdminDetail;
import Models.CHEDContractor;
import Models.CHEDOfficers;
import Models.CHEDStaff;
import Models.CHEDTransact;
import Models.CocoaType;
import Models.Farmer;
import Models.Farms;
import Models.FirstComponentRehab;
import Models.RehabFarmerDetails;
import Models.Replantings;
import Utility.GrantConnectors;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author audax
 */
public class FarmerManager {

    private Connection con, closecon;
    private PreparedStatement ps;
    private ResultSet rs;
    private Farmer fm;
    private AdminDetail admins;
    private CHEDContractor contractor;
    private CHEDStaff staff;
    private CHEDTransact transact;
    private Farms farms;
    private CocoaType cocoa;
    private Replantings rp;
    private RehabFarmerDetails rehfarmer;
    private String query = "";
    private boolean status = false;
    private int reply;
    private ArrayList<Farmer> Allfarmers;

    public FarmerManager() {

        try {

            con = new GrantConnectors().getConnection();
            ps = null;
            rs = null;

        } catch (InstantiationException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean addRP(Replantings rep) {

        query = "INSERT INTO ched_replant(RPVouch,"
                + "AreaReplant,QtyFreeSeed,QtyFreeFert,"
                + "ReplantDate,GrossRPPayable,TotalDeduction,"
                + "NetRPPayable,FarmNumber,QtyFertPurchase,"
                + "QtySeedPurchase,RPLotNumber,"
                + "CostOfFertAllocated) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";

        try {
            ps = con.prepareStatement(query);

            java.util.Date datee = rep.getRpDate();

            Date rpDates = new Date(datee.getYear(), datee.getMonth(), datee.getDay());

            ps.setString(1, rep.getRpVouch());
            ps.setFloat(2, rep.getAreaReplant());
            ps.setInt(3, rep.getQtyFreeSeed());
            ps.setInt(4, rep.getQtyFreeFert());
            ps.setDate(5, rpDates);
            ps.setFloat(6, rep.getGrossRPay());
            ps.setFloat(7, rep.getTotalRPDeduct());
            ps.setFloat(8, rep.getNetRPay());
            ps.setString(9, rep.getFarmNum());
            ps.setInt(10, rep.getQtyFertPurchase());
            ps.setInt(11, rep.getQtySeedPurchase());
            ps.setString(12, rep.getRpLotNum());
            ps.setFloat(13, rep.getCostOfFertAllo());

            if (ps.executeUpdate() != 0) {

                status = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public boolean AddFarmer(Farmer fmr) {

        try {
            query = "INSERT INTO farmer values(?,?,?,?,?,?,?,?,?,"
                    + "(SELECT FarmNumber FROM farms ORDER BY FarmId DESC LIMIT 1));";

            ps = con.prepareStatement(query);

            ps.setString(1, fmr.getRegID());
            ps.setString(2, fmr.getDistID());
            ps.setString(3, fmr.getFarmerSName());
            ps.setString(4, fmr.getFarmerOName());
            ps.setString(5, fmr.getGender());
            ps.setString(6, fmr.getIdType());
            ps.setInt(7, fmr.getFarmerAge());
            ps.setString(8, fmr.getIdNumber());
            ps.setString(9, fmr.getFarmerAddress());

            reply = ps.executeUpdate();

            if (reply != 0) {
                status = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public boolean AddFarmers(Farmer fmr) {

        try {
            query = "INSERT INTO farmer(RegionID,DistID,FarmerName,Gender,IDType,Age,IDNumber"
                    + ",FarmNumber,FarmerAddress) values(?,?,?,?,?,?,?,?,?)";

            ps = con.prepareStatement(query);

            ps.setString(1, fmr.getRegID());
            ps.setString(2, fmr.getDistID());
            ps.setString(3, fmr.getFarmerSName());

            ps.setString(4, fmr.getGender());
            ps.setString(5, fmr.getIdType());
            ps.setInt(6, fmr.getFarmerAge());
            ps.setString(7, fmr.getIdNumber());
            ps.setString(8, fmr.getFarmNumber());
            ps.setString(9, fmr.getFarmerAddress());

            reply = ps.executeUpdate();

            if (reply != 0) {
                status = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public boolean AddAdminDetail(AdminDetail admin) {

        try {
            query = "INSERT INTO administrationdetails(AccountOfficer,DateSign,ChequeNumber,DatePaid,LotNumber) "
                    + "values(?,?,?,?,?)";

            ps = con.prepareStatement(query);

            // Setting the pattern
// SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
            // myDate is the java.util.Date in yyyy-mm-dd format
            // Converting it into String using formatter
//             String spp = "2019-4-4";
//            String ps = "2013-1-1";
//            
//            DateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
//            
//            java.util.Date ds = sp.parse(spp);
//            java.util.Date dp = sp.parse(ps);
            java.util.Date dateS = admin.getDateSigned();
            java.util.Date dateP = admin.getDatePaid();

            Date dateSigned = new Date(dateS.getYear(), dateS.getMonth(), dateS.getDay());
            Date datePaid = new Date(dateP.getYear(), dateP.getMonth(), dateP.getDay());

            ps.setString(1, admin.getAccOfficer());
            ps.setDate(2, (Date) dateSigned);
            ps.setString(3, admin.getChequeNum());
            ps.setDate(4, (Date) datePaid);
            ps.setString(5, admin.getLotNum());

            reply = ps.executeUpdate();

            if (reply != 0) {
                status = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public boolean AddCHEDContractor(CHEDContractor contract) {

        try {
            query = "INSERT INTO contrators(ConName,ConLocation,FarmNumber) values(?,?,?)";

            ps = con.prepareStatement(query);

            ps.setString(1, contract.getContractorName());
            ps.setString(2, contract.getContractorLocation());
            ps.setString(3, contract.getFarmNumber());

            reply = ps.executeUpdate();

            if (reply != 0) {

                status = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public boolean AddCHEDStaff(CHEDStaff stf) {

        query = "INSERT INTO staffs(StaffFName,StaffSName,UserName,Password) values(?,?,?,?) ";

        try {
            ps = con.prepareStatement(query);

            ps.setString(1, stf.getStaffFName());
            ps.setString(2, stf.getStaffSName());
            ps.setString(3, stf.getUserName());
            ps.setString(4, stf.getPassKey());

            if (ps.executeUpdate() != 0) {

                status = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public boolean ADDCHEDTransact(CHEDTransact trans) {

//        query = "INSERT INTO transact(NumberOfTressCut,LotNumber,ITVouch,TRVouch,ITDate,AmountPayable,FarmNumber,Rate) values(?,"
//                + "(SELECT LotNumber FROM farms ORDER BY FarmId DESC LIMIT 1),"
//                + "?,?,?,?,"
//                + "(SELECT FarmNumber FROM farms ORDER BY FarmId DESC LIMIT 1),"
//                + "(SELECT ITRate FROM ched_itrate ORDER BY RateID DESC LIMIT 1 ))";
        query = "INSERT INTO transact(NumberO)";
        try {
            ps = con.prepareStatement(query);

            java.util.Date dateP = trans.getiTDate();

            Date dateSigned = new Date(dateP.getYear(), dateP.getMonth(), dateP.getDay());

            ps.setInt(1, trans.getNumberOFTrees());
            ps.setString(2, trans.getLotNumber());
            ps.setString(3, trans.getiTvoucher());
            ps.setString(4, trans.gettRvoucher());
            ps.setDate(5, dateSigned);
            ps.setFloat(6, trans.getAmountPayable());

            if (ps.executeUpdate() != 0) {
                status = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public boolean ADDCHEDTransacts(CHEDTransact trans) {

        query = "INSERT INTO transact(NumberOfTressCut,ITVouch,TRVouch,ITDate,ITPayable,FarmNumber,"
                + "TRPayable,TRRate,ITRate"
                + ") values(?,?,?,?,?,?,?,"
                + "(SELECT TRRate FROM ched_itrate ORDER BY RateID DESC LIMIT 1),"
                + "(SELECT ITRate FROM ched_itrate ORDER BY RateID DESC LIMIT 1))";

        try {
            ps = con.prepareStatement(query);

            java.util.Date dateP = trans.getiTDate();

            Date dateSigned = new Date(dateP.getYear(), dateP.getMonth(), dateP.getDay());

            ps.setInt(1, trans.getNumberOFTrees());
            ps.setString(2, trans.getiTvoucher());
            ps.setString(3, trans.gettRvoucher());
            ps.setDate(4, dateSigned);
            ps.setFloat(5, trans.getAmountPayable());
            ps.setString(6, trans.getFarmNum());
            ps.setFloat(7, trans.getTRPayable());

            if (ps.executeUpdate() != 0) {
                status = true;
                con.commit();
            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public boolean ADDCocoaType(CocoaType cType) {

        query = "INSERT INTO cocoatype(CocoaTypeName,CocoaClass,FarmNumber) values(?,?,?)";

        try {

            ps = con.prepareStatement(query);

            ps.setString(1, cType.getTypeName());
            ps.setString(2, cType.getTypeCode());
            ps.setString(3, cType.getFarmNumber());

            if (ps.executeUpdate() != 0) {
                status = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public boolean ADDCHEDOfficers(CHEDOfficers ofcer) {

        query = "INSERT INTO officers(TAName,TADateSign,DistOfficerName,DistOfficerSign,RegOfficerName,RegOfficerSign,ITVouch,"
                + "TRVouch,TransactID"
                + ") values(?,?,?,?,?,?,?,?,"
                + "(SELECT TransactID FROM transact ORDER BY transact.TransactID DESC LIMIT 1))";

        try {
            ps = con.prepareStatement(query);

            ps.setString(1, ofcer.getTAName());
            ps.setString(3, ofcer.getDistOfficerName());
            ps.setString(5, ofcer.getRegOfficerName());

            java.util.Date taSign = ofcer.getTADateSign();
            java.util.Date distSign = ofcer.getDistOfficerSign();
            java.util.Date regSign = ofcer.getRegOfficerSign();

            Date TASigned = new Date(taSign.getYear(), taSign.getMonth() - 1, taSign.getDay());
            Date DistSigned = new Date(distSign.getYear(), distSign.getMonth(), distSign.getDay());
            Date RegSigned = new Date(regSign.getYear(), regSign.getMonth(), regSign.getDay());

            ps.setDate(2, TASigned);
            ps.setDate(4, DistSigned);
            ps.setDate(6, RegSigned);
            ps.setString(7, ofcer.getITVouch());
            ps.setString(8, ofcer.getTRVouch());

            if (ps.executeUpdate() != 0) {
                status = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean addRehabFarmer(RehabFarmerDetails rehFarmer) {

        query = "INSERT INTO farmerdetailsrehab values(?,?,?,?,?)";

        try {
            ps = con.prepareStatement(query);

            ps.setString(1, rehFarmer.getRehNumber());
            ps.setString(2, rehFarmer.getFarmerSex());
            ps.setString(3, rehFarmer.getFarmerAddress());
            ps.setString(4, rehFarmer.getFarmerName());
            ps.setInt(5, rehFarmer.getFarmerAge());

            if (ps.executeUpdate() != 0) {
                status = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public boolean addFirstClaimRehab(FirstComponentRehab rehFarm) {

        query = "INSERT INTO farmlevelrehab values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            ps = con.prepareStatement(query);
            
            java.util.Date rehDate = rehFarm.getTaDate();
            Date TASigned = new Date(rehDate.getYear(), rehDate.getMonth() - 1, rehDate.getDay());
            
            ps.setString(1, rehFarm.getRehFarmNo());
            ps.setString(2, rehFarm.getRehVoucher());
            ps.setFloat(3, rehFarm.getRehFarmSize());
            ps.setFloat(4, rehFarm.getRehArea());
            ps.setString(5, rehFarm.getRehDistOfficer());
            ps.setString(6, rehFarm.getRehTAname());
            ps.setInt(7, rehFarm.getRehTreesCut());
            ps.setFloat(8, rehFarm.getRehSeedSupply());
            ps.setString(9, rehFarm.getRehOldFarmID());
            ps.setString(10, rehFarm.getRehLot());
            ps.setString(11, rehFarm.getCutBy());
            ps.setString(12, rehFarm.getcType());
            ps.setString(13, rehFarm.getcAge());
            ps.setDate(14, TASigned);
            ps.setString(15, rehFarm.getRehdistrict());
            ps.setString(16, rehFarm.getRegion());
            ps.setFloat(17, rehFarm.getTrPay());

            if (ps.executeUpdate() != 0) {
                status = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public boolean ADDFarm(Farms frms) {
        query = "INSERT INTO farms(FarmNumber,TotalFarmSize,TreatedFarmSize,UntreatedFarmSize,OldFarmNumber,"
                + "NumberOfTreeCut,LotNumber,EstTrees) "
                + "values(?,?,?,?,?,?,?,?)";
        try {

            ps = con.prepareStatement(query);

            ps.setString(1, frms.getFarmNo());
            ps.setFloat(2, frms.getTotalFSize());
            ps.setFloat(3, frms.getTreatedFsize());
            ps.setFloat(4, frms.getUntreatedFSize());

            ps.setString(5, frms.getOldFNumber());
            ps.setInt(6, frms.getTreesCut());
            ps.setString(7, frms.getLotNumber());
            ps.setInt(8, frms.getEstTreesOb());

            if (ps.executeUpdate() != 0) {

                status = true;
                con.commit();

            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public ArrayList<Farmer> GetFarmers() {

        try {
            Allfarmers = new ArrayList<>();

            query = "SELECT * FROM farmer";

            ps = con.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                fm = new Farmer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9));

                Allfarmers.add(fm);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Allfarmers;
    }

    public ArrayList<String> AllStaff() {

        ArrayList<String> staffs = new ArrayList<String>();

        query = "select * from staffs";

        try {

            ps = con.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                staffs.add(rs.getString("Username") + "||" + rs.getString("Password"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return staffs;
    }

    public float rateNumber() {
        float x = 0;
        query = "SELECT ITRate FROM ched_itrate ORDER BY RateID DESC LIMIT 1";

        try {

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            x = rs.getFloat(1);

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return x;
    }

    public float rpRate() {
        float x = 0.24f;
        query = "SELECT RPRate FROM ched_itrate ORDER BY RateID DESC LIMIT 1";

        try {

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                x = rs.getFloat("RPRate");
            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return x;
        }
    }

    public ResultSet rates() {
        ResultSet ls = null;

        query = "SELECT ITRate,TRRate,RPRate FROM ched_itrate WHERE RateID=3";

        try {
            ps = con.prepareStatement(query);
            ls = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ls;
    }

    public boolean updateReplantList(String fmNum) {

        query = "UPDATE farms SET RPBool = 1 WHERE FarmNumber=?";

        try {
            ps = con.prepareStatement(query);

            ps.setString(1, fmNum);

            if (ps.executeUpdate() != 0) {

                status = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public ResultSet allReplant(String sfNum) {

        ResultSet rts = null;

        query = "SELECT a.TotalFarmSize,a.TreatedFarmSize,a.UntreatedFarmSize,a.EstTrees, a.NumberOfTreeCut,"
                + "b.RegionID,b.DistID,b.FarmerName,b.Gender,b.Age,b.IDNumber,b.FarmerAddress, c.CocoaTypeName,"
                + "c.CocoaClass,d.ITRate,d.ITVouch,d.TRVouch,a.LotNumber,d.ITDate,d.ITPayable,"
                + "e.TAName, e.DistOfficerName  "
                + "FROM farms a, farmer b, cocoatype c, transact d, officers e "
                + "WHERE a.FarmNumber = b.FarmNumber  "
                + "AND a.FarmNumber = c.FarmNumber  "
                //+ "AND a.FarmNumber = d.FarmNumber "
                + "AND d.TransactID = e.TransactID "
                + "AND a.FarmNumber = ?"
                + "ORDER BY a.FarmNumber ASC ";

        try {

            ps = con.prepareStatement(query);

            ps.setString(1, sfNum);

            rts = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rts;
    }

    
    
      public ResultSet PDFdemos() {
        ResultSet rel = null;

         query = " SELECT a.FarmNumber,a.TreatedFarmSize,b.FarmerName,"
                + "c.ITDate,c.NumberOfTressCut,b.DistID,b.RegionID "
                + "FROM farms a,farmer b, transact c, ched_replant d "
                + " WHERE a.FarmNumber = b.FarmNumber"
                + " AND   a.FarmNumber = c.FarmNumber"
                 + " AND   a.FarmNumber = d.FarmNumber"
                + " AND c.ITDate BETWEEN '2012-10-1' AND '2013-09-30' "
                + "ORDER BY FarmNumber ASC;";

        try {
            ps = con.prepareStatement(query);

          

            rel = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rel;
    }

    
    
    
    public ResultSet PDFdemos(String lots) {
        ResultSet rel = null;

        query = " SELECT a.FarmNumber,a.TotalFarmSize,a.NumberOfTreeCut,a.TreatedFarmSize,b.FarmerName,"
                + "b.IDNumber,c.ITVouch,c.TRVouch,c.ITDate,c.ITPayable,a.OldFarmNumber,b.RegionID "
                + "FROM farms a,farmer b, transact c "
                + " WHERE a.FarmNumber = b.FarmNumber"
                + " AND   a.FarmNumber = c.FarmNumber"
                + " AND a.LotNumber = ? "
                + "ORDER BY FarmNumber ASC;";
        
        

        try {
            ps = con.prepareStatement(query);

            ps.setString(1, lots);

            rel = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rel;
    }

    
    
     public ResultSet searchITOldFNumber(String lots) {
        ResultSet rel = null;

        query = " SELECT a.FarmNumber,a.TotalFarmSize,a.NumberOfTreeCut,a.TreatedFarmSize,b.FarmerName,"
                + "b.IDNumber,c.ITVouch,c.TRVouch,c.ITDate,c.ITPayable,a.OldFarmNumber,b.RegionID,a.LotNumber "
                + "FROM farms a,farmer b, transact c "
                + " WHERE a.FarmNumber = b.FarmNumber"
                + " AND   a.FarmNumber = c.FarmNumber"
                + " AND a.OldFarmNumber = ? "
                + "ORDER BY FarmNumber ASC;";
        
        

        try {
            ps = con.prepareStatement(query);

            ps.setString(1, lots);

            rel = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rel;
    }
     
     
     
     
     public ResultSet searchITIDNumber(String lots) {
        ResultSet rel = null;

        query = " SELECT a.FarmNumber,a.TotalFarmSize,a.NumberOfTreeCut,a.TreatedFarmSize,b.FarmerName,"
                + "b.IDNumber,c.ITVouch,c.TRVouch,c.ITDate,c.ITPayable,a.OldFarmNumber,b.RegionID,a.LotNumber "
                + "FROM farms a,farmer b, transact c "
                + " WHERE a.FarmNumber = b.FarmNumber"
                + " AND   a.FarmNumber = c.FarmNumber"
                + " AND b.IDNumber = ? "
                + "ORDER BY FarmNumber ASC;";
        
        

        try {
            ps = con.prepareStatement(query);

            ps.setString(1, lots);

            rel = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rel;
    }


    
    
    
    
     public ResultSet searchITFarmNumber(String lots) {
        ResultSet rel = null;

        query = " SELECT a.FarmNumber,a.TotalFarmSize,a.NumberOfTreeCut,a.TreatedFarmSize,b.FarmerName,"
                + "b.IDNumber,c.ITVouch,c.TRVouch,c.ITDate,c.ITPayable,a.OldFarmNumber,b.RegionID,a.LotNumber "
                + "FROM farms a,farmer b, transact c "
                + " WHERE a.FarmNumber = b.FarmNumber"
                + " AND   a.FarmNumber = c.FarmNumber"
                + " AND a.FarmNumber = ? "
                + "ORDER BY FarmNumber ASC;";
        
        

        try {
            ps = con.prepareStatement(query);

            ps.setString(1, lots);

            rel = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rel;
    }

    
     
     public ResultSet searchITLotNum(String lots) {
        ResultSet rel = null;

        query = " SELECT a.FarmNumber,a.TotalFarmSize,a.NumberOfTreeCut,a.TreatedFarmSize,b.FarmerName,"
                + "b.IDNumber,c.ITVouch,c.TRVouch,c.ITDate,c.ITPayable,a.OldFarmNumber,b.RegionID,a.LotNumber "
                + "FROM farms a,farmer b, transact c "
                + " WHERE a.FarmNumber = b.FarmNumber"
                + " AND   a.FarmNumber = c.FarmNumber"
                + " AND a.LotNumber = ? "
                + "ORDER BY FarmNumber ASC;";
        
        

        try {
            ps = con.prepareStatement(query);

            ps.setString(1, lots);

            rel = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rel;
    }

     

     
     public ResultSet searchITVouch(String lots) {
        ResultSet rel = null;

        query = " SELECT a.FarmNumber,a.TotalFarmSize,a.NumberOfTreeCut,a.TreatedFarmSize,b.FarmerName,"
                + "b.IDNumber,c.ITVouch,c.TRVouch,c.ITDate,c.ITPayable,a.OldFarmNumber,b.RegionID,a.LotNumber "
                + "FROM farms a,farmer b, transact c "
                + " WHERE a.FarmNumber = b.FarmNumber"
                + " AND   a.FarmNumber = c.FarmNumber"
                + " AND c.ITVouch = ? "
                + "ORDER BY FarmNumber ASC;";
        
        

        try {
            ps = con.prepareStatement(query);

            ps.setString(1, lots);

            rel = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rel;
    }

     
     
     public ResultSet searchTRVouch(String lots) {
        ResultSet rel = null;

        query = " SELECT a.FarmNumber,a.TotalFarmSize,a.NumberOfTreeCut,a.TreatedFarmSize,b.FarmerName,"
                + "b.IDNumber,c.ITVouch,c.TRVouch,c.ITDate,c.ITPayable,a.OldFarmNumber,b.RegionID,a.LotNumber "
                + "FROM farms a,farmer b, transact c "
                + " WHERE a.FarmNumber = b.FarmNumber"
                + " AND   a.FarmNumber = c.FarmNumber"
                + " AND c.TRVouch = ? "
                + "ORDER BY FarmNumber ASC;";
        
        

        try {
            ps = con.prepareStatement(query);

            ps.setString(1, lots);

            rel = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rel;
    }

     
     
     
    
    
    public ResultSet rpList(String regName) {
        ResultSet rels = null;

        query = "SELECT FarmNumber FROM farmer "
                + "WHERE RegionID = ? "
                + "AND RPBool = 0";

        try {

            ps = con.prepareStatement(query);

            ps.setString(1, regName);

            rels = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rels;
    }
    
    
    public boolean deleteFarm(String farm){
        
        query = "DELETE FROM farms WHERE FarmNumber = ?";
        
        try {
            
            ps = con.prepareStatement(query);
            ps.setString(1, farm);
            
            if(ps.executeUpdate() !=0)
            {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return false;
    }

    
    
    public boolean deleteRehabFarm(String farm){
        
        query = "DELETE FROM farmlevelrehab WHERE RehFarmNo = ?";
        
        try {
            
            ps = con.prepareStatement(query);
            ps.setString(1, farm);
            
            if(ps.executeUpdate() !=0)
            {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return false;
    }
    
    public boolean editRehabFarmNumber(String oldValue,String newValue)
    {
        
        query = "UPDATE farmlevelrehab SET RehFarmNo = ? WHERE RehFarmNo = ? ";
        
        try {
            ps = con.prepareStatement(query);
            
            ps.setString(1, oldValue);
            ps.setString(2, newValue);
            
            if(ps.executeUpdate() != 0)
            {
                
                return true;
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
    }
    
    public ResultSet PDFreplants(String lotNum) {
        ResultSet x = null;
        try {

            query = "SELECT a.FarmNumber,a.OldFarmNumber,a.TotalFarmSize,a.TreatedFarmSize, b.FarmerName,b.IDNumber,c.ITVouch,"
                    + "c.ITDate,c.ITPayable,d.RPVouch,d.ReplantDate, d.AreaReplant,d.QtyFreeSeed,d.QtyFreeFert,"
                    + "d.GrossRPPayable, d.TotalDeduction,d.NetRPPayable,d.QtyFertPurchase,d.QtySeedPurchase,"
                    + "d.CostOfFertAllocated,d.CostofSeed,b.RegionID "
                    + "FROM farms a,farmer b, transact c,ched_replant d   "
                    + "WHERE a.FarmNumber = b.FarmNumber "
                    + "AND a.FarmNumber = c.FarmNumber  "
                    + "AND a.FarmNumber = d.FarmNumber  "
                    + "AND d.RPLotNumber = ? "
                    + "ORDER BY FarmNumber ASC;";
                    //+ "AND d.ReplantStatus = 1 "
                    

            ps = con.prepareStatement(query);
            ps.setString(1, lotNum);
            x = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
    
    
    
    
    public ResultSet searchRPVouch(String vouch) {
        ResultSet x = null;
        try {

            query = "SELECT a.FarmNumber,a.OldFarmNumber,a.TotalFarmSize,a.TreatedFarmSize, b.FarmerName,b.IDNumber,c.ITVouch,"
                    + "c.ITDate,c.ITPayable,d.RPVouch,d.ReplantDate, d.AreaReplant,d.QtyFreeSeed,d.QtyFreeFert,"
                    + "d.GrossRPPayable, d.TotalDeduction,d.NetRPPayable,d.QtyFertPurchase,d.QtySeedPurchase,"
                    + "d.CostOfFertAllocated,d.CostofSeed,b.RegionID,d.RPLotNumber "
                    + ",b.IDNumber, c.ITVouch, c.TRVouch "
                    + "FROM farms a,farmer b, transact c,ched_replant d   "
                    + "WHERE a.FarmNumber = b.FarmNumber "
                    + "AND a.FarmNumber = c.FarmNumber  "
                    + "AND a.FarmNumber = d.FarmNumber  "
                    + "AND d.RPVouch = ? "
                    + "ORDER BY FarmNumber ASC;";
                    //+ "AND d.ReplantStatus = 1 "
                    

            ps = con.prepareStatement(query);
            ps.setString(1, vouch);
            x = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    
     public ResultSet searchRPFarmNumber(String vouch) {
        ResultSet x = null;
        try {

            query = "SELECT a.FarmNumber,a.OldFarmNumber,a.TotalFarmSize,a.TreatedFarmSize, b.FarmerName,b.IDNumber,c.ITVouch,"
                    + "c.ITDate,c.ITPayable,d.RPVouch,d.ReplantDate, d.AreaReplant,d.QtyFreeSeed,d.QtyFreeFert,"
                    + "d.GrossRPPayable, d.TotalDeduction,d.NetRPPayable,d.QtyFertPurchase,d.QtySeedPurchase,"
                    + "d.CostOfFertAllocated,d.CostofSeed,b.RegionID,d.RPLotNumber "
                    + ",b.IDNumber, c.ITVouch, c.TRVouch "
                    + "FROM farms a,farmer b, transact c,ched_replant d   "
                    + "WHERE a.FarmNumber = b.FarmNumber "
                    + "AND a.FarmNumber = c.FarmNumber  "
                    + "AND a.FarmNumber = d.FarmNumber  "
                    + "AND d.FarmNumber = ? ";
                    
                    //+ "AND d.ReplantStatus = 1 "
                    

            ps = con.prepareStatement(query);
            ps.setString(1, vouch);
            x = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
    
     
      public ResultSet searchRPLotNumber(String vouch) {
        ResultSet x = null;
        try {

            query = "SELECT a.FarmNumber,a.OldFarmNumber,a.TotalFarmSize,a.TreatedFarmSize, b.FarmerName,b.IDNumber,c.ITVouch,"
                    + "c.ITDate,c.ITPayable,d.RPVouch,d.ReplantDate, d.AreaReplant,d.QtyFreeSeed,d.QtyFreeFert,"
                    + "d.GrossRPPayable, d.TotalDeduction,d.NetRPPayable,d.QtyFertPurchase,d.QtySeedPurchase,"
                    + "d.CostOfFertAllocated,d.CostofSeed,b.RegionID,d.RPLotNumber "
                    + ",b.IDNumber, c.ITVouch, c.TRVouch "
                    + "FROM farms a,farmer b, transact c,ched_replant d   "
                    + "WHERE a.FarmNumber = b.FarmNumber "
                    + "AND a.FarmNumber = c.FarmNumber  "
                    + "AND a.FarmNumber = d.FarmNumber  "
                    + "AND d.RPLotNumber = ? ";
                    
                    //+ "AND d.ReplantStatus = 1 "
                    

            ps = con.prepareStatement(query);
            ps.setString(1, vouch);
            x = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
     
     
     
      public ResultSet searchRPOldNumber(String vouch) {
        ResultSet x = null;
        try {

            query = "SELECT a.FarmNumber,a.OldFarmNumber,a.TotalFarmSize,a.TreatedFarmSize, b.FarmerName,b.IDNumber,c.ITVouch,"
                    + "c.ITDate,c.ITPayable,d.RPVouch,d.ReplantDate, d.AreaReplant,d.QtyFreeSeed,d.QtyFreeFert,"
                    + "d.GrossRPPayable, d.TotalDeduction,d.NetRPPayable,d.QtyFertPurchase,d.QtySeedPurchase,"
                    + "d.CostOfFertAllocated,d.CostofSeed,b.RegionID,d.RPLotNumber "
                    + ",b.IDNumber, c.ITVouch, c.TRVouch "
                    + "FROM farms a,farmer b, transact c,ched_replant d   "
                    + "WHERE a.FarmNumber = b.FarmNumber "
                    + "AND a.FarmNumber = c.FarmNumber  "
                    + "AND a.FarmNumber = d.FarmNumber  "
                    + "AND a.OldFarmNumber = ? ";
                    
                    //+ "AND d.ReplantStatus = 1 "
                    

            ps = con.prepareStatement(query);
            ps.setString(1, vouch);
            x = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
     
      
       public ResultSet searchRPFarmerName(String vouch) {
        ResultSet x = null;
        try {

            query = "SELECT "
                    + "a.FarmNumber,a.OldFarmNumber,a.TotalFarmSize,a.TreatedFarmSize,"
                    + " b.FarmerName,b.IDNumber,c.ITVouch,"
                    + "c.ITDate,c.ITPayable,d.RPVouch,d.ReplantDate, "
                    + "d.AreaReplant,d.QtyFreeSeed,d.QtyFreeFert,"
                    + "d.GrossRPPayable, d.TotalDeduction,d.NetRPPayable,"
                    + "d.QtyFertPurchase,d.QtySeedPurchase,"
                    + "d.CostOfFertAllocated,d.CostofSeed,b.RegionID,d.RPLotNumber"
                    + "b.IDNumber, c.ITVouch, c.TRVouch "
                    + "FROM farms a,farmer b, transact c,ched_replant d   "
                    + "WHERE a.FarmNumber = b.FarmNumber "
                    + "AND a.FarmNumber = c.FarmNumber  "
                    + "AND a.FarmNumber = d.FarmNumber  "
                    + "AND b.FarmerName = ? ";
                    
                    //+ "AND d.ReplantStatus = 1 "
                    

            ps = con.prepareStatement(query);
            ps.setString(1, vouch);
            x = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
      
      

    public ResultSet TRReportPDF(String lots) {
        ResultSet rel = null;

        query = " SELECT a.FarmNumber,a.TotalFarmSize,a.NumberOfTreeCut,a.TreatedFarmSize,a.EstTrees,b.FarmerName,"
                + "c.ITVouch,c.TRVouch,c.ITDate,c.TRPayable,a.OldFarmNumber,b.RegionID "
                + "FROM farms a,farmer b, transact c "
                + " WHERE a.FarmNumber = b.FarmNumber"
                + " AND   a.FarmNumber = c.FarmNumber"
                + " AND a.LotNumber = ?"
                + "ORDER BY FarmNumber ASC;";

        try {
            ps = con.prepareStatement(query);

            ps.setString(1, lots);

            rel = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rel;
    }

    /*
     public static void main(String[] args) {
        
     try {
     FarmerManager m = new FarmerManager();
     float itRate = 0,trRate = 0;
     ResultSet ts = m.rates();
     if(ts.next())
     {
     itRate = ts.getFloat(1);
     trRate = ts.getFloat(2);
     }
     System.out.println(itRate+"\n"+trRate);
     } catch (SQLException ex) {
     Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
     }
        
        
            
        
        
     }
     */
    
    
    public boolean editFarmNumber(String oldValue, String newValue)
            
    {
        
        query = "UPDATE farms SET FarmNumber = ? WHERE FarmNumber = ?";
        
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, newValue);
            ps.setString(2, oldValue);
            
            if(ps.executeUpdate() != 0)
            {
                status = true;
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return status;
    }
    
    
    public ResultSet PDFRehab(String rehLot) {

        ResultSet rel = null;

        query = "SELECT a.RehFarmNo,a.FarmerSex,a.FarmerAddress,a.FarmerName,a.FarmerAge,b.REHVo_No"
                + ",b.RehFarmSz,b.RehTreatArea,b.Dist_Officer,b.Reh_TAName,b.RehTreeCutQty,"
                + "b.RehSeedSup,b.Old_FarmNo,b.RehLotNo,b.RehTreesCutBy,b.CocType_ID,"
                + "b.CocAge_ID,b.RHDate,b.Dist,b.trpAy,b.Region  "
                + "FROM farmerdetailsrehab a, farmlevelrehab b "
                + "WHERE a.RehFarmNo = b.RehFarmNo "
                + "AND b.RehLotNo = ? "
                + "ORDER BY b.RehTreesCutBy ASC ";

        try {
            ps = con.prepareStatement(query);

            ps.setString(1, rehLot);
            rel = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rel;

    }
    
    public int allRehabFarms(String rehLot)
    {

        int x = 0;
        ResultSet rs = null;
        query = "SELECT COUNT(RehFarmNo) FROM farmlevelrehab WHERE RehLotNo = ?";
        
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, rehLot);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                x = rs.getInt(1);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return x;
    }
    
    
    
    public int totalFarms (String lotNum)
    {
        int x = 0;
        query = "select COUNT(FarmNumber) from farms WHERE LotNumber = ?";
         
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, lotNum);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                x = rs.getInt(1);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
        
        
        return x;
    }
    
    
    public int totalReports()
    {
        
        int x = 0;
        query = "SELECT COUNT(FarmNumber) FROM ched_replant WHERE ReplantDate BETWEEN '2012-10-01' AND '2013-09-30' ";
        
        try {
            ps = con.prepareStatement(query);
            ResultSet os =ps.executeQuery();
            
            if(os.next())
            {
                x = os.getInt(1);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return x;
    }
    
     public int totalFarmsReplant (String lotNum)
    {
        int x = 0;
        query = "SELECT COUNT(FarmNumber) FROM ched_replant WHERE RPLotNumber = ?";
         
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, lotNum);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                x = rs.getInt(1);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
        
        
        return x;
    }
    
     
     public boolean editITandTR (String table,String oldVal,String newVal,String field,String farmNumber)
     {
         
         
         
        try {
            switch (table)
            {
                
             
                
                case "farmerdetailsrehab":
                    
                    query = "UPDATE farms SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setString(1, newVal);
                    ps.setString(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                    
                    
                    break;
                
                
                case "farmlevelrehab":
                    
                    query = "UPDATE farms SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setString(1, newVal);
                    ps.setString(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                    
                    
                    break;
                
                
                
                
                case "farms":
                    
                    query = "UPDATE farms SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setString(1, newVal);
                    ps.setString(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                    
                    
                    break;
                    
                case "farmer":
                    
                      query = "UPDATE farmer SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setString(1, newVal);
                    ps.setString(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                
                break;
                    
                    
                           
                case "transact":
                    
                      query = "UPDATE transact SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setString(1, newVal);
                    ps.setString(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                
                break;
                    
                    
                case "ched_replant":
                    
                        query = "UPDATE ched_replant SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setString(1, newVal);
                    ps.setString(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                    
                    break;
                    
                    
                default:
                    
                    
                    break;
                    
                    
                    
                    
                    
            }
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         return status;
     }
     
     
     
     
     
     
     public boolean editITandTR (String table,int oldVal,int newVal,String field,String farmNumber)
     {
         
         
         
        try {
            switch (table)
            {
                
                
                case "farmerdetailsrehab":
                    
                    query = "UPDATE farms SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setInt(1, newVal);
                    ps.setInt(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                    
                    
                    break;
                    
                
                
                case "farmlevelrehab":
                    
                    query = "UPDATE farms SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setInt(1, newVal);
                    ps.setInt(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                    
                    
                    break;
                    
                
                case "farms":
                    
                    query = "UPDATE farms SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setInt(1, newVal);
                    ps.setInt(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                    
                    
                    break;
                    
                case "farmer":
                    
                      query = "UPDATE farmer SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setInt(1, newVal);
                    ps.setInt(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                
                break;
                    
                    
                           
                case "transact":
                    
                      query = "UPDATE transact SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setInt(1, newVal);
                    ps.setInt(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                
                break;
                    
                    
                case "ched_replant":
                    
                        query = "UPDATE ched_replant SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setInt(1, newVal);
                    ps.setInt(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                    
                    break;
                    
                    
                default:
                    
                    
                    break;
                    
                    
                    
                    
                    
            }
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         return status;
     }
     
     
     
     
     public boolean editITandTR (String table,float oldVal,float newVal,String field,String farmNumber)
     {
         
         
         
        try {
            switch (table)
            {
                
                case "farmlevelrehab":
                    
                    query = "UPDATE farms SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setFloat(1, newVal);
                    ps.setFloat(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                    
                    
                    break;
                
                    
                    
                case "farmerdetailsrehab":
                    
                    query = "UPDATE farms SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setFloat(1, newVal);
                    ps.setFloat(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                    
                    
                    break;
                
                    
                    
                    case "farm":
                    
                    query = "UPDATE farms SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setFloat(1, newVal);
                    ps.setFloat(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                    
                    
                    break;
                
                    
                    
                case "farmer":
                    
                      query = "UPDATE farmer SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setFloat(1, newVal);
                    ps.setFloat(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                
                break;
                    
                    
                           
                case "transact":
                    
                      query = "UPDATE transact SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setFloat(1, newVal);
                    ps.setFloat(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                
                break;
                    
                    
                case "ched_replant":
                    
                        query = "UPDATE ched_replant SET "+field+"= ? WHERE "+field+" = ? AND FarmNumber = ?";
                    
                    ps = con.prepareStatement(query);
                    
                    ps.setFloat(1, newVal);
                    ps.setFloat(2, oldVal);
                    ps.setString(3, farmNumber);
                    
                   if(ps.executeUpdate() != 0)
                   {
                       status = true;
                       
                   }
                    
                    break;
                    
                    
                default:
                    
                    
                    break;
                    
                    
                    
                    
                    
            }
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(FarmerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         return status;
     }
     
     
     
     
     
    
}
