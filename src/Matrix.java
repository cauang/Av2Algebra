package src;
public class Matrix {
    private double[] elements;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols, double[] elements) {
        this.rows = rows;
        this.cols = cols;
        this.elements = elements;
    }

    public double getElement(int i, int j) {
        return elements[i * cols + j];
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%.2f ", getElement(i, j));
            }
            System.out.println();
        }
    }
}