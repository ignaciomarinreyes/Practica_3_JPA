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
                <select name="subjects" style="width: 400px;" required>
                    <%
                        for (Subject subject : (List<Subject>) request.getAttribute("subjects"))
                            out.println("<option value='" + subject.getId() + "'>" + subject.getName() + "</option>");
                    %> 
                </select><br>     
                <input type='hidden' name='command' value='ShowPostsSubject'>          
                <input value='Buscar' type='submit'>
            </form>
        </div>
    </body>
</html>
