package ejercicios_java;

import java.util.Scanner;


public class TorneoGremio {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final int VIDA_MAXIMA = 100;

        // Las inicializaciones van ANTES del do-while: si se ponen adentro,
        // se reinician en cada vuelta y nunca se acumula nada.
        int vida = VIDA_MAXIMA;
        double oro = 0;
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
                    oro += 40;
                    peleasGanadas++;
                    System.out.println("¡Ganaste la pelea! Vida: " + vida + " | Oro: " + oro);

                    // BONUS: cada 3 peleas ganadas aparece un jefe
                    if (peleasGanadas % 3 == 0) {
                        vida -= 40;
                        oro += 150;
                        System.out.println("¡Un JEFE aparecio en tu camino! Pierdes 40 de vida "
                                + "pero ganas 150 de oro extra.");
                    }
                    break;

                case 2:
                    if (oro < 10) {
                        System.out.println("No tienes oro suficiente para descansar (cuesta 10).");
                    } else {
                        oro -= 10;
                        vida += 20;
                        if (vida > VIDA_MAXIMA) {
                            vida = VIDA_MAXIMA;
                        }
                        System.out.println("Descansaste. Vida: " + vida + " | Oro: " + oro);
                    }
                    break;

                case 3:
                    System.out.println("--- ESTADO ---");
                    System.out.println("Vida: " + vida);
                    System.out.println("Oro: " + oro);
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
        System.out.println("Oro final      : " + oro);
        System.out.println("Vida final     : " + vida);

        sc.close();
    }
}
