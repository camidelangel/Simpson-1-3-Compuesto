package dif_e_integracion;

public class SimpsonCompuesto {
    // Calcula la aproximación de la integral usando Simpson 1/3 compuesto.
    // El número n de subintervalos debe ser par.
    private static double calcularSimpson(double a, double b, int n) {

        // Reutilizamos el cálculo del tamaño del paso del método del trapecio.
        double h = TrapecioCompuesto.calcularH(a, b, n);

        double sumaImpares = 0.0;
        double sumaPares = 0.0;

        // Recorremos los puntos interiores del intervalo.
        for (int k = 1; k < n; k++) {

            // Calculamos la posición del punto actual.
            double xk = a + k * h;

            // Los índices impares tienen coeficiente 4.
            if (k % 2 != 0) {
                sumaImpares += TrapecioCompuesto.funcion(xk);
            } else {
                // Los índices pares interiores tienen coeficiente 2.
                sumaPares += TrapecioCompuesto.funcion(xk);
            }
        }

        // Sumamos los extremos y aplicamos los coeficientes de Simpson.
        double sumaTotal = TrapecioCompuesto.funcion(a)
                + 4 * sumaImpares
                + 2 * sumaPares
                + TrapecioCompuesto.funcion(b);

        // Multiplicamos por h/3 para obtener la integral aproximada.
        return (h / 3) * sumaTotal;
    }

    // Calcula la integral hasta alcanzar la tolerancia solicitada.
    public static double integrarConTolerancia(
            double a, double b, double tolerancia) {

        int n = 2; // Primer número par de subintervalos.

        double integralAnterior = calcularSimpson(a, b, n);
        double errorAbsoluto = 999.0;

        // Mostramos la aproximación inicial.
        System.out.println("--- ITERACIONES (SIMPSON 1/3 COMPUESTO) ---");
        System.out.println("n = " + n + " | Integral = " + integralAnterior);

        // Duplicamos n hasta que la diferencia sea menor o igual
        // que la tolerancia solicitada.
        while (errorAbsoluto > tolerancia) {

            n *= 2;

            double integralNueva = calcularSimpson(a, b, n);

            // Calculamos el error entre aproximaciones consecutivas.
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);

            System.out.println("n = " + n + " | Integral = " + integralNueva + " | Error = " + errorAbsoluto);

            // Guardamos la aproximación para la siguiente comparación.
            integralAnterior = integralNueva;
        }

        // Devolvemos la última aproximación calculada.
        return integralAnterior;
    }
}
