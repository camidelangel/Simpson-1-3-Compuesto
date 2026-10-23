package dif_e_integracion;

public class MainSim {
    public static void main(String[] args) {

        // Definimos el intervalo de integración.
        double a = 0.0;
        double b = 2.0;

        // Usamos la misma tolerancia para ambos métodos.
        double tolerancia = 0.0001;

        // Ejecutamos el metodo del trapecio compuesto.
        double resultadoTrapecio = TrapecioCompuesto.integrarConTolerancia(a, b, tolerancia);

        System.out.println("\n Resultado final del trapecio: " + resultadoTrapecio);

        // Ejecutamos el metodo de Simpson 1/3 compuesto.
        double resultadoSimpson = SimpsonCompuesto.integrarConTolerancia(a, b, tolerancia);

        System.out.println("\n Resultado final de Simpson: " + resultadoSimpson);
    }
}
