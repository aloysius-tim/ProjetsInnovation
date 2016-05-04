/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package projetsinnovation.server;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import projetsinnovation.common.*;
import projetsinnovation.common.model.*;

/**
 *
 * @author Sofiane
 */
public class Service implements IProjetInnovation {
    
    private IProjetInnovation model;
    
    public Service() {
        this.model = new ProjetInnovation();
    }
    
    public Response serve(Request request) {
        Class[] argsTypes = null;
        try {
            if(request.getArgs() != null) {
                argsTypes = new Class[request.getArgs().length];
                for(int i = 0; i < request.getArgs().length; i++) {
                    if(request.getArgs()[i] != null)
                        argsTypes[i] = request.getArgs()[i].getClass();
                }
            }
            Method m = this.getClass().getMethod(request.getMethod(), argsTypes);
            return new Response(Status.CODE200, "OK", (Serializable)m.invoke(this, request.getArgs()));
        } catch(NoSuchMethodException | IllegalArgumentException e) {
            String message = "NoSuchMethod : ";
            message += request.getMethod() + "(";
            if(request.getArgs() != null) {
                for(int i = 0; i < argsTypes.length; i++) {
                    if(argsTypes[i] != null) {
                        message += argsTypes[i].getSimpleName();
                        if(!((i+1) == argsTypes.length)) message += ",";
                    }   
                }
            }
            message += ")";
            return new Response(Status.CODE404, message, e);
        } catch(IllegalAccessException e) {
            return new Response(Status.CODE403, "Oops... Authorisation non accordée.", e);
        } catch(InvocationTargetException e) {
            return new Response(Status.CODE500, "Oops... Le serveur a planté :/", e);
        }
    }
    
    @Override
    public ArrayList<Idea> getIdeas() {
        return this.model.getIdeas();
    }
    
    @Override
    public Idea createIdea(Idea idea) {
        return this.model.createIdea(idea);
    }
    
    @Override
    public ArrayList<Student> getTeam(Idea idea) {
        return this.model.getTeam(idea);
    }
    
    @Override
    public Idea subscribeTo(Idea idea, Student student) {
        return this.model.subscribeTo(idea, student);
    }
}
