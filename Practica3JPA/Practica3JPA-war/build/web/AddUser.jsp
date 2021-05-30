<%@page import="entities.Rol"%>
<%@page import="entities.User"%>
<%@page import="entities.Province"%>
<%@page import="entities.Degree"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="template.css"/>
        <title>User</title>
    </head>
    <body>
        <%@ include file="Header.jsp"%>
        <%        if (((User) session.getAttribute("user")) != null) {%>
        <%@ include file="MenuAdmin.jsp"%>  
        <%            }
        %>
        <div id="centerSpace">
            <form action='FrontController' method='GET' style="text-align: center;">
                <p>Nombre</p>
                <input type="text" name="name" required style="width: 417px;"><br>
                <p>Apellidos</p>
                <input type="text" name="surname" required style="width: 417px;"><br>
                <p>Apodo</p>
                <input type="text" name="nickname" required style="width: 417px;"><br>
                <p>Contraseña</p>
                <input type="password" name="password" required style="width: 417px;"><br>
                <p>Rol</p>
                <select name="rol" style="width: 417px;" required>
                    <%                        for (Rol rol : (List<Rol>) request.getAttribute("roles"))
                            out.println("<option value='" + rol.getId() + "'>" + rol.getName() + "</option>");
                    %>
                </select><br>
                <p>Carrera</p>
                <select name="degree" style="width: 417px;" required>
                    <%                        for (Degree degree : (List<Degree>) request.getAttribute("degrees"))
                            out.println("<option value='" + degree.getId() + "'>" + degree.getUniversity().getName() + " " + degree.getName() + "</option>");
                    %>
                </select><br>
                <p>Calle</p>
                <input type="text" name="street" required style="width: 417px;"><br>
                <p>Número</p>
                <input type="text" name="number" required style="width: 417px;"><br>
                <p>Código postal</p>
                <input type="text" name="cp" required style="width: 417px;"><br>
                <p>Localidad</p>
                <input type="text" name="localidad" required style="width: 417px;"><br>
                <p>Provincia</p>
                <select name="provinces" style="width: 417px;" required>
                    <%                        for (Province province : (List<Province>) request.getAttribute("provinces"))
                            out.println("<option value='" + province.getId() + "'>" + province.getName() + "</option>");
                    %>
                </select><br>
                <button type="submit">Crear</button>
                <input type='hidden' name='command' value='AddUser'>  
            </form>
        </div>
    </body>
</html>


