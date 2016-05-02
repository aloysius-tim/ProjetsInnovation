/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.common;

import java.io.Serializable;
import projetsinnovation.common.model.*;

/**
 *
 * @author Sofiane
 */
public interface IProjetInnovation {
    Serializable getIdeas();
    Serializable createIdea(Idea idea);
}
