package hw5_PatikaStore;

public class Brand implements Comparable<Brand> {

    private int id;
    private String name;
    private static int idCreator = 1;

    public Brand(String name) {
        this.id = idCreator;
        this.name = name;
        idCreator++;
    }

    @Override
    public int compareTo(Brand o) {
        return this.name.compareTo(o.getName());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
