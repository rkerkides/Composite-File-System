package file2923219;

import java.util.ArrayList;

public class Directory implements Component {
    private String name;
    private int size;
    private int count;
    private ArrayList<Component> components;

    public Directory(String name) {
        this.name = name;
        this.size = 0;
        this.count = 0;
        this.components = new ArrayList<>();
    }

    public void add(Component component) {
        this.components.add(component);
        this.size += component.getSize(); // Increase the size
        this.count += component.getCount(); // Increase the count
    }

    public void remove(Component component) {
        this.components.remove(component);
        this.size -= component.getSize(); // Decrease the size
        this.count -= component.getCount(); // Decrease the count
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        this.size = 0;
        for (Component component : components) {
            this.size += component.getSize();
        }
        return this.size;
    }

    @Override
    public int getCount() {
        this.count = 0;
        for (Component component : components) {
            if (component instanceof File) {
                this.count++;
            } else if (component instanceof Directory) {
                this.count += component.getCount();
            }
        }
        return this.count;
    }

    @Override
    public String display(String prefix) {
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        for (Component component : components) {
            if (component instanceof Directory) {
                sb.append("\n").
                        append(prefix).
                        append(component.display(prefix + prefix));
            } else if (component instanceof File) {
                sb.append("\n").
                        append(prefix).
                        append(component.display(prefix));
            }
        }
        return sb.toString();
    }

    @Override
    public Component search(String name) {
        for (Component component : components) {
            if (component instanceof Directory) {
                Component result = component.search(name);
                if (result != null) {
                    return component;
                }
            } else if (component.getName().equals(name)) {
                return this;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s: (count=%s, size=%s)", this.name, this.getCount(), this.getSize());
    }
}