/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import projetsinnovation.common.model.*;

/**
 *
 * @author Sofiane
 */
public interface IProjetInnovation {
    ArrayList<Idea> getIdeas();
    Idea createIdea(Idea idea);
}
