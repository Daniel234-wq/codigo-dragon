import java.util.Locale;
import java.util.Scanner;

/*
 * NIVEL 2 - EL CAMINO SE BIFURCA
 * Mision 2.1: La tienda de pociones
 *
 * Datos de prueba: Bicho Coins = 60, vida = 140, opcion = 2
 * Resultado esperado: compra realizada, Bicho Coins = 10, vida = 150 (avisando "Vida al maximo")
 *
 * Se agrego un do-while para poder comprar varias veces hasta elegir "Salir",
 * ya que el propio menu incluye esa opcion.
 */
public class TiendaPociones {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.println("=== TIENDA DEL PUEBLO ===");

        System.out.print("Bicho Coins disponible: ");
        double bichoCoins = sc.nextDouble();

        System.out.print("Vida actual: ");
        int vida = sc.nextInt();

        final int VIDA_MAXIMA = 150;

        int opcion;
        do {
            System.out.println();
            System.out.println("---- MENU ----");
            System.out.println("1. Pocion pequeña   -> 20 Bicho Coins  | +30 vida");
            System.out.println("2. Pocion grande     -> 50 Bicho Coins  | +80 vida");
            System.out.println("3. Elixir de fuerza   -> 120 Bicho Coins | +10 ataque");
            System.out.println("4. Salir");
            System.out.println("5. Pocion misteriosa (bonus) -> 30 Bicho Coins");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();

            double precio = 0;
            String descripcion = "";

            switch (opcion) {
                case 1:
                    precio = 20;
                    descripcion = "Pocion pequeña";
                    break;
                case 2:
                    precio = 50;
                    descripcion = "Pocion grande";
                    break;
                case 3:
                    precio = 120;
                    descripcion = "Elixir de fuerza";
                    break;
                case 4:
                    System.out.println("Gracias por visitar la tienda.");
                    break;
                case 5:
                    precio = 30;
                    descripcion = "Pocion misteriosa";
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

            if (opcion >= 1 && opcion <= 3 || opcion == 5) {
                if (bichoCoins < precio) {
                    double faltante = precio - bichoCoins;
                    System.out.println("Bicho Coins insuficiente. Te faltan " + faltante + " monedas de Bicho Coins.");
                } else {
                    bichoCoins -= precio;

                    if (opcion == 1) {
                        vida += 30;
                    } else if (opcion == 2) {
                        vida += 80;
                    } else if (opcion == 3) {
                        System.out.println("Ganaste +10 de ataque (no se refleja en la vida).");
                    } else if (opcion == 5) {
                        // BONUS CREATIVO: si el Bicho Coins restante es par cura 100, si es impar quita 20 de vida
                        if (bichoCoins % 2 == 0) {
                            vida += 100;
                            System.out.println("La pocion misteriosa te curo 100 de vida.");
                        } else {
                            vida -= 20;
                            System.out.println("La pocion misteriosa te quito 20 de vida.");
                        }
                    }

                    if (vida > VIDA_MAXIMA) {
                        vida = VIDA_MAXIMA;
                        System.out.println("Vida al maximo.");
                    }
                    if (vida < 0) {
                        vida = 0;
                    }

                    System.out.println("Compraste: " + descripcion);
                    System.out.println("Bicho Coins restante: " + bichoCoins + " | Vida actual: " + vida);
                }
            }

        } while (opcion != 4);

        System.out.println();
        System.out.println("===== ESTADO FINAL =====");
        System.out.println("Bicho Coins  : " + bichoCoins);
        System.out.println("Vida : " + vida);

        sc.close();
    }
}
