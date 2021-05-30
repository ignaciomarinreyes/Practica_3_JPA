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

public class ShowAddUser extends FrontCommand {

    private ProvinceFacade provinceFacade;
    private DegreeFacade degreeFacade;
    private RolFacade rolFacade;


    @Override
    public void process() {
        try {
            provinceFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/ProvinceFacade!control.ProvinceFacade");
            degreeFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/DegreeFacade!control.DegreeFacade");
            rolFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/RolFacade!control.RolFacade");           
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("provinces", provinceFacade.findAll());
        request.setAttribute("degrees", degreeFacade.findAll());
        request.setAttribute("roles", rolFacade.findAll());
        forward("/AddUser.jsp");
    }

}
