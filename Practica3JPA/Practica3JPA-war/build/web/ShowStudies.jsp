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
    public static String printTable(List<Degree> degrees) {
        String result = "<h3>Estudios</h3>"
                + "<table style='width:100%'>";
        result += "<tr><th>ID</th><th>Universidad</th><th>Nombre</th></th></tr>";
        for (Degree degree : degrees) {
            result += "<tr>"
                    + "<td>" + degree.getId() + "</td>"
                    + "<td>" + degree.getUniversity().getName() + "</td>"
                    + "<td>" + degree.getName()+ "</td>"
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
                <input type='hidden' name='command' value='ShowStudies'>
                <input type='text' name='searchDegrees'>
                <input value='Buscar' type='submit'>
            </form> 
        </div>
        <div id="centerSpace">
            <%                out.println(printTable((List<Degree>) request.getAttribute("degrees")));
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
