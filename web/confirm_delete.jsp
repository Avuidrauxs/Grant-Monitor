<%-- 
    Document   : confirm_delete
    Created on : Dec 16, 2014, 8:37:30 AM
    Author     : audax
--%>
<%@page import="Controller.FarmerManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmed Delete</title>
    </head>
    <body>
        
        <% 
        
        String farmNumber = request.getParameter("deleted");
        FarmerManager manager = new FarmerManager();
        
        if(farmNumber == "")
        {
        
        %>
        
        <script>
            alert("Farm doesn't exist");
            
        </script>
        
        
        <%
        }
        
        else{
            
            if(manager.deleteFarm(farmNumber))
            {
            
                
                
            %>
            <script>
                alert("Farm Deleted succesfully")
            </script>    
            
            <%
        }//inner IF ends here
            
            
            else{
            
            
           %> 
           <script>
               alert("Farm delete failed");
           </script>
            
           <% }//inner else ends here
            
            
            
        }//else ends here
            
            %>
    </body>
</html>
