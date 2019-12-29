package models;

public class ButtonModel {
    private String name;
    private String resource;

    public ButtonModel() {
        this.name = "";
        this.resource = "";
    }

    public ButtonModel(String name, String resource) {
        this.name = name;
        this.resource = resource;
    }

    public String getName() {
        return this.name;
    }

    public String getResource() {
        return this.resource;
    }
}
