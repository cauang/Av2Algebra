package src;

import java.util.Scanner;

public class MainAV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector vector2D = new Vector(new double[]{0, 0});
        Vector vector3D = new Vector(new double[]{0, 0, 0});
        
        while (true) {
            printHeader();
            printCurrentVectors(vector2D, vector3D);
            printMainMenu();
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    vector2D = createVector(scanner, 2);
                    break;
                case 2:
                    vector3D = createVector(scanner, 3);
                    break;
                case 3:
                    handle2DTransformations(scanner, vector2D);
                    break;
                case 4:
                    handle3DTransformations(scanner, vector3D);
                    break;
                case 5:
                    scanner.close();
                    System.out.println("\nPrograma encerrado com sucesso!");
                    return;
                default:
                    System.out.println("\n⚠ Opção inválida!");
            }
        }
    }

    private static void printHeader() {
        System.out.println("\n==========================================");
        System.out.println("=== SISTEMA DE TRANSFORMAÇÕES LINEARES ===");
        System.out.println("==========================================");
    }

    private static void printCurrentVectors(Vector v2D, Vector v3D) {
        System.out.println("\nVETORES ATUAIS:");
        System.out.print("2D: ");
        v2D.show();
        System.out.print("3D: ");
        v3D.show();
        System.out.println("------------------------------------");
    }

    private static void printMainMenu() {
        System.out.println("\nMENU PRINCIPAL:");
        System.out.println("1. Definir vetor 2D");
        System.out.println("2. Definir vetor 3D");
        System.out.println("3. Transformações 2D");
        System.out.println("4. Transformações 3D");
        System.out.println("5. Sair");
        System.out.print("\nDigite sua opção: ");
    }

    private static Vector createVector(Scanner scanner, int dimensions) {
        System.out.println("\nDEFINIR VETOR " + dimensions + "D");
        double[] elements = new double[dimensions];
        char[] labels = {'x', 'y', 'z'};
        
        for (int i = 0; i < dimensions; i++) {
            System.out.print(labels[i] + ": ");
            elements[i] = scanner.nextDouble();
        }
        
        System.out.println("✔ Vetor definido com sucesso!");
        return new Vector(elements);
    }

    private static void handle2DTransformations(Scanner scanner, Vector vector) {
        while (true) {
            System.out.println("\n--- TRANSFORMAÇÕES 2D ---");
            System.out.println("Vetor atual:");
            vector.show();
            
            System.out.println("\n1. Translação");
            System.out.println("2. Rotação");
            System.out.println("3. Reflexão X");
            System.out.println("4. Reflexão Y");
            System.out.println("5. Projeção X");
            System.out.println("6. Projeção Y");
            System.out.println("7. Cisalhamento");
            System.out.println("8. Voltar");
            System.out.print("\nEscolha a transformação: ");
            
            int op = scanner.nextInt();
            if (op == 8) break;
            
            System.out.println("-----------------------------");
            switch (op) {
                case 1:
                    System.out.print("dx: ");
                    double dx = scanner.nextDouble();
                    System.out.print("dy: ");
                    vector = LinearTransformations.translate2D(vector, dx, scanner.nextDouble());
                    break;
                case 2:
                    System.out.print("Ângulo (rad): ");
                    vector = LinearTransformations.rotation2D(vector, scanner.nextDouble());
                    break;
                case 3:
                    vector = LinearTransformations.reflection2DX(vector);
                    break;
                case 4:
                    vector = LinearTransformations.reflection2DY(vector);
                    break;
                case 5:
                    vector = LinearTransformations.projection2DX(vector);
                    break;
                case 6:
                    vector = LinearTransformations.projection2DY(vector);
                    break;
                case 7:
                    System.out.print("kx: ");
                    double kx = scanner.nextDouble();
                    System.out.print("ky: ");
                    vector = LinearTransformations.shearing2D(vector, kx, scanner.nextDouble());
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }
            
            System.out.println("\nRESULTADO:");
            vector.show();
            System.out.println("-----------------------------");
        }
    }

    private static void handle3DTransformations(Scanner scanner, Vector vector) {
        while (true) {
            System.out.println("\n--- TRANSFORMAÇÕES 3D ---");
            System.out.println("Vetor atual:");
            vector.show();
            
            System.out.println("\n1. Translação");
            System.out.println("2. Rotação X");
            System.out.println("3. Rotação Y");
            System.out.println("4. Rotação Z");
            System.out.println("5. Reflexão X");
            System.out.println("6. Reflexão Y");
            System.out.println("7. Reflexão Z");
            System.out.println("8. Projeção X");
            System.out.println("9. Projeção Y");
            System.out.println("10. Projeção Z");
            System.out.println("11. Voltar");
            System.out.print("\nEscolha a transformação: ");
            
            int op = scanner.nextInt();
            if (op == 11) break;
            
            System.out.println("-----------------------------");
            switch (op) {
                case 1:
                    System.out.print("dx: ");
                    double dx = scanner.nextDouble();
                    System.out.print("dy: ");
                    double dy = scanner.nextDouble();
                    System.out.print("dz: ");
                    vector = LinearTransformations.translate3D(vector, dx, dy, scanner.nextDouble());
                    break;
                case 2:
                    System.out.print("Ângulo X (rad): ");
                    vector = LinearTransformations.rotation3DX(vector, scanner.nextDouble());
                    break;
                case 3:
                    System.out.print("Ângulo Y (rad): ");
                    vector = LinearTransformations.rotation3DY(vector, scanner.nextDouble());
                    break;
                case 4:
                    System.out.print("Ângulo Z (rad): ");
                    vector = LinearTransformations.rotation3DZ(vector, scanner.nextDouble());
                    break;
                case 5:
                    vector = LinearTransformations.reflection3DX(vector);
                    break;
                case 6:
                    vector = LinearTransformations.reflection3DY(vector);
                    break;
                case 7:
                    vector = LinearTransformations.reflection3DZ(vector);
                    break;
                case 8:
                    vector = LinearTransformations.projection3DX(vector);
                    break;
                case 9:
                    vector = LinearTransformations.projection3DY(vector);
                    break;
                case 10:
                    vector = LinearTransformations.projection3DZ(vector);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }
            
            System.out.println("\nRESULTADO:");
            vector.show();
            System.out.println("-----------------------------");
        }
    }
}