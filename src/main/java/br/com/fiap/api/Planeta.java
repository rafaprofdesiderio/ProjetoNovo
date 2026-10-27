package br.com.fiap.api;

public class Planeta {

    private String name;
    private String climate;
    private String gravity;
    private String terrain;

    public Planeta() {
    }

    public Planeta(String name, String climate, String gravity, String terrain) {
        this.name = name;
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    @Override
    public String toString() {
        return "Planeta " +
                "\nnome='" + name + '\'' +
                "\nclima='" + climate + '\'' +
                "\ngravidade='" + gravity + '\'' +
                "\nterreno='" + terrain + '\'';
    }
}
