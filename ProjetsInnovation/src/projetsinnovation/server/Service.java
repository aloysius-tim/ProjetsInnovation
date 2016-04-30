/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.server;

import projetsinnovation.common.*;

/**
 *
 * @author Sofiane
 */
public class Service {
    
    private Request request;
    private Response response;
    
    
    public void setRequest(Request request) {
        this.request = request;
    }
    
    private void setResponse() {
        
    }
    
    public Response getResponse() {
        this.setResponse();
        return this.response;
    }
}
