import java.util.Scanner;

/*
 * NIVEL 5 - EL SALON DE LA FAMA
 * Mision 5.1: El analisis de la temporada
 *
 * Datos de prueba: 450, 200, 780, 300, 150, 900, 620, 380, 210, 540, 700, 480
 * Verificacion: total = 5710 - promedio ~= 475.83 - mejor = mes 6 (900)
 *               peor = mes 5 (150) - sobre el promedio = 6
 */
public class AnalisisTemporada {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int MESES = 12;
        int[] oroPorMes = new int[MESES];

        // 1. Pedir los 12 valores
        System.out.println("=== REGISTRO ANUAL DE ORO DEL GREMIO ===");
        for (int i = 0; i < oroPorMes.length; i++) {
            System.out.print("Oro ganado en el mes " + (i + 1) + ": ");
            oroPorMes[i] = sc.nextInt();
        }

        // 2. Total y promedio (con casting a double)
        int total = 0;
        for (int i = 0; i < oroPorMes.length; i++) {
            total += oroPorMes[i];
        }
        double promedio = (double) total / oroPorMes.length;

        // 3. Mejor y peor mes (mismo ciclo, patron del maximo/minimo)
        int posMejor = 0;
        int posPeor = 0;
        for (int i = 1; i < oroPorMes.length; i++) {
            if (oroPorMes[i] > oroPorMes[posMejor]) {
                posMejor = i;
            }
            if (oroPorMes[i] < oroPorMes[posPeor]) {
                posPeor = i;
            }
        }

        // 4. Meses por encima del promedio (necesita el promedio ya calculado)
        int sobrePromedio = 0;
        for (int i = 0; i < oroPorMes.length; i++) {
            if (oroPorMes[i] > promedio) {
                sobrePromedio++;
            }
        }

        System.out.println();
        System.out.println("===== RESULTADOS DE LA TEMPORADA =====");
        System.out.println("Total anual      : " + total);
        System.out.println("Promedio mensual : " + promedio);
        System.out.println("Mejor mes        : mes " + (posMejor + 1) + " con " + oroPorMes[posMejor]);
        System.out.println("Peor mes         : mes " + (posPeor + 1) + " con " + oroPorMes[posPeor]);
        System.out.println("Meses sobre el promedio: " + sobrePromedio);
        System.out.println("Diferencia mejor-peor  : " + (oroPorMes[posMejor] - oroPorMes[posPeor]));

        // 5. Buscar un mes con un oro exacto
        System.out.print("¿Que cantidad de oro quieres buscar? ");
        int buscado = sc.nextInt();

        int posicion = -1;
        for (int i = 0; i < oroPorMes.length; i++) {
            if (oroPorMes[i] == buscado) {
                posicion = i;
                break;
            }
        }

        if (posicion != -1) {
            System.out.println("Ese oro se gano en el mes " + (posicion + 1));
        } else {
            System.out.println("Ningun mes gano exactamente esa cantidad de oro.");
        }

        // BONUS CREATIVO: marcar cada mes con simbolo segun el promedio
        System.out.println();
        System.out.println("===== DESEMPEÑO MES A MES =====");
        for (int i = 0; i < oroPorMes.length; i++) {
            String simbolo = "▼";
            if (oroPorMes[i] > promedio) {
                simbolo = "▲";
            }
            System.out.println("Mes " + (i + 1) + ": " + oroPorMes[i] + " " + simbolo);
        }

        sc.close();
    }
}
