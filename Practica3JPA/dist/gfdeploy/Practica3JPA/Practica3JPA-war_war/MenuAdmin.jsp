<div id="menu">          
    <form action='FrontController' method='GET' style='float: right; margin-right: 10px;'>
        <input type='hidden' name='command' value='Logout'>      
        <input value='Cerrar Sesión' type='submit'>
    </form> 
    <form action='FrontController' style='float: right; margin-right: 10px;'>
        <input type='hidden' name='command' value='ShowPostsFollowedSubject'>        
        <input value='Inicio' type='submit'>
    </form>
    <form action='FrontController' style='float: left; margin-right: 10px; margin-left: 10px;'>
        <input type='hidden' name='command' value='ShowSubjects'>        
        <input value='Asignaturas Seguidas' type='submit'>
    </form>
    <form action='FrontController' style='float: left; margin-right: 10px; margin-left: 10px;'>
        <input type='hidden' name='command' value='ShowSubjectsAll'>        
        <input value='Asignaturas' type='submit'>
    </form>
    <form action='FrontController' style='float: left; margin-right: 10px;'>
        <input type='hidden' name='command' value='ShowStudies'>
        <input type='hidden' name='searchDegrees' value=''>   
        <input type='hidden' name='page' value='1'>       
        <input value='Carreras' type='submit'>
    </form>  
    <form action='FrontController' style='float: left; margin-right: 10px;'>
        <input type='hidden' name='command' value='ShowUsers'>
        <input type='hidden' name='searchUsers' value=''>         
        <input value='Usuarios' type='submit'>
    </form>
    <form action='FrontController' style='float: left; margin-right: 10px;'>
        <input type='hidden' name='command' value='ShowProvinces'>        
        <input value='Provincias' type='submit'>
    </form> 
    <form action='FrontController' style='float: left; margin-right: 10px;'>
        <input type='hidden' name='command' value='ShowAutonomousCommunities'>        
        <input value='Comunidades Autónomas' type='submit'>
    </form>
    <form action='FrontController' style='float: left; margin-right: 10px;'>
        <input type='hidden' name='command' value='ShowAddress'>        
        <input value='Direcciones' type='submit'>
    </form>
    <form action='FrontController' style='float: left; margin-right: 10px;'>
        <input type='hidden' name='command' value='ShowPosts'>        
        <input value='Posts' type='submit'>
    </form>
</form> 
</div>