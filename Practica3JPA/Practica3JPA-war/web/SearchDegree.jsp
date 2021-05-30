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
                <select name="degrees" style="width: 400px;" required>
                    <%
                        for (Degree degree : (List<Degree>) request.getAttribute("degrees"))
                            out.println("<option value='" + degree.getId() + "'>" + degree.getName() + "</option>");
                    %>                                   
                </select><br>   
                <input type='hidden' name='command' value='SearchSubject'>          
                <input value='Siguiente' type='submit'>
            </form>
        </div>
    </body>
</html>
