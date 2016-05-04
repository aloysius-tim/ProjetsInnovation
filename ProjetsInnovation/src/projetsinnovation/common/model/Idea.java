/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.common.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Sofiane
 */
public class Idea implements Serializable{
    
    private static final long serialVersionUID = 67L;
    
    private String description;
    private Technologies technologies;
    private Student author;
    private ArrayList<Student> team;

    public Idea(String description, Technologies technologies, Student author, ArrayList<Student> team) {
        this.description = description;
        this.technologies = technologies;
        this.author = author;
        this.team = team;
    }

    public String getDescription() {return description;}
    public Technologies getTechnologies() {return technologies;}
    public Student getAuthor() {return author;}
    public ArrayList<Student> getTeam() {return this.team;}
    
    public void addStudent(Student student) {
        this.team.add(student);
    }

    @Override
    public String toString() {
        return this.technologies + " : " + this.description + " (" + this.author + ")";
    }
}
