/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.FarmerManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author audax
 */
public class ITeditServlet extends HttpServlet {

    FarmerManager manager;

    @Override
    public void init() throws ServletException {

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

        String oldValues = request.getParameter("oldVal");
        String newValues = request.getParameter("newVal");
        String fields = request.getParameter("fields");
        String fNum = request.getParameter("FarmNumber");

        switch (fields) {

            case "ITVouch":
            case "TRVouch":
            case "ITDate":

                if (manager.editITandTR("transact", oldValues, newValues, fields, fNum)) {

                    //Successful Save Action Block of Code
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/it_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Successful\")"
                            + "</script>");
                    rd.include(request, response);

                } else {

                    //Failure
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/it_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Failed\")"
                            + "</script>");
                    rd.include(request, response);

                }
                break;

            case "NumberOfTressCut":

                if (manager.editITandTR("transact", Integer.parseInt(oldValues), Integer.parseInt(newValues), fields, fNum)) {

                    //Successful Save Action Block of Code
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/it_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Successful\")"
                            + "</script>");
                    rd.include(request, response);

                } else {

                    //Failure
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/it_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Failed\")"
                            + "</script>");
                    rd.include(request, response);

                }

                break;

            case "ITPayable":
            case "TRPayable":

                if (manager.editITandTR("transact", Float.parseFloat(oldValues), Float.parseFloat(newValues), fields, fNum)) {

                    //Successful Save Action Block of Code
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/it_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Successful\")"
                            + "</script>");
                    rd.include(request, response);

                } else {

                    //Failure
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/it_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Failed\")"
                            + "</script>");
                    rd.include(request, response);

                }

                break;

            case "FarmerName":
            case "IDNumber":

                if (manager.editITandTR("farmer", oldValues, newValues, fields, fNum)) {

                    //Successful Save Action Block of Code
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/it_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Successful\")"
                            + "</script>");
                    rd.include(request, response);

                } else {

                    //Failure
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/it_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Failed\")"
                            + "</script>");
                    rd.include(request, response);

                }

                break;

            case "LotNumber" :
            case "OldFarmNumber":

                if (manager.editITandTR("farms", oldValues, newValues, fields, fNum)) {

                    //Successful Save Action Block of Code
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/it_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Successful\")"
                            + "</script>");
                    rd.include(request, response);

                } else {

                    //Failure
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/it_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Failed\")"
                            + "</script>");
                    rd.include(request, response);

                }

                break;

            case "ConName":
            case "ConLocation":
                
                
                if (manager.editITandTR("contrators", oldValues, newValues, fields, fNum)) {

                    //Successful Save Action Block of Code
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/it_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Successful\")"
                            + "</script>");
                    rd.include(request, response);

                } else {

                    //Failure
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/it_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Failed\")"
                            + "</script>");
                    rd.include(request, response);

                }

                break;

                
            case "TotalFarmSize":
            case "TreatedFarmSize":

                if (manager.editITandTR("farms", Float.parseFloat(oldValues), Float.parseFloat(newValues), fields, fNum)) {

                    //Successful Save Action Block of Code
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/it_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Successful\")"
                            + "</script>");
                    rd.include(request, response);

                } else {

                    //Failure
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/it_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Failed\")"
                            + "</script>");
                    rd.include(request, response);

                }

                break;

            case "EstTrees":

                if (manager.editITandTR("farms", Integer.parseInt(oldValues), Integer.parseInt(newValues), fields, fNum)) {

                    //Successful Save Action Block of Code
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/it_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Successful\")"
                            + "</script>");
                    rd.include(request, response);

                } else {

                    //Failure
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/it_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Failed\")"
                            + "</script>");
                    rd.include(request, response);

                }

                break;

            case "QtyFreeSeed":
            case "QtyFreeFert":
            case "QtySeedPurchase":
            case "QtyFertPurchase":

                if (manager.editITandTR("ched_replant", Integer.parseInt(oldValues), Integer.parseInt(newValues), fields, fNum)) {

                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/replant_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Successful\")"
                            + "</script>");
                    rd.include(request, response);

                } else {

                    //Failure
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/replant_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Failed\")"
                            + "</script>");
                    rd.include(request, response);

                }

                break;

            case "RPLotNumber":
            case "RPVouch":
            case "ReplantDate":

                if (manager.editITandTR("ched_replant", oldValues, newValues, fields, fNum)) {

                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/replant_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Successful\")"
                            + "</script>");
                    rd.include(request, response);

                } else {

                    //Failure
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/replant_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Failed\")"
                            + "</script>");
                    rd.include(request, response);

                }

                break;

            case "AreaReplant":
            case "GrossRPPayable":
            case "TotalDeduction":
            case "NetRPPayable":
            case "CostofSeed":
            case "CostOfFertAllocated":

                if (manager.editITandTR("ched_replant", Float.parseFloat(oldValues), Float.parseFloat(newValues), fields, fNum)) {

                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/replant_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Successful\")"
                            + "</script>");
                    rd.include(request, response);

                } else {

                    //Failure
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/replant_edits.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">"
                            + "alert(\"Saved Failed\")"
                            + "</script>");
                    rd.include(request, response);

                }

                break;

            default:

                //Failure
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/replant_edits.jsp");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">"
                        + "alert(\"Nothing Changed!!\")"
                        + "</script>");
                rd.include(request, response);

                break;

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
