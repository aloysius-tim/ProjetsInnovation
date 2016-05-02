package server.model;


import common.IProjetInnovation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Aloysius_tim on 30/04/2016.
 */
public class ProjetInnovation implements IProjetInnovation {
    private HashMap<Idea, ArrayList<Student>> ideas;

    public ProjetInnovation() {
        this.ideas = new HashMap<>();
    }

    @Override
    public Serializable getIdeas() {
        return new IdeaList(ideas.keySet());
    }

    @Override
    public Serializable createIdea(String description, String technologies, Student author) {
        Idea idea=new Idea(description, Technologies.valueOf(technologies), author);
        ideas.put(idea, new ArrayList<Student>());
        return idea;
    }

    @Override
    public String toString() {
        return "ProjetInnovation{" +
                "ideas=" + ideas +
                '}';
    }
}
