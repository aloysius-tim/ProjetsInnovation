/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.common.model;

import java.io.Serializable;

/**
 *
 * @author Sofiane
 */
public class Student implements Serializable{
    private String nom;
    private String mail;

    public Student(String nom, String mail) {
        this.nom = nom;
        this.mail = mail;
    }
}
