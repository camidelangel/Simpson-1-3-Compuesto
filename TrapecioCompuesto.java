package dif_e_integracion;

//clase que implementa el metodo dde integracion numerioca por trapecio compuesto
//con un criterio de paro basado en el error absoluto y duplicacion de subintervalos

public class TrapecioCompuesto {

    //define la funcion matematica que se dea integrar
    //parametro x valor de la variabel independiente
    //return el valor evalud¿ado de la funcion

    public static double funcion(double x){
        return Math.pow(x,2);//ejemplo : f(x) = x^2
    }

    //calcula el tamaño del paso h
    //se declara public static para que la clase cimpconCompuesto pueda reutilizarla directamnete
    //parametro a limeite inferior, b limite superior, n numro de subintervalos, return el ancho de cada rebanada de h

    public static double calcularH(double a, double b, int n){
        return (b -a ) / n;}
    //metodo base que calcula la aproximacion de la integral mediante la regla del trapecio compuesta para un numero fijo de subintervalos(n)
    //formula: I=(h/2)* [f(a) + 2*sum(f(x_k)) + f(b)]
    private static double calcularTrapecio(double a, double b, int n){
        //reutilizamos el metodo calcularH que definimos arriba
        double h = calcularH(a,b,n);
        double suma= funcion(a) + funcion(b);//suma inicial con los extemos

        //ciclo para sumar los puntos interiores multiplicados por 2
        for (int k = 1; k < n; k++){
            double xk = a + k * h;
            suma += 2 * funcion(xk);
        }
        return (h/2) * suma;
    }

    //metodo iteratico que aplica el criterio de paro por error absoluto
    //duplica el numero de sbintervalos (n -> 2n) en cada iteracion del ciclo while hasta que la diferencia
    //entre dos aproximaciones sucesivas sea menos a la tolerancia
    public static double integrarConTolerancia(double a, double b, double tolerancia){
        int n = 2; // numero inicial de subintervalos
        double integralAnterior = calcularTrapecio(a, b, n);
        double errorAbsoluto = 999.0; // inicializamos con in valor grande para eentrar al while

        System.out.println("---ITERACIONES (TRAPECIO COMPUESTO)---");
        System.out.println("n = " + n + "|Integral = " + integralAnterior);

        //ciclo whilw para evaluar la convergencia iterativa
        while (errorAbsoluto > tolerancia){
            n *= 2; //duplicamos los subintervalos (el paso h se reduce a la mitad)
            double integralNueva = calcularTrapecio(a, b, n);

            //calculo del error absoluto entre la iteracion nueva y la anterior
            errorAbsoluto = Math.abs(integralNueva -integralAnterior);

            System.out.println("n = " + n + "| Integral = " + integralNueva + "|Error = " + errorAbsoluto);

            //actualizamos el valor anteriror para la siguiente compacracion
            integralAnterior = integralNueva;
        }
        return integralAnterior;
    }
}
























