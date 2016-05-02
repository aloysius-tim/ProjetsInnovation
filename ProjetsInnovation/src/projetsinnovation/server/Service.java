/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.server;

import java.io.Serializable;
import projetsinnovation.common.*;
import projetsinnovation.common.model.Idea;
import projetsinnovation.common.model.ProjetInnovation;
import projetsinnovation.common.model.Student;

/**
 *
 * @author Sofiane
 */
public class Service implements IProjetInnovation {
    private ProjetInnovation projetInnovation;

    public Service() {
        this.projetInnovation=new ProjetInnovation();
    }

    public Response serve(Request request) {
        return null;
    }

    @Override
    public Serializable getIdeas() {
        return this.projetInnovation.getIdeas();
    }

    @Override
    public Serializable createIdea(String description, String technologies, Student author) {
        return this.projetInnovation.createIdea(description, technologies, author);
    }
}
