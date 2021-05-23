
package entities;

import javax.persistence.Embeddable;

@Embeddable
public class ZipCode {
  
    String cp;

    public ZipCode() {
    }
    
    public ZipCode(String cp) {
        this.cp = cp;
    }
    
}
