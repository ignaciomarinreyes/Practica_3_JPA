<%@page import="entities.Province"%>
<%@page import="entities.Degree"%>
<%@page import="java.util.List"%>
<%@page import="entities.User"%>
<%@page import="entities.Comment"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    public static String printTable(List<Province> provinces) {
        String result = "<h3>Provincias</h3>"
                + "<table style='width:100%'>";
        result += "<tr><th>ID</th><th>Nombre</th><th>Comunidad Autónoma</th><th>Opciones</th></tr>";
        for (Province province : provinces) {
            result += "<tr>"
                    + "<td>" + province.getId() + "</td>"
                    + "<td>" + province.getName() + "</td>"
                    + "<td>" + province.getAutonomouscommunity().getName() + "</td>"
                    + "<td style='text-align: center;'>"
                        + "<form action='FrontController' style='display: inline-block;'>" 
                            + "<input type='image' src='Images/editar.png' width='30' height='30' alt='next'>"
                            + "<input type='hidden' name='command' value='UpdateProvince'>"
                            + "<input type='hidden' name='idProvince' value='" + province.getId() + "'>"
                        + "</form>"
                        + "<form action='FrontController' style='display: inline-block;'>" 
                            + "<input type='image' src='Images/eliminar.png' width='30' height='30' alt='next'>"
                            + "<input type='hidden' name='command' value='DeleteProvince'>"
                            + "<input type='hidden' name='idProvince' value='" + province.getId() + "'>"
                        + "</form>"                            
                    + "</td>"
                    + "</tr>";
        }
        result += "</table>";
        return result;
    }

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="template.css"/>
    </head>
    <body>
        <%@ include file="Header.jsp"%>    
        <%@ include file="MenuAdmin.jsp"%>
        <div id="searchMenu">
            <form action='FrontController' method='GET' style='float: left; margin-left: 10px;'>                 
                <input type='hidden' name='command' value='NewProvince'>
                <input value='Añadir' type='submit'>
            </form> 
        </div>
        <div id="centerSpace">
            <%                out.println(printTable((List<Province>) request.getAttribute("provinces")));
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
