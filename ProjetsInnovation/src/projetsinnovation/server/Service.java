/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.server;

import java.io.Serializable;
import projetsinnovation.common.*;
import projetsinnovation.common.model.Idea;
import projetsinnovation.common.model.Student;

/**
 *
 * @author Sofiane
 */
public class Service implements IProjetInnovation {
    
    public Response serve(Request request) {
        return null;
    }

    @Override
    public Serializable getIdeas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Serializable createIdea(Student author, Idea idea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
