package projetsinnovation.server;

import projetsinnovation.common.IProjetInnovation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import projetsinnovation.common.model.Idea;
import projetsinnovation.common.model.IdeaList;
import projetsinnovation.common.model.Student;

/**
 * Created by Aloysius_tim on 30/04/2016.
 */
public class ProjetInnovation implements IProjetInnovation {
    private HashMap<Idea, ArrayList<Student>> ideas;

    @Override
    public Serializable getIdeas() {
        return new IdeaList(ideas.keySet());
    }

    @Override
    public Serializable createIdea(Idea idea) {
        ideas.put(idea, new ArrayList<Student>());
        return idea;
    }

}
