package structural.patterns.composite;

import java.util.List;

public class Button extends Component {

    public Button(String name) {
        super(name);
    }

    @Override
    public List<String> getComponentNames() {
        return getNameList();
    }
}
