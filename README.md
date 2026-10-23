# Tarea 1 — Unidad 4: Simpson 1/3 Compuesto y Trapecio Compuesto

Este proyecto implementa dos métodos de integración numérica en Java: el método del Trapecio Compuesto y la Regla de Simpson 1/3 Compuesta.

El objetivo es aproximar la integral definida de una función mediante la división del intervalo de integración en subintervalos. Ambos métodos utilizan un criterio de paro basado en la diferencia absoluta entre dos aproximaciones consecutivas.

El programa permite comparar los resultados y la cantidad de subintervalos necesarios para alcanzar una tolerancia determinada.

## Estructura del proyecto

```text
dif_e_Integracion/
├── TrapecioCompuesto.java
├── SimpsonCompuesto.java
├── MainTrap.java
└── MainSim.java
```

El paquete utilizado en los archivos Java debe coincidir exactamente con el nombre del paquete del proyecto. Si se conserva el ZIP original, utiliza `dif_e_integracion`.

## Requisitos

- Java JDK instalado.
- Terminal o consola de comandos, o un IDE compatible con Java.
- Los cuatro archivos `.java` del proyecto.

Para comprobar que Java está instalado, ejecuta:

```bash
java -version
javac -version
```

## Compilación desde la terminal

Ubícate en el directorio que contiene la carpeta del proyecto y ejecuta:

```bash
javac -d . dif_e_integracion/*.java
```

Este comando compila los archivos Java y genera los archivos `.class` dentro de la estructura del paquete.

## Ejecución

Para ejecutar la comparación de ambos métodos:

```bash
java dif_e_integracion.MainSim
```

Para ejecutar únicamente el método del trapecio mediante su clase original:

```bash
java dif_e_integracion.MainTrap
```

## Parámetros utilizados

- Límite inferior: `a = 0.0`
- Límite superior: `b = 2.0`
- Tolerancia: `0.0001`
- Función: `f(x) = x²`
- Número inicial de subintervalos: `n = 2`

## Ejemplo de salida en consola

Con la acumulación del método del trapecio corregida, la salida tendrá valores similares a los siguientes:

```text
---ITERACIONES (TRAPECIO COMPUESTO)---
n = 2| Integral = 3.0
n = 4| Integral = 2.75|Error = 0.25
n = 8| Integral = 2.6875|Error = 0.0625
n = 16| Integral = 2.671875|Error = 0.015625
n = 32| Integral = 2.66796875|Error = 0.00390625
n = 64| Integral = 2.6669921875|Error = 9.765625E-4
n = 128| Integral = 2.666748046875|Error = 2.44140625E-4
n = 256| Integral = 2.66668701171875|Error = 6.103515625E-5

Resultado final del trapecio: 2.66668701171875

--- ITERACIONES (SIMPSON 1/3 COMPUESTO) ---
n = 2 | Integral = 2.6666666666666665
n = 4 | Integral = 2.6666666666666665 | Error = 0.0

Resultado final de Simpson: 2.6666666666666665
```

Los resultados pueden variar ligeramente en su representación decimal según la salida de Java, pero deben ser numéricamente equivalentes.


El método del Trapecio Compuesto alcanza la tolerancia con 256 subintervalos, mientras que Simpson 1/3 Compuesto alcanza el criterio de paro con 4 subintervalos.

Para la función cuadrática utilizada, Simpson proporciona la integral exacta dentro de la precisión numérica de la computadora, debido a que la regla integra exactamente polinomios de grado menor o igual que tres en aritmética exacta.

## Conclusión

La práctica permite comprobar que los métodos de integración numérica presentan distintas velocidades de convergencia. Para la función evaluada, Simpson 1/3 Compuesto necesita menos subintervalos que el Trapecio Compuesto para alcanzar la tolerancia solicitada.

La comparación también muestra la importancia de implementar correctamente las fórmulas y de emplear las mismas condiciones iniciales para ambos métodos.

## Datos del alumno 

Nombre: Camila amor del angel cervantes 

Materia: Métodos Numéricos

Institución: Instituto Tecnológico Superior de Xalapa
