/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.FarmerManager;
import Models.FirstComponentRehab;
import Models.RehabFarmerDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author audax
 */
@WebServlet(name = "RehabInsert", urlPatterns = {"/RehabInsert"})
public class RehabInsert extends HttpServlet {

    
    FarmerManager manager;
    RehabFarmerDetails rehFarmer;
    FirstComponentRehab rehfarmLevel;

    @Override
    public void init() throws ServletException {
    
        manager = new FarmerManager();
        
    }
    
    
    
    //Strings
    private String farmerName,
            sex,
            rehabNum,
            rehFarmID,
            rehOldFarmID,
            lotNumber,
            ctype,
            cocoaClass,
            rehContractors,
            distOfficer,
            district,
            region,
            tAssist;

    //Integers
    private int age,
            rehTreesCut;

    //Float 
    private float rehFarmize,
            rehArea,
            notRehab,
            rehSeed,
            trPay,
            rehCost;

    //Date
    private Date rehDate;

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
        //response.setContentType("text/html;charset=UTF-8");

        //Strings
        farmerName = request.getParameter("farmerName");
        sex = request.getParameter("sex");
        rehabNum = request.getParameter("rehabNum");
        rehFarmID = request.getParameter("rehFarmID");
        rehOldFarmID = request.getParameter("rehOldFarmID");
        lotNumber = request.getParameter("lotnumbers");
        ctype = request.getParameter("Ctype");
        cocoaClass = request.getParameter("cocoaClass");
        rehContractors =  request.getParameter("rehContractors");
        distOfficer = request.getParameter("distOfficer");
        tAssist = request.getParameter("tAssist");
        district = request.getParameter("Districts");
        region = request.getParameter("Regions");
        
        
        //Integers
        age =Integer.parseInt(request.getParameter("age"));
        rehTreesCut = Integer.parseInt(request.getParameter("rehTreesCut"));
        
        //Float
        rehFarmize = Float.parseFloat(request.getParameter("rehFarmSize"));
        rehArea = Float.parseFloat(request.getParameter("rehArea"));
        rehCost = Float.parseFloat(request.getParameter("rehCost"));
        rehSeed = Float.parseFloat(request.getParameter("rehSeed"));
        
        
        //Calculate TR pay here
        trPay = 43.89f;
        
        //Date
           String v = request.getParameter("rehDate");

            //2. you format the date
            //DateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat sp = new SimpleDateFormat("dd-MM-yyyy");
        try {
            //3. now you convert to java.util.date
            rehDate = sp.parse(v);
        } catch (ParseException ex) {
            Logger.getLogger(RehabInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        //Initializing and Commiting
        rehFarmer = new RehabFarmerDetails(farmerName, farmerName, farmerName, lotNumber, age);
        rehfarmLevel = new FirstComponentRehab(rehFarmID, rehabNum, distOfficer, tAssist, rehOldFarmID, 
                lotNumber, ctype, cocoaClass,district, rehFarmize, 
                rehArea, rehSeed, rehTreesCut,rehDate,rehContractors,region,trPay);
        
       //Commiting
        if(manager.addFirstClaimRehab(rehfarmLevel) && manager.addRehabFarmer(rehFarmer))
        {
        
        
        //Successful Save Action Block of Code
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/rehab.jsp");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">"
                        + "alert(\"Saved Successful\")"
                        + "</script>");
                rd.include(request, response);
                

            } else {

                //Alert pop-up for when Save fails
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/rehab.jsp");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">"
                        + "alert(\"Save Succes!!!!\")"
                        + "</script>");
                rd.include(request, response);
                

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
