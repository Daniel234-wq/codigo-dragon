import java.util.Scanner;

/*
 * NIVEL 3 - COMBATE POR TURNOS
 * Mision 3.1: El torneo del gremio
 *
 * Secuencia de prueba sugerida: 1 -> 1 -> 3 -> 2 -> 1 -> 4
 * Bonus: cada 3 peleas ganadas aparece un jefe que quita 40 de vida
 * pero da 150 de Bicho Coins (usa el operador %).
 */
public class TorneoGremio {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final int VIDA_MAXIMA = 100;

        // Las inicializaciones van ANTES del do-while: si se ponen adentro,
        // se reinician en cada vuelta y nunca se acumula nada.
        int vida = VIDA_MAXIMA;
        double bichoCoins = 0;
        int peleasGanadas = 0;

        int opcion = 0;
        do {
            System.out.println();
            System.out.println("======= TORNEO DEL GREMIO =======");
            System.out.println("1. Pelear");
            System.out.println("2. Descansar");
            System.out.println("3. Ver estado");
            System.out.println("4. Retirarse");
            System.out.print("Elige una opcion: ");

            if (!sc.hasNextInt()) {
                System.out.println("Entrada no valida. Debes ingresar un numero.");
                sc.next();
                continue;
            }

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    vida -= 15;
                    bichoCoins += 40;
                    peleasGanadas++;
                    System.out.println("¡Ganaste la pelea! Vida: " + vida + " | Bicho Coins: " + bichoCoins);

                    // BONUS: cada 3 peleas ganadas aparece un jefe
                    if (peleasGanadas % 3 == 0) {
                        vida -= 40;
                        bichoCoins += 150;
                        System.out.println("¡Un JEFE aparecio en tu camino! Pierdes 40 de vida "
                                + "pero ganas 150 de Bicho Coins extra.");
                    }
                    break;

                case 2:
                    if (bichoCoins < 10) {
                        System.out.println("No tienes Bicho Coins suficiente para descansar (cuesta 10).");
                    } else {
                        bichoCoins -= 10;
                        vida += 20;
                        if (vida > VIDA_MAXIMA) {
                            vida = VIDA_MAXIMA;
                        }
                        System.out.println("Descansaste. Vida: " + vida + " | Bicho Coins: " + bichoCoins);
                    }
                    break;

                case 3:
                    System.out.println("--- ESTADO ---");
                    System.out.println("Vida: " + vida);
                    System.out.println("Bicho Coins: " + bichoCoins);
                    System.out.println("Peleas ganadas: " + peleasGanadas);
                    break;

                case 4:
                    System.out.println("Te retiras del torneo.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

            if (vida <= 0) {
                vida = 0;
                System.out.println();
                System.out.println("Has sido eliminado del torneo.");
            }

        } while (opcion != 4 && vida > 0);

        System.out.println();
        System.out.println("===== RESUMEN DEL TORNEO =====");
        System.out.println("Peleas ganadas : " + peleasGanadas);
        System.out.println("Bicho Coins final      : " + bichoCoins);
        System.out.println("Vida final     : " + vida);

        sc.close();
    }
}
