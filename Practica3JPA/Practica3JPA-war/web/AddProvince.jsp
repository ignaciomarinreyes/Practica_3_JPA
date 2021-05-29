<%@page import="entities.Autonomouscommunity"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="template.css"/>
        <title>Publish</title>
    </head>
    <body>
        <%@ include file="Header.jsp"%>    
        <%@ include file="MenuAdmin.jsp"%>    
        <div id="centerSpace">
            <form action='FrontController' method='GET'>
                <p>Nombre: </p>
                <input type="text" name="name" required><br>
                <p>Comunidad Autónoma: </p>
                <select width="200px" name="autonomousComunnity" required>
                <%                        
                    for(Autonomouscommunity autonomouscommunity :(List<Autonomouscommunity>)request.getAttribute("autonomousCommunity")){
                        out.println("<option value='" + autonomouscommunity.getId() + "'>" + autonomouscommunity.getName() + "</option>");
                    }
                %>
                </select>
                <p><button type="submit">Crear</button></p>
                <input type='hidden' name='command' value='AddProvince'>  
            </form>
        </div>
    </body>
</html>


