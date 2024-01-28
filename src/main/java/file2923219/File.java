package file2923219;

public class File implements Component{
    private final String name;
    private final int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public String display(String prefix) {
        return prefix + String.format("%s (%s)", this.name, this.size);
    }

    @Override
    public Component search(String name) {
        return null;
    }
}
