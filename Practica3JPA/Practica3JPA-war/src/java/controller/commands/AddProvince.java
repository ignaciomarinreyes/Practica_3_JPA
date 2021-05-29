package controller.commands;

import control.AutonomouscommunityFacade;
import control.ProvinceFacade;
import entities.Province;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AddProvince extends FrontCommand {

    private ProvinceFacade provinceFacade;
    private AutonomouscommunityFacade autonomouscommunityFacade;

    @Override
    public void process() {
        try {
            provinceFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/ProvinceFacade!control.ProvinceFacade");
            autonomouscommunityFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/AutonomouscommunityFacade!control.AutonomouscommunityFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        Province province = new Province(request.getParameter("name"));
        province.setAutonomouscommunity(autonomouscommunityFacade.find(new Integer(request.getParameter("autonomousComunnity"))));
        provinceFacade.create(province);
        request.setAttribute("provinces", provinceFacade.findAllNameQuery());
        forward("/ShowProvinces.jsp");
    }

}
