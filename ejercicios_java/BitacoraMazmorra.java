import java.util.Scanner;

/*
 * NIVEL 4 - EL INVENTARIO
 * Mision 4.1: La bitacora de la mazmorra
 *
 * Datos de prueba: 45, 0, 120, 30, 0, 75, 10
 * Resultado esperado: total = 280, salas vacias = 2
 */
public class BitacoraMazmorra {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int NUM_SALAS = 7;
        int[] oroPorSala = new int[NUM_SALAS];

        // 1. Pedir el oro de cada sala
        System.out.println("=== EXPLORACION DE LA MAZMORRA (" + NUM_SALAS + " salas) ===");
        for (int i = 0; i < oroPorSala.length; i++) {
            System.out.print("Oro encontrado en la sala " + (i + 1) + ": ");
            oroPorSala[i] = sc.nextInt();
        }

        // 2. Mostrar la bitacora completa
        System.out.println();
        System.out.println("===== BITACORA =====");
        for (int i = 0; i < oroPorSala.length; i++) {
            System.out.println("Sala " + (i + 1) + ": " + oroPorSala[i] + " de oro");
        }

        // 3. Oro total
        int oroTotal = 0;
        for (int i = 0; i < oroPorSala.length; i++) {
            oroTotal += oroPorSala[i];
        }
        System.out.println();
        System.out.println("Oro total encontrado: " + oroTotal);

        // 4. Preguntar por una sala (1 a 7), validando el indice
        System.out.print("¿Que sala quieres consultar (1 a " + NUM_SALAS + ")? ");
        int sala = sc.nextInt();

        if (sala >= 1 && sala <= NUM_SALAS) {
            int indice = sala - 1; // conversion humano -> indice de array
            System.out.println("La sala " + sala + " tenia " + oroPorSala[indice] + " de oro.");
        } else {
            System.out.println("Esa sala no existe en la mazmorra.");
        }

        // 5. Contar salas vacias
        int salasVacias = 0;
        for (int i = 0; i < oroPorSala.length; i++) {
            if (oroPorSala[i] == 0) {
                salasVacias++;
            }
        }
        System.out.println("Salas vacias: " + salasVacias);

        // BONUS CREATIVO: grafico de barras, una # por cada 10 de oro
        System.out.println();
        System.out.println("===== GRAFICO DE ORO =====");
        for (int i = 0; i < oroPorSala.length; i++) {
            String barra = "";
            for (int j = 0; j < oroPorSala[i] / 10; j++) {
                barra += "#";
            }
            System.out.println("Sala " + (i + 1) + " | " + barra);
        }

        sc.close();
    }
}
