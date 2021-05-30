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
    public static String printTable(List<Autonomouscommunity> autonomouscommunities) {
        String result = "<h3>Comunidades Autónomas</h3>"
                + "<table style='width:100%'>";
        result += "<tr><th>ID</th><th>Nombre</th></tr>";
        for (Autonomouscommunity autonomouscommunity : autonomouscommunities) {
            result += "<tr>"
                    + "<td>" + autonomouscommunity.getId() + "</td>"
                    + "<td>" + autonomouscommunity.getName() + "</td>"
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
            <%                out.println(printTable((List<Autonomouscommunity>) request.getAttribute("autonomousCommunities")));
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
