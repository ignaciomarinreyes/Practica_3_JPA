<%@page import="java.util.List"%>
<%@page import="entities.User"%>
<%@page import="entities.Comment"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    public static String printTable(List<User> users) {
        String result = "<h3>Usuarios</h3>"
                + "<table style='width:100%'>";
        result += "<tr><th>ID</th><th>Nombre</th><th>Apellidos</th><th>Apodo</th><th>Contraseña</th><th>Perfil</th></tr>";
        for (User user : users) {
            result += "<tr>"
                    + "<td>" + user.getId() + "</td>"
                    + "<td>" + user.getName() + "</td>"
                    + "<td>" + user.getSurname() + "</td>"
                    + "<td>" + user.getNickname() + "</td>"
                    + "<td>" + user.getPassword() + "</td>"
                    + "<td>" + user.getRol().getName() + "</td>"
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
                <input type='hidden' name='command' value='ShowUsers'>
                <input type='text' name='searchUsers'>
                <input value='Buscar' type='submit'>
            </form> 
        </div>
        <div id="centerSpace">
            <%                out.println(printTable((List<User>) request.getAttribute("users")));
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
