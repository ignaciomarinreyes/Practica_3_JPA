<%@page import="entities.Subject"%>
<%@page import="java.util.List"%>
<%@page import="entities.User"%>
<%@page import="entities.Comment"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    public static String printTable(List<Subject> subjects) {
        String result = "<h3>Asignaturas Seguidas</h3>"
                + "<table style='width:100%'>";
        result += "<tr><th>ID</th><th>Nombre</th><th>Grado</th><th>Universidad</th><th>Dejar de seguir</th></tr>";
        for (Subject subject : subjects) {
            result += "<tr>"
                    + "<td>" + subject.getId() + "</td>"
                    + "<td>" + subject.getName() + "</td>"
                    + "<td>" + subject.getDegree().getName() + "</td>"
                    + "<td>" + subject.getUniversity().getName() + "</td>"
                    + "<td style='text-align: center;'><form action='FrontController' style='display: inline-block;'>"
                    + "<input type='image' src='Images/eliminar.png' width='30' height='30' alt='next'>"
                    + "<input type='hidden' name='command' value='UnFollowSubject'>"
                    + "<input type='hidden' name='idFollowedSubject' value='" + subject.getId() + "'>"
                    + "</form></td>"
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
        <%@ include file="Menu.jsp"%>    
        <div id="centerSpace">
            <%                out.println(printTable((List<Subject>) request.getAttribute("followedSubjects")));
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>


