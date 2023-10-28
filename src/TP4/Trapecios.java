package TP4;

import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class Trapecios {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c, d, h, k, area;
        int m, n;

        System.out.println("Ingrese el valor de a");
        a = sc.nextDouble();
        System.out.println("Ingrese el valor de b");
        b = sc.nextDouble();
        System.out.println("Ingrese la cantidad de subdivisiones para x");
        m = sc.nextInt();
        h = (b - a) / m;

        System.out.println("Ingrese el valor de c");
        c = sc.nextDouble();
        System.out.println("Ingrese el valor de d");
        d = sc.nextDouble();
        System.out.println("Ingrese la cantidad de subdivisiones para y");
        n = sc.nextInt();
        k = (d - c) / n;

        double[][] matriz = new double[m + 1][n + 1];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                
                
                
                
                
            }

        }

    }

    
    
    
    
    public static double f(double x, double y) {
        // Modulo que almacena la funcion xy + x²
        return (x * y) + (Math.pow(x, 2));
    }

}
