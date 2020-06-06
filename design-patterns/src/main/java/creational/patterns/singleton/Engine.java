package creational.patterns.singleton;

public class Engine {

    private static Engine instance;

    private Engine() {
        // do nothing
    }

    public static Engine getInstance() {
        if (instance == null) {
            instance = new Engine();
        }

        return instance;
    }

}
