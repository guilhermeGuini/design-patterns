package structural.patterns.bridge;

public class FileGeneratorImpl implements FileGeneratorSpec {

    @Override
    public String generateHeader() {
        return "File Generator, HEADER";
    }
}
