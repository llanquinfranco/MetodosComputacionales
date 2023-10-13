package TP1;

/**
 *
 * @author Fran
 */
public class TrapeciosArreglos {
    // PARA CUANDO NOS DAN LOS VALORES DE F(X) EN TABLITA
    public static void main(String[] args) {
        double area;
        area = calcular();
        System.out.println("El area aproximada de la funcion es de " + area);
    }
    
    public static double calcular() {
        // Modulo que almacena la funcion tabular y aproxima la integral
        double[] puntos = {2.0, 2.5, 3.0, 3.5, 4.0};
        double[] valores = {0.2239, -0.0484, -0.2601, -0.3801, -0.387};
        double h = (puntos[puntos.length - 1] - puntos[0]) / (puntos.length - 1);
        double resultado, sumatoria = 0;
        int i, n = puntos.length;
        for(i = 1; i < n - 1; i++) {
            sumatoria = sumatoria + valores[i];
        }
        resultado = (h / 2) * (valores[0] + valores[valores.length - 1] + (2 * sumatoria));
        return resultado;
    }
    
}
