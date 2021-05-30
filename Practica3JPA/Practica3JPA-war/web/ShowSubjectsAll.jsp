<%@page import="entities.Subject"%>
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
    public static String printTable(List<Subject> subjects) {
        String result = "<h3>Asignaturas</h3>"
                + "<table style='width:100%'>";
        result += "<tr><th>ID</th><th>Nombre</th><th>Universidad</th><th>Carrera</th><th>Profesor</th><th>Curso</th></tr>";
        for (Subject subject : subjects) {
            result += "<tr>"
                    + "<td>" + subject.getId() + "</td>"
                    + "<td>" + subject.getName() + "</td>"
                    + "<td>" + subject.getUniversity().getName() + "</td>"
                    + "<td>" + subject.getDegree().getName() + "</td>"
                    + "<td>" + subject.getTeacher().getName() + " " + subject.getTeacher().getSurname() + "</td>"
                    + "<td>" + subject.getCourse() + "</td>"

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
            <%                out.println(printTable((List<Subject>) request.getAttribute("subjectsAll")));
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
