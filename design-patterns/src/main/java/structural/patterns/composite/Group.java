package structural.patterns.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group extends Component {

    private List<Component> children = new ArrayList<>();

    public Group(String name) {
        super(name);
    }

    @Override
    public List<String> getComponentNames() {

        Iterator<Component> iterator = iterator();

        while (iterator.hasNext()) {
            nameList.addAll(iterator.next().getComponentNames());
        }

        return nameList;
    }

    @Override
    public boolean add(Component child) {
        return children.add(child);
    }

    @Override
    public Iterator<Component> iterator() {
        return children.iterator();
    }
}
