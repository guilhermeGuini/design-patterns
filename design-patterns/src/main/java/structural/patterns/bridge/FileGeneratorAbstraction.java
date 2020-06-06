package structural.patterns.bridge;

public class FileGeneratorAbstraction implements FileGenerator {

    private FileGeneratorSpec spec;

    public FileGeneratorAbstraction (FileGeneratorSpec spec) {
        this.spec = spec;
    }

    @Override
    public String generateHeader() {
        return spec.generateHeader();
    }

    public void setSpec(FileGeneratorSpec spec) {
        this.spec = spec;
    }
}
