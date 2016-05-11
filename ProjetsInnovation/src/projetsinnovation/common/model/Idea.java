/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsinnovation.common.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Idea.
 *
 * @author Sofiane & Tim
 */
public class Idea implements Serializable{
    
    private static final long serialVersionUID = 67L;
    
    private String description;
    private Technologies technologies;
    private Student author;
    private ArrayList<Student> team;

    /**
     * Instantiates a new Idea.
     *
     * @param description  the description
     * @param technologies the technologies
     * @param author       the author
     * @param team         the team
     */
    public Idea(String description, Technologies technologies, Student author, ArrayList<Student> team) {
        this.description = description;
        this.technologies = technologies;
        this.author = author;
        this.team = team;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {return description;}

    /**
     * Gets technologies.
     *
     * @return the technologies
     */
    public Technologies getTechnologies() {return technologies;}

    /**
     * Gets author.
     *
     * @return the author
     */
    public Student getAuthor() {return author;}

    /**
     * Gets team.
     *
     * @return the team
     */
    public ArrayList<Student> getTeam() {return this.team;}

    /**
     * Add student.
     *
     * @param student the student
     */
    public void addStudent(Student student) {
        this.team.add(student);
    }

    @Override
    public String toString() {
        return this.technologies + " : " + this.description + " (" + this.author + ")";
    }
}
