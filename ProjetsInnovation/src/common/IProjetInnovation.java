/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;


import server.model.Student;

import java.io.Serializable;

/**
 *
 * @author Sofiane
 */
public interface IProjetInnovation {
    Serializable getIdeas();
    Serializable createIdea(String description, String technologies, Student author);
}
