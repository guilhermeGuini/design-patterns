package creational.patterns.prototype;

public class CounterTerrorist extends Player {

    public CounterTerrorist() {
        setTerrorist(Boolean.FALSE);
    }

    @Override
    public void printName() {
        System.out.println("Counter Terrorist");
    }
}
