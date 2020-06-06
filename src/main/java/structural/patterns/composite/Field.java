package structural.patterns.composite;

import java.util.List;

public class Field extends Component {

    public Field(String name) {
        super(name);
    }

    @Override
    public List<String> getComponentNames() {
        return getNameList();
    }
}
