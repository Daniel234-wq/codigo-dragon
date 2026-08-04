package ejercicios_java;

import java.util.Locale;
import java.util.Scanner;


public class Aventura {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        // ---- Cada personaje necesita SU PROPIO new ----
        // Personaje 1: datos fijos
        Personaje p1 = new Personaje();
        p1.nombre = "Aria la Veloz";
        p1.clase = "Arquero";
        p1.nivel = 6;
        p1.vidaMaxima = 110;
        p1.vida = 110;
        p1.ataque = 28;
        p1.defensa = 8;
        p1.oro = 300.0;
        p1.estaVivo = true;
        p1.arma = "Arco largo";
        p1.esVenenoso = true;

        // Personaje 2: datos fijos
        Personaje p2 = new Personaje();
        p2.nombre = "Doran el Firme";
        p2.clase = "Guerrero";
        p2.nivel = 7;
        p2.vidaMaxima = 160;
        p2.vida = 160;
        p2.ataque = 20;
        p2.defensa = 18;
        p2.oro = 150.0;
        p2.estaVivo = true;
        p2.arma = "Espada larga";
        p2.esVenenoso = false;

        // Personaje 3: pedido al jugador
        Personaje p3 = new Personaje();
        System.out.println("=== CREA TU PERSONAJE ===");
        System.out.print("Nombre: ");
        p3.nombre = sc.nextLine();
        System.out.print("Clase: ");
        p3.clase = sc.nextLine();
        System.out.print("Nivel: ");
        p3.nivel = sc.nextInt();
        System.out.print("Vida maxima: ");
        p3.vidaMaxima = sc.nextInt();
        p3.vida = p3.vidaMaxima;
        System.out.print("Ataque: ");
        p3.ataque = sc.nextInt();
        System.out.print("Defensa: ");
        p3.defensa = sc.nextInt();
        System.out.print("Oro: ");
        p3.oro = sc.nextDouble();
        sc.nextLine();
        p3.estaVivo = true;
        p3.arma = "Daga";
        p3.esVenenoso = false;

        // 2. Mostrar la ficha de los tres
        String estado1 = "CAIDO";
        if (p1.estaVivo) {
            estado1 = "VIVO";
        }
        String estado2 = "CAIDO";
        if (p2.estaVivo) {
            estado2 = "VIVO";
        }
        String estado3 = "CAIDO";
        if (p3.estaVivo) {
            estado3 = "VIVO";
        }

        System.out.println();
        System.out.println("--- " + p1.nombre + " (" + p1.clase + ") ---");
        System.out.println("Nivel: " + p1.nivel + " | Vida: " + p1.vida + "/" + p1.vidaMaxima
                + " | Ataque: " + p1.ataque + " | Defensa: " + p1.defensa
                + " | Oro: " + p1.oro + " | Estado: " + estado1);

        System.out.println("--- " + p2.nombre + " (" + p2.clase + ") ---");
        System.out.println("Nivel: " + p2.nivel + " | Vida: " + p2.vida + "/" + p2.vidaMaxima
                + " | Ataque: " + p2.ataque + " | Defensa: " + p2.defensa
                + " | Oro: " + p2.oro + " | Estado: " + estado2);

        System.out.println("--- " + p3.nombre + " (" + p3.clase + ") ---");
        System.out.println("Nivel: " + p3.nivel + " | Vida: " + p3.vida + "/" + p3.vidaMaxima
                + " | Ataque: " + p3.ataque + " | Defensa: " + p3.defensa
                + " | Oro: " + p3.oro + " | Estado: " + estado3);

        // 3. Poder mas alto: poder = ataque*3 + defensa*2 + nivel*10
        int poder1 = p1.ataque * 3 + p1.defensa * 2 + p1.nivel * 10;
        int poder2 = p2.ataque * 3 + p2.defensa * 2 + p2.nivel * 10;
        int poder3 = p3.ataque * 3 + p3.defensa * 2 + p3.nivel * 10;

        System.out.println();
        System.out.println("Poder -> " + p1.nombre + ": " + poder1
                + " | " + p2.nombre + ": " + poder2
                + " | " + p3.nombre + ": " + poder3);

        if (poder1 >= poder2 && poder1 >= poder3) {
            System.out.println("El de mayor poder es " + p1.nombre);
        } else if (poder2 >= poder1 && poder2 >= poder3) {
            System.out.println("El de mayor poder es " + p2.nombre);
        } else {
            System.out.println("El de mayor poder es " + p3.nombre);
        }

        // 4. Simular un ataque: p1 golpea a p3. daño real = ataque - defensa (min 0)
        System.out.println();
        System.out.println(p1.nombre + " ataca a " + p3.nombre + "...");
        int danio = p1.ataque - p3.defensa;
        if (danio < 0) {
            danio = 0;
        }
        // BONUS: si el atacante tiene veneno, daño extra de 5
        if (p1.esVenenoso) {
            danio += 5;
            System.out.println("¡El arma de " + p1.nombre + " esta envenenada! (+5 de daño)");
        }

        p3.vida -= danio;
        if (p3.vida <= 0) {
            p3.vida = 0;
            p3.estaVivo = false;
        }
        System.out.println("Daño infligido: " + danio);

        // 5. Estado de los tres despues del ataque (demuestra que p1 y p2 no cambiaron)
        estado3 = "CAIDO";
        if (p3.estaVivo) {
            estado3 = "VIVO";
        }

        System.out.println();
        System.out.println("===== ESTADO DESPUES DEL ATAQUE =====");
        System.out.println(p1.nombre + " -> vida " + p1.vida + "/" + p1.vidaMaxima + " (intacta)");
        System.out.println(p2.nombre + " -> vida " + p2.vida + "/" + p2.vidaMaxima + " (intacta)");
        System.out.println(p3.nombre + " -> vida " + p3.vida + "/" + p3.vidaMaxima
                + " | Estado: " + estado3);

        // 6. Curar a p3 en 30 puntos sin pasarse de vidaMaxima
        p3.vida += 30;
        if (p3.vida > p3.vidaMaxima) {
            p3.vida = p3.vidaMaxima;
        }
        System.out.println();
        System.out.println(p3.nombre + " fue curado. Vida actual: " + p3.vida + "/" + p3.vidaMaxima);

        sc.close();
    }
}
