<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="template.css"/>
        <title>Publish</title>
    </head>
    <body>
        <%@ include file="Header.jsp"%>    
        <%@ include file="Menu.jsp"%>    
        <div id="centerSpace">
            <form action='FrontController' method='GET' style="text-align: center;">
                <p>Título</p>
                <input type="text" name="title" required><br>
                <p>Mensaje</p>
                <textarea name="content" rows="4" cols="50" required></textarea><br>
                <button type="submit">Publicar</button>
                <input type='hidden' id='subjects' name='subject' value='<%= request.getParameter("subject")%>'>               
                <input type='hidden' name='command' value='Publish'>  
            </form>
        </div>
    </body>
</html>


