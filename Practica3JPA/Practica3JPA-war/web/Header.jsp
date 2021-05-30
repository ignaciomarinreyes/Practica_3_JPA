<%
    if (request.getSession().getAttribute("user") == null && !request.getRequestURI().equals("/Practica3JPA-war/AddUser.jsp")) {
        response.sendRedirect("index.jsp");
    }
%>
<header id="title"><span>UniversityBook</span></header> 

