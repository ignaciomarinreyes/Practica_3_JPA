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
                    + "<td>" + degree.getName() + "</td>"
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
                <input type='text' name='searchDegrees' value='<%= (String) request.getParameter("searchDegrees") == null ? "" : (String) request.getParameter("searchDegrees") %>'>
                <input type='hidden' name='page' value='1'>
                <input value='Buscar' type='submit'>
            </form> 
        </div>
        <div id="centerSpace">
            <%                out.println(printTable((List<Degree>) request.getAttribute("degrees")));
            %>
        </div>
        <div id="paginacion" >
            <form action='FrontController' style='display: inline-block;'>                 
                <input type='image' src="Images/before.png" width="30" height="30" alt="next">
                <input type='hidden' name='command' value='ShowStudies'>
                <input type='hidden' name='searchDegrees' value='<%= (String) request.getParameter("searchDegrees") %>'>
                <input type='hidden' name='page' value='<%= (String) request.getAttribute("before") %>'>
            </form> 
            <%
                for (int i = 1; i <= (Integer) request.getAttribute("numberPages"); i++) {
                    out.println("<form action='FrontController' style='display: inline-block; margin-right: 10px;'> ");
                    out.println("<input type='hidden' name='command' value='ShowStudies'> ");
                    out.println("<input type='hidden' name='page' value='" + i + "'> ");
                    out.println("<input type='hidden' name='searchDegrees' value='" + (String) request.getParameter("searchDegrees") + "'>");
                    out.println("<input value='" + i +  "' type='submit'>");
                    out.println("</form>");
                }
            %>
            <form action='FrontController' style='display: inline-block;'>                 
                <input type='image' src="Images/next.png" width="30" height="30" alt="next">
                <input type='hidden' name='command' value='ShowStudies'>
                <input type='hidden' name='searchDegrees' value='<%= (String) request.getParameter("searchDegrees") %>'>
                <input type='hidden' name='page' value='<%= (String) request.getAttribute("next") %>'>
            </form> 
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
