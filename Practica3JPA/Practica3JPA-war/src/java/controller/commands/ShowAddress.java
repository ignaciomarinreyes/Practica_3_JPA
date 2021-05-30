package controller.commands;

import control.AddressFacade;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowAddress extends FrontCommand {

    private AddressFacade addressFacade;

    @Override
    public void process() {
        try {
            addressFacade = InitialContext.doLookup("java:global/Practica3JPA/Practica3JPA-ejb/AddressFacade!control.AddressFacade");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("address", addressFacade.findAll());
        forward("/ShowAddress.jsp");
    }

}
