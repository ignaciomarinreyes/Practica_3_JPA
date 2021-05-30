<%@page import="entities.Address"%>
<%@page import="entities.Autonomouscommunity"%>
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
    public static String printTable(List<Address> addresses) {
        String result = "<h3>Direcciones</h3>"
                + "<table style='width:100%'>";
        result += "<tr><th>ID</th><th>Calle</th><th>Número</th><th>Código postal</th><th>Localidad</th><th>Provincia</th></tr>";
        for (Address address : addresses) {
            result += "<tr>"
                    + "<td>" + address.getId() + "</td>"
                    + "<td>" + address.getStreet() + "</td>"
                    + "<td>" + address.getNumber() + "</td>"
                    + "<td>" + address.getZipCode().getCp() + "</td>"
                    + "<td>" + address.getZipCode().getLocalidad() + "</td>"
                    + "<td>" + address.getProvince().getName() + "</td>"
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
        <div id="centerSpace">
            <%                out.println(printTable((List<Address>) request.getAttribute("address")));
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
