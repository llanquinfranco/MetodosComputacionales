package TP1;

import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class Trapecios {
    // PARA CUANDO NOS DAN LA FUNCION F(X) EXPLICITA
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, h, area;
        int n;
        System.out.println("Ingrese el valor de a");
        a = sc.nextDouble();
        System.out.println("Ingrese el valor de b");
        b = sc.nextDouble();
        System.out.println("Ingrese la cantidad de intervalos");
        n = sc.nextInt();
        h = (b - a) / n;
        area = calcular(a, b, h, n);
        System.out.println("El area aproximada de la funcion es de " + area);
    }
    
    public static double calcular(double a, double b, double h, int n) {
        // Modulo que aproxima el area de la integral de f(x)
        double resultado, sumatoria = 0, x0 = f(a), xn = f(b), xi;
        int i;
        xi = a + h;
        for(i = 1; i < n; i++) {
            sumatoria = sumatoria + f(xi);
            xi = xi + h;
        }
        resultado = (h / 2) * (x0 + xn + (2 * sumatoria));
        return resultado;
    }
    
    public static double f(double x) {
        // Modulo que almacena la funcion
        return (5 * Math.pow(x, 2)) + (2 * x) - 3;
    }
    
}
