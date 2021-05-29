
package entities;

import javax.persistence.Embeddable;

@Embeddable
public class ZipCode {
  
    String cp;
    String localidad;

    public ZipCode() {
    }
    
    public ZipCode(String cp, String localidad) {
        this.cp = cp;
        this.localidad = localidad;
    }
    
}
