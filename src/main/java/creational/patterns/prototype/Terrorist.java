package creational.patterns.prototype;

public class Terrorist extends Player {

    public Terrorist () {
        setTerrorist(Boolean.TRUE);
    }

    @Override
    public void printName() {
        System.out.println("Terrorist");
    }
}
