package TP1;

import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class Simpson {

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
        if (n >= 2 && n % 2 == 0) {
            h = (b - a) / n;
            area = calcular(a, b, h, n);
            System.out.println("El area aproximada de la funcion es de " + area);
        } else {
            System.out.println("No se puede realizar el metodo de Simpson 1/3, "
                    + "ya que la cantidad de intervalos no es un numero par mayor o igual a 2");
        }
    }
    
    public static double calcular(double a, double b, double h, int n) {
        double resultado, sumatoriaPar = 0, sumatoriaImpar = 0, x0 = f(a), xn = f(b), xi;
        int i;
        xi = a + h;
        for(i = 1; i < n; i++) {
            if(i % 2 == 0) {
                sumatoriaPar = sumatoriaPar + f(xi);
            } else {
                sumatoriaImpar = sumatoriaImpar + f(xi);
            }
            xi = xi + h;
        }
        resultado = (h / 3) * (x0 + xn + (4 * sumatoriaImpar) + (2 * sumatoriaPar));
        return resultado;
    }

    public static double f(double x) {
        // Modulo que almacena la funcion
        return (5 * Math.pow(x, 2)) + (2 * x) - 3;
    }
}

// AVERIGUAR SI EXISTE UN MODO DE INGRESAR F(X) POR CONSOLA O SE TIENE QUE ALMACENAR EN UN METODO ANTES DE RUNNEARLO
