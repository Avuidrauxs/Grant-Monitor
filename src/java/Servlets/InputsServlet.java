/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.FarmerManager;
import Models.AdminDetail;
import Models.CHEDContractor;
import Models.CHEDOfficers;
import Models.CHEDStaff;
import Models.CHEDTransact;
import Models.CocoaType;
import Models.Farmer;
import Models.Farms;
import Utility.PDFDemo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author audax
 */
public class InputsServlet extends HttpServlet {

    FarmerManager manager;

    Farmer farmer;
    CHEDContractor contractor;
    CHEDOfficers officer;
    CHEDStaff staff;
    AdminDetail adm;
    CHEDTransact transact;
    Farms farm;
    CocoaType cocoaType;
    PDFDemo sampPDF;

    RequestDispatcher requestD;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.

        manager = new FarmerManager();

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            //for outputting HTML tags
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
            String regionName,
                    districts,
                    farmerName,
                    location,
                    idType,
                    sex,
                    idNum,
                    initNum,
                    treeRemovalID,
                    oldFarmID,
                    obNum,
                    farmNum,
                    distOfficer,
                    cocaoType,
                    cocoaClass,
                    lotNum,
                    taName,
                    regName,
                    contractorName;

            int age,
                    sectNum,
                    distNum,
                    caID,
                    farmID,
                    treesOb,
                    treesCut;

            float    farmSize,
                    treatedArea,
                    untreatedArea,
                    amountPayable,
                    //obSize,
                    trPayed;

            Date itDate,
                    regSignDate,
                    distSignDate,
                    taSignDate;

            //VARCHARs
            regionName = request.getParameter("Regions").trim();
            farmerName = request.getParameter("farmerName").trim();
            districts = request.getParameter("Districts").trim();
            location = request.getParameter("location").trim();
            idType = request.getParameter("nationalid").trim();
            idNum = request.getParameter("natID").trim();
            initNum = request.getParameter("initNum").trim();
            treeRemovalID = request.getParameter("treeRemovalID").trim();
            oldFarmID = request.getParameter("oldFarmID").trim();
            obNum = request.getParameter("obNo").trim();
            lotNum = request.getParameter("lotNumbers").trim();
            distOfficer = request.getParameter("distOfficer").trim();
            sex = request.getParameter("sex").trim();
            cocaoType = request.getParameter("Ctype").trim();
            cocoaClass = request.getParameter("cocoaClass").trim();
            contractorName = request.getParameter("cutters").trim();
            taName = request.getParameter("tAssist").trim();
            regName = request.getParameter("regOffName").trim();

            //Integers
            age = Integer.parseInt(request.getParameter("age").trim());
            sectNum = Integer.parseInt(request.getParameter("sectNo").trim());
            distNum = Integer.parseInt(request.getParameter("distNo").trim());
            caID = Integer.parseInt(request.getParameter("caID").trim());
            treesCut = Integer.parseInt(request.getParameter("treesCut").trim());
            farmID = Integer.parseInt(request.getParameter("farmNo").trim());
            treesOb = Integer.parseInt(request.getParameter("treesOb").trim());

            //Float
            //obSize = Float.parseFloat(request.getParameter("obSize").trim());

            farmSize = Float.parseFloat(request.getParameter("farmSize").trim());
            treatedArea = Float.parseFloat(request.getParameter("treatedArea").trim());
            untreatedArea = farmSize - treatedArea;

              //for zero - padding  with length = 5. 
            //String.format("%05d", yournumber);

            
            //Farm Number generation
            //Block ID is "distNum" and also "distNo"
            farmNum = districts + "/" + String.format("%03d", sectNum) + "/" + String.format("%02d", distNum) + "/" + String.format("%02d", caID) + "/" + obNum.toUpperCase() + "/" + String.format("%03d", farmID);  

            //Retrieval of IT and TR rates from ched_itrate DB table
            float itRate = 0, trRate = 0;

            ResultSet ts = manager.rates();

            try {
                if (ts.next()) {
                    itRate = ts.getFloat(1);
                    trRate = ts.getFloat(2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(InputsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            //IT Amount payable = ITRate * Treated Area
            amountPayable = (float) (itRate * treatedArea);

            //TR Amount payable = TRRate * Number of trees cut
            trPayed = (float) (trRate * treesCut);

            //Date
            //1. You get the date in string format from the HTML/JSP page
            String s = request.getParameter("itDate");
            String t = request.getParameter("regSigned");
            String u = request.getParameter("distSigned");
            String v = request.getParameter("taSigned");

            //2. you format the date
            //DateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat sp = new SimpleDateFormat("dd-MM-yyyy");
            //3. now you convert to java.util.date
            itDate = sp.parse(s);
            regSignDate = sp.parse(t);
            distSignDate = sp.parse(u);
            taSignDate = sp.parse(v);

            //Insertion Block
            //farms table insertion
            //Object initializations
            farm = new Farms(farmSize, treatedArea, untreatedArea, cocaoType, treesCut, oldFarmID.toUpperCase(), farmNum, lotNum, treesOb);

            //farmer table insertion
            farmer = new Farmer(regionName, districts, farmerName, farmerName, sex, idType, age, idNum, farmNum, location);

            //cocoatype table
            cocoaType = new CocoaType(cocoaClass, cocaoType, farmNum);

            //transact table
            //transact = new CHEDTransact(treesCut, initNum, treeRemovalID, itDate, amountPayable, farmNum);
            transact = new CHEDTransact(treesCut, initNum, treeRemovalID, itDate, amountPayable, farmNum, trPayed);
            //contractors
            contractor = new CHEDContractor(contractorName, districts, farmNum);

            //officers
            officer = new CHEDOfficers(taName, taSignDate, distOfficer, distSignDate, regName, regSignDate, initNum, treeRemovalID);

            //Commiting the inputs
            if (manager.ADDFarm(farm) && manager.AddFarmers(farmer) && manager.ADDCocoaType(cocoaType)
                    && manager.ADDCHEDTransacts(transact) && manager.AddCHEDContractor(contractor)
                    && manager.ADDCHEDOfficers(officer)) {

                //Successful Save Action Block of Code
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/IT.html");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">"
                        + "alert(\"Saved Successful\")"
                        + "</script>");
                rd.include(request, response);

            } else {

                //Alert pop-up for when Save fails
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/IT.html");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">"
                        + "alert(\"Save Succes!!!!\")"
                        + "</script>");
                rd.include(request, response);

            }

        } catch (ParseException ex) {
            Logger.getLogger(InputsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
