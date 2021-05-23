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
        <input type='hidden' name='command' value='ShowStudies'>
        <input type='hidden' name='searchDegrees' value=''>   
        <input type='hidden' name='page' value='1'>       
        <input value='Estudios' type='submit'>
    </form>  
    <form action='FrontController' style='float: left; margin-right: 10px;'>
        <input type='hidden' name='command' value='ShowUsers'>
        <input type='hidden' name='searchUsers' value=''>         
        <input value='Users' type='submit'>
    </form>
    <form action='FrontController' style='float: left; margin-right: 10px;'>
        <input type='hidden' name='command' value='ShowSubjects'>        
        <input value='Subjects' type='submit'>
    </form>
    <form action='FrontController' style='float: left; margin-right: 10px;'>
        <input type='hidden' name='command' value='ShowCourses'>        
        <input value='Courses' type='submit'>
    </form> 
</form> 
</div>