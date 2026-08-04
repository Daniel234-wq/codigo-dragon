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
        int[] bichoCoinsPorSala = new int[NUM_SALAS];

        // 1. Pedir el Bicho Coins de cada sala
        System.out.println("=== EXPLORACION DE LA MAZMORRA (" + NUM_SALAS + " salas) ===");
        for (int i = 0; i < bichoCoinsPorSala.length; i++) {
            System.out.print("Bicho Coins encontrado en la sala " + (i + 1) + ": ");
            bichoCoinsPorSala[i] = sc.nextInt();
        }

        // 2. Mostrar la bitacora completa
        System.out.println();
        System.out.println("===== BITACORA =====");
        for (int i = 0; i < bichoCoinsPorSala.length; i++) {
            System.out.println("Sala " + (i + 1) + ": " + bichoCoinsPorSala[i] + " de Bicho Coins");
        }

        // 3. Bicho Coins total
        int bichoCoinsTotal = 0;
        for (int i = 0; i < bichoCoinsPorSala.length; i++) {
            bichoCoinsTotal += bichoCoinsPorSala[i];
        }
        System.out.println();
        System.out.println("Bicho Coins total encontrado: " + bichoCoinsTotal);

        // 4. Preguntar por una sala (1 a 7), validando el indice
        System.out.print("¿Que sala quieres consultar (1 a " + NUM_SALAS + ")? ");
        int sala = sc.nextInt();

        if (sala >= 1 && sala <= NUM_SALAS) {
            int indice = sala - 1; // conversion humano -> indice de array
            System.out.println("La sala " + sala + " tenia " + bichoCoinsPorSala[indice] + " de Bicho Coins.");
        } else {
            System.out.println("Esa sala no existe en la mazmorra.");
        }

        // 5. Contar salas vacias
        int salasVacias = 0;
        for (int i = 0; i < bichoCoinsPorSala.length; i++) {
            if (bichoCoinsPorSala[i] == 0) {
                salasVacias++;
            }
        }
        System.out.println("Salas vacias: " + salasVacias);

        // BONUS CREATIVO: grafico de barras, una # por cada 10 de Bicho Coins
        System.out.println();
        System.out.println("===== GRAFICO DE ORO =====");
        for (int i = 0; i < bichoCoinsPorSala.length; i++) {
            String barra = "";
            for (int j = 0; j < bichoCoinsPorSala[i] / 10; j++) {
                barra += "#";
            }
            System.out.println("Sala " + (i + 1) + " | " + barra);
        }

        sc.close();
    }
}
