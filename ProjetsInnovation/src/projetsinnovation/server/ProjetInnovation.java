package projetsinnovation.server;

import projetsinnovation.common.IProjetInnovation;

import java.util.ArrayList;
import projetsinnovation.common.model.*;

/**
 * @author Sofiane & Tim
 */
public class ProjetInnovation implements IProjetInnovation {
    
    private ArrayList<Idea> ideas = new ArrayList<Idea>();
    
    public ProjetInnovation() {
        
        ArrayList<Student> students1 = new ArrayList<Student>();
        ArrayList<Student> students2 = new ArrayList<Student>();
        
        Student s1 = new Student("Tim", "tim@keynes.fr");
        Student s2 = new Student("Sofiane", "sofiane@taleb.fr");
        Student s3 = new Student("Max", "max@carlier.fr");
        Student s4 = new Student("Théo", "theo@frasquet.fr");
        
        students1.add(s1);
        students1.add(s2);
        students1.add(s3);
        students2.add(s4);
        students2.add(s3);
        students2.add(s2);
        
        Idea i1 = new Idea("Je veux faire un nouveau Uber", Technologies.MOBILE, s1, students1);
        Idea i2 = new Idea("Plateforme de rencontre pour étudiants", Technologies.MOBILE, s2, students1);
        Idea i3 = new Idea("Site de news autour de Polytech", Technologies.WEB, s3, students2);
        Idea i4 = new Idea("Un service web autour des cours", Technologies.OTHER, s4, students2);
        
        this.ideas.add(i1);
        this.ideas.add(i2);
        this.ideas.add(i3);
        this.ideas.add(i4);
    }
    
    @Override
    public ArrayList<Idea> getIdeas() {
        return this.ideas;
    }
    
    @Override
    public Idea createIdea(Idea idea) {
        this.ideas.add(idea);
        return idea;
    }
    
    @Override
    public ArrayList<Student> getTeam(Idea idea) {
        for(Idea i : this.ideas) {
            if(i.getDescription().equals(idea.getDescription())) return i.getTeam();
        }
        return null;
    }
    
    @Override
    public Idea subscribeTo(Idea idea, Student student) {
        for(Idea i : this.ideas) {
            if(i.getDescription().equals(idea.getDescription()))
                i.addStudent(student);
        }
        return idea;    
    }
    
}
