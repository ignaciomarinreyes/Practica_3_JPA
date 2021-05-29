package controller.commands;

import control.ProvinceFacade;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DeleteProvince extends FrontCommand {

    private ProvinceFacade provinceFacade;

    @Override
    public void process() {
        try {
            provinceFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/ProvinceFacade!control.ProvinceFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        try{
            provinceFacade.remove(provinceFacade.find(new Integer(request.getParameter("idProvince"))));
        }catch(Exception e){
            forward("/OperationFailed.jsp");
        }
        request.setAttribute("provinces", provinceFacade.findAllNameQuery());
        forward("/ShowProvinces.jsp");
    }

}
