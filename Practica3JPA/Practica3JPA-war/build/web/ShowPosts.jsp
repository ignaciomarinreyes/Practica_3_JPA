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
    public static String printTable(List<Post> posts) {
        String result = "<h3>Posts</h3>"
                + "<table style='width:100%'>";
        result += "<tr><th>ID</th><th>Título</th><th>Universidad</th><th>Carrera</th><th>Asignatura</th><th>Usuario</th><th>Número likes</th></tr>";
        for (Post post : posts) {
            result += "<tr>"
                    + "<td>" + post.getId() + "</td>"
                    + "<td>" + post.getTitle() + "</td>"
                    + "<td>" + post.getSubject().getUniversity().getName() + "</td>"
                    + "<td>" + post.getSubject().getDegree().getName() + "</td>"
                    + "<td>" + post.getSubject().getName() + "</td>"
                    + "<td>" + post.getUser().getName() + " " + post.getUser().getSurname() + "</td>"
                    + "<td>" + String.valueOf(post.getUserCollectionLike().size()) + "</td>"
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
            <%                out.println(printTable((List<Post>) request.getAttribute("posts")));
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
