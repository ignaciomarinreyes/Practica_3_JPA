package controller.commands;

import control.AddressFacade;
import control.AutonomouscommunityFacade;
import control.DegreeFacade;
import control.ProvinceFacade;
import control.RolFacade;
import control.UserFacade;
import entities.Address;
import entities.Degree;
import entities.Province;
import entities.Rol;
import entities.University;
import entities.User;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AddUser extends FrontCommand {

    private UserFacade userFacade;
    private ProvinceFacade provinceFacade;
    private AddressFacade addressFacade;
    private DegreeFacade degreeFacade;
    private RolFacade rolFacade;


    @Override
    public void process() {
        try {
            userFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/UserFacade!control.UserFacade");
            provinceFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/ProvinceFacade!control.ProvinceFacade");
            addressFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/AddressFacade!control.AddressFacade");
            degreeFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/DegreeFacade!control.DegreeFacade");
            rolFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/RolFacade!control.RolFacade");           
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        Rol rol = rolFacade.find(new Integer(request.getParameter("rol")));
        Degree degree = degreeFacade.find(new Integer(request.getParameter("degree")));
        University university = degree.getUniversity();
        Address address = new Address(request.getParameter("street"), request.getParameter("number"), request.getParameter("cp"), request.getParameter("localidad"));
        Province province = provinceFacade.find(new Integer(request.getParameter("provinces")));
        address.setProvince(province);
        addressFacade.create(address);
        User user = new User(request.getParameter("nickname"), request.getParameter("password"), request.getParameter("name"), request.getParameter("surname"));
        user.setAddress(address);
        user.setDegree(degree);
        user.setUniversity(university);
        user.setRol(rol);
        userFacade.create(user);
        if(((User)request.getSession().getAttribute("user")) != null){
            forward("/OperationSuccesful.jsp");
        } else {
            forward("/index.jsp");
        }
    }

}
