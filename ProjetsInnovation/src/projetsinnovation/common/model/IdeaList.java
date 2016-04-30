package projetsinnovation.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Aloysius_tim on 30/04/2016.
 */
public class IdeaList extends ArrayList<Idea> implements Serializable {
    public IdeaList(int initialCapacity) {
        super(initialCapacity);
    }

    public IdeaList() {
    }

    public IdeaList(Collection<? extends Idea> c) {
        super(c);
    }
}
