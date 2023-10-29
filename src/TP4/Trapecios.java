package TP4;

import static TP1.Trapecios.f;
import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class Trapecios {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c, d, h, k, superficie;
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
        
        double auxA = a, auxC = c;
        double[][] matriz = new double[n + 1][m + 1];
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = f(auxA, auxC);
                auxA = auxA + h;
            }
            auxA = a;
            auxC = auxC + k;
        }
        
        superficie = calcular(matriz, h, k);
        System.out.println("La superficie aproximada de la funcion es de " + superficie);
        
    }
    
    public static double calcular(double[][] matriz, double h, double k) {
        double[] sumatoriasX = new double[matriz.length];
        double sumatoria, sumatoriaY = 0;
        
        for(int i = 0; i < matriz.length; i++) {
            sumatoria = 0;
            for(int j = 1; j  < matriz.length - 1; j++) {
                sumatoria = sumatoria + matriz[i][j];
            }
            sumatoriasX[i] = (h / 2) * (matriz[i][0] + (2 * sumatoria) + matriz[i][matriz[i].length - 1]);
        }
        
        for(int i = 1; i < sumatoriasX.length - 1; i++) {
            sumatoriaY = sumatoriaY + sumatoriasX[i];
        }
        
        return ((k / 2) * (sumatoriasX[0] + (2 * sumatoriaY) + (sumatoriasX[sumatoriasX.length - 1])));
    }
    
    
    
    
    
    public static double f(double x, double y) {
        // Modulo que almacena la funcion xy + x²
        return (x * y) + (Math.pow(x, 2));
    }

}
