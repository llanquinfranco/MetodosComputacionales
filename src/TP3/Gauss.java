package TP3;

import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class Gauss {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] a = new double[10][10];
        double[] b = new double[10];
        double[] x = new double[10];
        // Ingreso de coeficientes
        
        System.out.println("Ingrese cantidad de incognitas");
        int n = sc.nextInt();
        System.out.println("Ingrese matriz");
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < n; i++) {
                System.out.println("Ingrese a[" + i + ", " + j + "]: ");
                a[j][i] = sc.nextInt();
            }
        }
        
        System.out.println("Ingrese vector independiente");
        for(int i = 0; i < n; i++) {
            System.out.println("Ingrese b[" + i + "]: ");
            b[i] = sc.nextInt();
        }
        // Resolucion por Eliminacion de Gauss
        int k = 1;
        while(k <= n - 1) {
            int i = k + 1;
            while(i <= n) {
                int j = k + 1;
                double m = (-1) * a[i][k] / a[k][k];
                while(j <= n) {
                    a[i][j] = a[i][j] + (m * a[k][j]);
                    j++;
                }
                b[i] = b[i] + (m * b[k]);
                i++;
            }
            k++;
        }
        x[n] = b[n] / a[n][n];
        System.out.println("x[" + n + "]= " + x[n]);
        int i = n - 1;
        double s = 0;
        while(i >= 1) {
            int j = i + 1;
            while(j <= n) {
                s = s + (a[i][j] * x[j]);
                j++;
            }
            x[i] = (b[i] - s) / a[i][i];
            System.out.println("x[" + i + "]= " + x[i]);
            i--;
        }
        
    }
    
}