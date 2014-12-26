<%-- 
    Document   : confirm_update
    Created on : Dec 16, 2014, 8:37:30 AM
    Author     : audax
--%>
<%@page import="Controller.FarmerManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmed Update</title>
    </head>
    <body>
        
        <% 
        
        String farmNumber = request.getParameter("oldVal");
        String newFarmNumber = request.getParameter("newVal");
        FarmerManager manager = new FarmerManager();
        
        if(farmNumber == ""|| newFarmNumber == "")
        {
        
        %>
        
        <script>
            alert("Farm doesn't exist");
            
        </script>
        
        
        <%
        }
        
        else{
            
            if(manager.editFarmNumber(farmNumber, newFarmNumber))
            {
            
                
                
            %>
            <script>
                alert("Farm Number changed succesfully")
            </script>    
            
            <%
        }//inner IF ends here
            
            
            else{
            
            
           %> 
           <script>
               alert("Farm Change FAiled");
           </script>
            
           <% }//inner else ends here
            
            
            
        }//else ends here
            
            %>
    </body>
</html>
