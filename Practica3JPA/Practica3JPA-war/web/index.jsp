<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="template.css"/>
        <title>UniversityBook</title> 
    </head>
    <body>
        <%
            if (request.getSession().getAttribute("user") != null) {
                response.sendRedirect("/Practica_3_JPA_UniversityBook-war/FrontController?command=Login");
            }
        %>
        <header id="title"><span>UniversityBook</span></header> 
        <div id="divlogged">
            <form action='FrontController' method='POST'>
                <div style="padding: 10px;">
                    <span>Nombre: </span>
                    <input type='text' name='nickname' value='admin'> 
                </div>  
                <div style="padding: 10px;">
                    <span>Contrase�a: </span>
                    <input type='text' name='password' value='1234'> 
                </div>  
                <input type='hidden' name='command' value='Login'> 
                <input style="padding: 10px;" value='Iniciar Sesi�n' type='submit'>
            </form>
        </div>   
    </body>   
</html>



