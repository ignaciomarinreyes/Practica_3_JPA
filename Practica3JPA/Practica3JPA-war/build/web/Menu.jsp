<%@page import="entities.Subject"%>
<%@page import="entities.Rol"%>
<%@page import="entities.User"%>
<div id="menu">
    <form action='FrontController' method='GET' style='float: left; margin-left: 10px;'>                 
        <input type='hidden' name='command' value='SearchSubject'>   
        <%
            if (request.getRequestURI().equals("/Practica3JPA-war/ShowPostsSubject.jsp")) {
                out.println("<input value='Buscar' style='background-color: #9BC1E4;' type='submit'>");
                out.println("</form>");
                out.println("<span style='display: inline-block;'>" + ((Subject) request.getAttribute("subjectChoosen")).getName() + "</span>");
                out.println("<form action='FrontController' method='GET' style='float: left; margin-right: 10px;'>");
                out.println("<input type='hidden' name='command' value='AddFavouriteSubject'>");
                out.println("<input type='hidden' name='idSubject' value='" + ((Subject) request.getAttribute("subjectChoosen")).getId() + "'>");
                out.println("<input value='A�adir a Favoritos' type='submit' style='margin-left: 7px;'>");
                out.println("</form> ");
            } else {
                out.println("<input value='Buscar' style='background-color: none;' type='submit'>");
                out.println("</form>");
            }
            out.println("<form action='FrontController' method='GET' style='float: right; margin-right: 10px;'>");
            out.println("<input type='hidden' name='command' value='Logout'> ");
            out.println("<input value='Cerrar Sesi�n' type='submit'>");
            out.println("</form> ");
            out.println("<form action='FrontController' style='float: right; margin-right: 10px;'> ");
            out.println("<input type='hidden' name='command' value='Configuracion'> ");
            out.println("<input value='Configuraci�n' type='submit'>");
            out.println("</form>");
            out.println("<form action='FrontController' style='float: right; margin-right: 10px;'> ");
            out.println("<input type='hidden' name='command' value='ShowFavouriteSubjects'> ");
            if (request.getRequestURI().equals("/Practica3JPA-war/ShowFavouriteSubjects.jsp")) {
                out.println("<input value='Asignaturas Favoritas' type='submit' style='background-color: #9BC1E4;'>");
            } else {
                out.println("<input value='Asignaturas Favoritas' type='submit'>");
            }
            out.println("</form>");
            out.println("<form action='FrontController' style='float: right; margin-right: 10px;'>");
            if (request.getRequestURI().equals("/Practica3JPA-war/ShowMyPosts.jsp")) {
                out.println("<input value='Perfil' type='submit' style='background-color: #9BC1E4;'>");
            } else {
                out.println("<input value='Perfil' type='submit'>");
            }
            out.println("<input type='hidden' name='command' value='ShowMyPosts'>");
            out.println("</form>");
            out.println("<form action='FrontController' style='float: right; margin-right: 10px;'>");
            out.println("<input type='hidden' name='command' value='ShowPostsFollowedSubject'>");
            if (request.getRequestURI().equals("/Practica3JPA-war/MainFrame.jsp")) {
                out.println("<input value='Inicio' type='submit' style='background-color: #9BC1E4;'> ");
            } else {
                out.println("<input value='Inicio' type='submit'>");
            }
            out.println("</form> ");
            if (request.getRequestURI().equals("/Practica3JPA-war/ShowPostsSubject.jsp")) {
                out.println("<form action='Publish.jsp' style='float: right; margin-right: 10px;'>");
                out.println("<input type='hidden' id='subjects' name='subject' value='" + request.getParameter("subjects") + "'> ");
                if (request.getRequestURI().equals("/Practica3JPA-war/Publish.jsp")) {
                    out.println("<input value='Publicar' type='submit' style='background-color: #9BC1E4;> ");
                } else {
                    out.println("<input value='Publicar' type='submit'>");
                }
                out.println("</form>");
            }
            if (request.getRequestURI().equals("/Practica3JPA-war/ShowPostsSubject.jsp")) {
                out.println("<form action='ProgramPublish.jsp' style='float: right; margin-right: 10px;'>");
                out.println("<input type='hidden' id='subjects' name='subject' value='" + request.getParameter("subjects") + "'> ");
                if (request.getRequestURI().equals("/Practica3JPA-war/ProgramPublish.jsp")) {
                    out.println("<input value='Programar publicaci�n' type='submit' style='background-color: #9BC1E4;> ");
                } else {
                    out.println("<input value='Programar publicaci�n' type='submit'>");
                }
                out.println("</form>");
            }
            if (((User) session.getAttribute("user")).getRol().getId() == 1) {

                out.println("<form action='ControlPanel.jsp' style='float: right; margin-right: 10px;'>");
                if (request.getRequestURI().equals("/Practica3JPA-war/ControlPanel.jsp")) {
                    out.println("<input value='Administrador' type='submit' style='background-color: #9BC1E4;>");
                } else {
                    out.println("<input value='Panel de Control' type='submit'>");
                }
                out.println("</form> ");
            }
            out.println("<span>  </span>");
            out.println("<div style='float: right; margin-right: 10px; padding-top: 5px; background-color: white; font-size: 15pt;'>" + ((User) request.getSession().getAttribute("user")).getName() + "</div>");
            out.println("</div>");
        %>