package reseau.common;

import reseau.server.model.Idea;
import reseau.server.model.Student;

import java.util.ArrayList;

/**
 * The interface Projet innovation.
 */
public interface IProjetInnovation {
    /**
     * Gets ideas.
     *
     * @return the ideas
     */
    ArrayList<Idea> getIdeas();

    /**
     * Gets team.
     *
     * @param idea the idea
     * @return the team
     */
    ArrayList<Student> getTeam(Idea idea);

    /**
     * Create idea idea.
     *
     * @param idea the idea
     * @return the idea
     */
    Idea createIdea(Idea idea);

    /**
     * Subscribe to idea.
     *
     * @param idea    the idea
     * @param student the student
     * @return the idea
     */
    Idea subscribeTo(Idea idea, Student student);
}
