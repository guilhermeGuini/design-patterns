package structural.patterns.bridge;

public class FileGeneratorCustomImpl implements FileGeneratorSpec {

    @Override
    public String generateHeader() {
        return "File Generator, HEADER CUSTOM";
    }
}
