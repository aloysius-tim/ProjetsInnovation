/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

import java.io.Serializable;

/**
 *
 * @author Sofiane
 */
public class Idea implements Serializable{
    private String description;
    private Technologies technologies;
    private Student author;

    public Idea(String description, Technologies technologies, Student author) {
        this.description = description;
        this.technologies = technologies;
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public Technologies getTechnologies() {
        return technologies;
    }

    public Student getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Idea{" +
                "description='" + description + '\'' +
                ", technologies=" + technologies +
                ", author=" + author +
                '}';
    }
}
