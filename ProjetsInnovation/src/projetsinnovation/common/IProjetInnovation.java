/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.common;

import java.util.ArrayList;
import projetsinnovation.common.model.*;

/**
 * The interface Projet innovation.
 *
 * @author Sofiane & Tim
 */
public interface IProjetInnovation {
    /**
     * Gets ideas.
     *
     * @return the ideas
     */
    ArrayList<Idea> getIdeas();

    /**
     * Gets team.
     *
     * @param idea the idea
     * @return the team
     */
    ArrayList<Student> getTeam(Idea idea);

    /**
     * Create idea idea.
     *
     * @param idea the idea
     * @return the idea
     */
    Idea createIdea(Idea idea);

    /**
     * Subscribe to idea.
     *
     * @param idea    the idea
     * @param student the student
     * @return the idea
     */
    Idea subscribeTo(Idea idea, Student student);
}
