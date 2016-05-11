/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package projetsinnovation.common;

import java.io.Serializable;

/**
 * The type Request.
 *
 * @author Sofiane & Tim
 */
public class Request implements Serializable {
    
    private Object[] args;
    private String method;

    /**
     * Instantiates a new Request.
     *
     * @param method the method
     * @param args   the args
     */
    public Request(String method, Object[] args) {
        this.method = method;
        this.args = args;
    }

    /**
     * Instantiates a new Request.
     *
     * @param method the method
     */
    public Request(String method) {
        this.method = method;
    }

    /**
     * Get args object [ ].
     *
     * @return the object [ ]
     */
    public Object[] getArgs() {
        return args;
    }

    /**
     * Sets args.
     *
     * @param args the args
     */
    public void setArgs(Object[] args) {
        this.args = args;
    }

    /**
     * Gets method.
     *
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets method.
     *
     * @param method the method
     */
    public void setMethod(String method) {
        this.method = method;
    }
    
    @Override
    public String toString() {
        String r = "\n\tmethod \t\t: " + method + "\n\targs \t\t: [";
        if(this.args != null) {
            for(Object o : this.args) {
                if(o != null) {
                    r += "\n\t\t";
                    r += o.toString();
                }
            }
            r += "\n\t";
        }
        r += "]";
        return r;
    }
}
