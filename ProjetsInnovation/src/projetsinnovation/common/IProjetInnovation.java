/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.common;

import java.util.ArrayList;
import projetsinnovation.common.model.*;

/**
 *
 * @author Sofiane
 */
public interface IProjetInnovation {
    ArrayList<Idea> getIdeas();
    ArrayList<Student> getTeam(Idea idea);
    Idea createIdea(Idea idea);
    Idea subscribeTo(Idea idea, Student student);
}
