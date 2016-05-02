/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.server;

import java.io.Serializable;
import java.lang.reflect.Method;
import projetsinnovation.common.*;
import projetsinnovation.common.model.Idea;
import projetsinnovation.common.model.Student;

/**
 *
 * @author Sofiane
 */
public class Service implements IProjetInnovation {
    
    public Response serve(Request request) {
        try {
            Method m = this.getClass().getMethod(request.getMethod());
            Serializable result = (Serializable)m.invoke(this);
            return new Response(Status.CODE200, "Response message OK", result);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public Serializable getIdeas() {
        return "Voici les idées !";
    }

    @Override
    public Serializable createIdea(Idea idea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
