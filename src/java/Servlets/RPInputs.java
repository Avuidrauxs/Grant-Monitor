/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.FarmerManager;
import Models.Replantings;
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author audax
 */
public class RPInputs extends HttpServlet {

    private FarmerManager manager;
    private Replantings rpp;

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
            String rpVouch, farmNum, rpLot;
            float areaReplant,
                    grossRPay,
                    totalRPDeduct,
                    netRPay,
                    costOfFertAllo;
            int qtyFreeSeed,
                    qtyFreeFert,
                    qtyFertPurchase,
                    qtySeedPurchase;
            Date rpDate;
            //VARCHARS
            rpVouch = request.getParameter("rpVouch");
            farmNum = request.getParameter("fNum");
            rpLot = request.getParameter("rpLot");
            //FLOATS
            areaReplant = Float.parseFloat(request.getParameter("areaRpl"));
            grossRPay = Float.parseFloat(request.getParameter("grossRPP"));
            totalRPDeduct = Float.parseFloat(request.getParameter("total"));
            netRPay = Float.parseFloat(request.getParameter("netRPP"));
            costOfFertAllo = Float.parseFloat(request.getParameter("fertAllo"));
            //INTEGERS
            qtyFreeSeed = Integer.parseInt(request.getParameter("quanSeed"));
            qtyFreeFert = Integer.parseInt(request.getParameter("fertBags"));
            qtyFertPurchase = Integer.parseInt(request.getParameter("fertPurchase"));
            qtySeedPurchase = Integer.parseInt(request.getParameter("seedPurchase"));
            //Date
            String v = request.getParameter("rpDate");
            //2. you format the date
            //DateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat sp = new SimpleDateFormat("dd-MM-yyyy");
            //3. now you convert to java.util.date
            rpDate = sp.parse(v);
            //INSERTION BLOCK
            rpp = new Replantings(rpVouch, rpLot, farmNum, areaReplant, grossRPay, totalRPDeduct, netRPay, costOfFertAllo, qtyFreeSeed, qtyFreeFert, qtyFertPurchase, qtySeedPurchase, rpDate);
            
            //Commit
           if(manager.addRP(rpp)&& manager.updateReplantList(farmNum))
               
               {

                //Successful Save Action Block of Code
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/replanting.jsp");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">"
                        + "alert(\"Saved Successful\")"
                        + "</script>");
                rd.include(request, response);
                

            } else {

                //Alert pop-up for when Save fails
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/replanting.jsp");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">"
                        + "alert(\"Save Failed!!\")"
                        + "</script>");
                rd.include(request, response);
                

            }

            
        } catch (ParseException ex) {
            Logger.getLogger(RPInputs.class.getName()).log(Level.SEVERE, null, ex);
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
