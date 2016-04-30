package projetsinnovation.common.model;

import projetsinnovation.common.IProjetInnovation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Aloysius_tim on 30/04/2016.
 */
public class ProjetInnovation implements IProjetInnovation{
    private HashMap<Idea, ArrayList<Student>> ideas;

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

}
