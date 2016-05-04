/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.common;

import java.io.Serializable;
import projetsinnovation.server.Speaker;

/**
 *
 * @author Sofiane
 */
public class Response implements Serializable {
    private Status status;
    private String message;
    private Serializable value;

    public Response(Status status, String message, Serializable value) {
        this.status = status;
        this.message = message;
        this.value = value;
    }
    
    public String getMessage() { return message; }
    public Serializable getValue() { return value; }
    
    @Override
    public String toString() {
        if(status == null) status = Status.NOSTATUS;
        if(message == null) message = "null";
        if(value == null) value = "null";        
        
        String r = "\n\tstatus \t\t: " + status.toString();
        r += "\n\tmessage \t: " + message;
        r += "\n\tvalue \t\t: [";
        if(this.value instanceof Iterable || this.value instanceof Object[]) {
            
            Iterable l = (Iterable) this.value;
            for(Object o : l) {
                r += "\n\t\t";
                r += o.toString();
                
            }
        }
        r += "\n\t";
        
        r += "]";
        return r;
    }
}
