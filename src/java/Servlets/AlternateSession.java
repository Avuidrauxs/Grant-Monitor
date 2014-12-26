/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.FarmerManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author audax
 */

public class AlternateSession extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //private static final String user ="audax";
    //private static final String pass ="admin";
    FarmerManager manager;

    @Override
    public void init() throws ServletException {

        manager = new FarmerManager();

        super.init(); //To change body of generated methods, choose Tools | Templates.
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<String> stf;
        stf = manager.AllStaff();

        //response.setContentType("text/jsp");
        
        //Receiving parameters from login page
        String uname = (request.getParameter("userN")).trim();
        String pword = (request.getParameter("passW")).trim();
        String login = uname + "||" + pword;

        if (stf.contains(login)) {

            HttpSession session = request.getSession();
            session.setAttribute("user", "Administrator");
            


//setting session to expiry in 8 hours
            session.setMaxInactiveInterval(480 * 60);
            Cookie userName = new Cookie("user", uname);
            userName.setMaxAge(480 * 60);
            response.addCookie(userName);
            response.setHeader("DASHBOARD", "dashboard.jsp");
            response.sendRedirect("dashboard.jsp");
//              RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard.jsp");
//              
//            PrintWriter out = response.getWriter();
//            //out.println("");
//            rd.include(request, response);
            
            
            

        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");

            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">"
                    + "alert(\"Wrong Password or Password\")"
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
