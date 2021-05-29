package controller.commands;

import control.AutonomouscommunityFacade;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowAutonomousCommunities extends FrontCommand {

    private AutonomouscommunityFacade autonomouscommunityFacade;

    @Override
    public void process() {
        try {
            autonomouscommunityFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/AutonomouscommunityFacade!control.AutonomouscommunityFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("autonomousCommunities", autonomouscommunityFacade.findAll());
        forward("/ShowAutonomousCommunities.jsp");
    }

}
