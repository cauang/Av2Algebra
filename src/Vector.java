package src;

public class Vector {
    private double[] elements;

    public Vector(double[] elements) {
        this.elements = elements;
    }

    public int size() {
        return elements.length;
    }

    public double getElement(int i) {
        if (i < 0 || i >= elements.length) {
            throw new IllegalArgumentException("Índice inválido");
        }
        return elements[i];
    }

    public void setElement(int i, double value) {
        if (i < 0 || i >= elements.length) {
            throw new IllegalArgumentException("Índice inválido");
        }
        elements[i] = value;
    }

    public void show() {
        for (double element : elements) {
            System.out.printf("%.2f ", element);
        }
        System.out.println();
    }
}