/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.server;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import projetsinnovation.common.*;
import projetsinnovation.common.model.Idea;
import projetsinnovation.common.model.Student;

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
        try {
            Method m = this.getClass().getMethod(request.getMethod());
            return new Response(Status.CODE200, "OK", (Serializable)m.invoke(this));
        } catch(NoSuchMethodException e) {
            return new Response(Status.CODE404, "La méthode demandée n'existe pas", e);
        } catch(IllegalAccessException e) {
            return new Response(Status.CODE403, "La requête n'est pas autorisée", e);
        } catch(IllegalArgumentException e) {
            return new Response(Status.CODE404, "La méthode demandée n'existe pas", e);
        } catch(InvocationTargetException e) {
            return new Response(Status.CODE500, "Un problème est survenu lors de l'appel de la méthode", e);
        }
    }

    @Override
    public Serializable getIdeas() {
        return this.model.getIdeas();
    }

    @Override
    public Serializable createIdea(Idea idea) {
        return this.model.createIdea(idea);
    }
}
