package dif_e_integracion;

public class MainTrap {
    public static void main(String[] args){
        double a = 0.0;
        double b = 2.0;
        double tolerancia = 0.0001;

        //mandamos a llamar  al metodo encapsulado
        double resultado = TrapecioCompuesto.integrarConTolerancia(a, b, tolerancia);

        System.out.println("\n Resultado final obtenido: " + resultado);
    }
}
