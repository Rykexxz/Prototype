package net.pokeapi.pokemon.species;

public class PhysicalSize {
    private double weight;
    private double height;
    private static final double lenght = 1000.0;

    public PhysicalSize(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double weight() {
        return weight;
    }

    public double height() {
        return height;
    }

    public void print() {
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Height: " + height + " m");
    }

    public void setSize(double size) {
        weight = Math.round(weight * size * lenght) / lenght;
        height = Math.round(height * size * lenght) / lenght;
    }
}
