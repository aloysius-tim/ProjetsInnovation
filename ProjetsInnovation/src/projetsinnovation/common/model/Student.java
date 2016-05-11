/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.common.model;

import java.io.Serializable;

/**
 * The type Student.
 *
 * @author Sofiane & Tim
 */
public class Student implements Serializable{
    
    private static final long serialVersionUID = 69L;

    
    private String nom;
    private String mail;

    /**
     * Instantiates a new Student.
     *
     * @param nom  the nom
     * @param mail the mail
     */
    public Student(String nom, String mail) {
        this.nom = nom;
        this.mail = mail;
    }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {return nom;}

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {this.nom = nom;}

    /**
     * Gets mail.
     *
     * @return the mail
     */
    public String getMail() {return mail;}

    /**
     * Sets mail.
     *
     * @param mail the mail
     */
    public void setMail(String mail) {this.mail = mail;}
    
    @Override
    public String toString() {
        return this.mail;
    }
}
