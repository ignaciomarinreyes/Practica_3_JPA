<%@page import="entities.Subject"%>
<%@page import="entities.Degree"%>
<%@page import="entities.University"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="template.css"/>
        <title>Search Subject</title>
    </head>
    <body>
        <%@ include file="Header.jsp"%>    
        <%@ include file="Menu.jsp"%>    
        <div id="centerSpace">
            <form class='formSearch' action='FrontController' method='GET' style="text-align: center;">  
                <select name="universities" style="width: 400px;" required>
                    <%                        for (University university : (List<University>) request.getAttribute("universities"))
                            out.println("<option value='" + university.getId() + "'>" + university.getName() + "</option>");
                    %>
                </select><br>
                <input type='hidden' name='command' value='SearchDegree'>          
                <input value='Siguiente' type='submit'>
            </form>
        </div>
    </body>
</html>
