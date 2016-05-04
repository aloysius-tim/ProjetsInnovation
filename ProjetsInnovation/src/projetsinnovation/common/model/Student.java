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
    
    private static final long serialVersionUID = 69L;

    
    private String nom;
    private String mail;

    public Student(String nom, String mail) {
        this.nom = nom;
        this.mail = mail;
    }

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public String getMail() {return mail;}
    public void setMail(String mail) {this.mail = mail;}
    
    @Override
    public String toString() {
        return this.mail;
    }
}
