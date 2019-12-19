package models;

public class ButtonResource {
    private int id;
    private String resource;

    public ButtonResource() {
        this.id = 0;
        this.resource = "";
    }

    public ButtonResource(int id, String resource) {
        this.id = id;
        this.resource = resource;
    }

    public int getId() {
        return this.id;
    }

    public String getResource() {
        return this.resource;
    }
}
