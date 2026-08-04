import java.util.Locale;
import java.util.Scanner;

/*
 * NIVEL 1 - LA CREACION DEL HEROE
 * Mision 1.1: El registro del gremio
 *
 * Datos de prueba: Kael Tormenta de Hierro, 17, 120, 18, 9, 300.0, Guerrero
 * Resultado esperado: Poder = 72 - Nivel = 12 - Oro restante = 250.0
 */
public class RegistroGremio {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.println("=== REGISTRO DE AVENTURERO EN EL GREMIO ===");

        // El nombre lleva espacios -> nextLine()
        System.out.print("Nombre completo: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();

        System.out.print("Vida base: ");
        int vida = sc.nextInt();

        System.out.print("Ataque base: ");
        int ataque = sc.nextInt();

        System.out.print("Defensa base: ");
        int defensa = sc.nextInt();

        System.out.print("Oro inicial: ");
        double oro = sc.nextDouble();

        // La clase es una sola palabra -> next() (no necesita limpieza de Enter)
        System.out.print("Clase (Guerrero/Mago/Arquero): ");
        String clase = sc.next();

        // Calculos pedidos
        int poderCombate = ataque * 3 + defensa * 2;
        int nivelEstimado = vida / 10; // division entera intencional
        double oroInscripcion = 50;
        double oroRestante = oro - oroInscripcion;

        // Barra de vida para el bonus creativo (solo String y for, sin StringBuilder)
        String barra = "";
        for (int i = 0; i < vida / 10; i++) {
            barra += "|";
        }

        System.out.println();
        System.out.println("*********************************");
        System.out.println("*      FICHA DEL AVENTURERO      *");
        System.out.println("*********************************");
        System.out.println("Nombre  : " + nombre);
        System.out.println("Edad    : " + edad);
        System.out.println("Clase   : " + clase);
        System.out.println("Vida    : [" + barra + "] " + vida);
        System.out.println("Ataque  : " + ataque);
        System.out.println("Defensa : " + defensa);
        System.out.println("---------------------------------");
        System.out.println("Poder de combate : " + poderCombate);
        System.out.println("Nivel estimado   : " + nivelEstimado);
        System.out.println("Oro tras pagar inscripcion (" + oroInscripcion + "): " + oroRestante);
        System.out.println("*********************************");

        sc.close();
    }
}
