/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.common;

import java.io.Serializable;

/**
 *
 * @author Sofiane
 */
public class Request implements Serializable {
    
    private Object[] args;
    private String method;

    public Request(String method, Object[] args) {
        this.method = method;
        this.args = args;
    }
    
    public Request(String method) {
        this.method = method;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
    
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
