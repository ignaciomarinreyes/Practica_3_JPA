package controller.commands;

import control.ProvinceFacade;
import entities.Province;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class UpdateProvince extends FrontCommand {

    private ProvinceFacade provinceFacade;

    @Override
    public void process() {
        try {
            provinceFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/ProvinceFacade!control.ProvinceFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        try{
            Province province = provinceFacade.find(new Integer(request.getParameter("idProvince")));
            province.setName(request.getParameter("newName"));
            provinceFacade.edit(province);
        }catch(Exception e){
            forward("/OperationFailed.jsp");
        }
        request.setAttribute("provinces", provinceFacade.findAllNameQuery());
        forward("/ShowProvinces.jsp");
    }

}
