package structural.patterns.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class Component {

    protected List<String> nameList;

    public Component(String name) {
        nameList = new ArrayList<>();
        nameList.add(name);
    }

    public abstract List<String> getComponentNames();

    public List<String> getNameList() {
        return nameList;
    }

    public boolean add(Component child) {
        return false;
    }

    public Iterator<Component> iterator() {
        return Collections.<Component>emptyIterator();
    }

}
