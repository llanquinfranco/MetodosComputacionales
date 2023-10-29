package TP4;

import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class Simpson {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c, d, h, k, volumen;
        int m, n;
        System.out.println("Ingrese el valor de x = a");
        a = sc.nextDouble();
        System.out.println("Ingrese el valor de x = b");
        b = sc.nextDouble();
        System.out.println("Ingrese el valor de y = c");
        c = sc.nextDouble();
        System.out.println("Ingrese el valor de y = d");
        d = sc.nextDouble();
        System.out.println("Ingrese la cantidad de subdivisiones para x[" + a + ", " + b + "]");
        m = sc.nextInt();
        h = (b - a) / m;
        System.out.println("Ingrese la cantidad de subdivisiones para y[" + c + ", " + d + "]");
        n = sc.nextInt();
        k = (d - c) / n;
        // Armo la matriz de nodos, con los valores de la funcion evaluada en cada punto
        //  [   f(xo, yo)          f(xo + h, yo)           f(xo + 2h, yo)       ]
        //  [   f(xo, yo + k)      f(xo + h, yo + k)       f(xo + 2h, yo + k)   ]
        //  [   f(xo, yo + 2k)     f(xo + h, yo + 2k)      f(xo + 2h, yo + 2k)  ]
        double xo = a, yo = c;
        double[][] matriz = new double[n + 1][m + 1];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = f(xo, yo);
                xo = xo + h;
            }
            xo = a;
            yo = yo + k;
        }
        // Calculo el volumen y lo muestro por pantalla
        volumen = calcular(matriz, h, k);
        System.out.println("El volumen aproximado debajo de la superficie en R ="
                + " [" + a + ", " + b + "] x [" + c + ", " + d + "], es de: " + volumen);
    }

    public static double calcular(double[][] matriz, double h, double k) {
        /* Se calcula un valor aproximado de la integral doble, aplicando el
        Metodo de Simpson 1/3 en ambas direcciones */
        double[] sumatoriasX = new double[matriz.length];
        double sumatoriaPar, sumatoriaImpar, sumatoriaYPar = 0, sumatoriaYImpar = 0;
        /* Primero, aproximamos las integrales fila por fila, con Simpson 1/3 y
        guardo el resultado de cada fila en un arreglo */
        for (int i = 0; i < matriz.length; i++) {
            sumatoriaPar = 0;
            sumatoriaImpar = 0;
            for (int j = 1; j < matriz.length - 1; j++) {
                if(j % 2 == 0) {
                    sumatoriaPar = sumatoriaPar + matriz[i][j];
                } else {
                    sumatoriaImpar = sumatoriaImpar + matriz[i][j];
                }
            }
            sumatoriasX[i] = (h / 3) * (matriz[i][0] + (4 * sumatoriaImpar) + (2 * sumatoriaPar) + matriz[i][matriz[i].length - 1]);
        }
        // Finalmente, utilizando los resultados de cada fila, calculamos aplicando Simpson 1/3
        for (int i = 1; i < sumatoriasX.length - 1; i++) {
            if(i % 2 == 0) {
                sumatoriaYPar = sumatoriaYPar + sumatoriasX[i];
            } else {
                sumatoriaYImpar = sumatoriaYImpar + sumatoriasX[i];
            }
            
        }
        return ((k / 3) * (sumatoriasX[0] + (4 * sumatoriaYImpar) + (2 * sumatoriaYPar) + (sumatoriasX[sumatoriasX.length - 1])));
    }
    
    public static double f(double x, double y) {
        // Modulo que almacena la funcion xy + x²
        return (x * y) + (Math.pow(x, 2));
    }
}
