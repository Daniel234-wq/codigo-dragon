import javax.swing.JOptionPane;

public class Aventura {
    public static void main(String[] args) {

        System.out.println("=== AVENTURA DEL GREMIO ===");
        System.out.println("El camino de " + "El Bicho" + " y Marincho comienza con valor, estrategia y Bicho Coins.\n");

        // ---- Cada personaje necesita SU PROPIO new ----
        // Personaje 1: datos fijos
        Personaje p1 = new Personaje();
        p1.nombre = "El Bicho";
        p1.clase = "Arquero veloz";
        p1.nivel = 6;
        p1.vidaMaxima = 110;
        p1.vida = 110;
        p1.ataque = 28;
        p1.defensa = 8;
        p1.bichoCoins = 300.0;
        p1.estaVivo = true;
        p1.arma = "rifle de francotirador";
        p1.esVenenoso = true;

        // Personaje 2: datos fijos
        Personaje p2 = new Personaje();
        p2.nombre = "Marincho";
        p2.clase = "garrotero de batalla";
        p2.nivel = 7;
        p2.vidaMaxima = 160;
        p2.vida = 160;
        p2.ataque = 22;
        p2.defensa = 14;
        p2.bichoCoins = 150.0;
        p2.estaVivo = true;
        p2.arma = "Espada larga de batalla";
        p2.esVenenoso = false;

        // Personaje 3: pedido al jugador
        Personaje p3 = new Personaje();
        JOptionPane.showMessageDialog(null, "=== CREA TU PERSONAJE ===", "Aventura del Gremio", JOptionPane.INFORMATION_MESSAGE);

        String nombreIngresado = JOptionPane.showInputDialog("Nombre:");
        p3.nombre = (nombreIngresado == null || nombreIngresado.trim().isEmpty()) ? "Sin nombre" : nombreIngresado.trim();

        String claseIngresada = JOptionPane.showInputDialog("Clase:");
        p3.clase = (claseIngresada == null || claseIngresada.trim().isEmpty()) ? "Sin clase" : claseIngresada.trim();

        int nivelIngresado = leerEntero("Nivel:");
        p3.nivel = nivelIngresado;

        int vidaMaximaIngresada = leerEntero("Vida maxima:");
        p3.vidaMaxima = vidaMaximaIngresada;
        p3.vida = p3.vidaMaxima;

        int ataqueIngresado = leerEntero("Ataque:");
        p3.ataque = ataqueIngresado;

        int defensaIngresada = leerEntero("Defensa:");
        p3.defensa = defensaIngresada;

        double bichoCoinsIngresados = leerDouble("Bicho Coins:");
        p3.bichoCoins = bichoCoinsIngresados;

        p3.estaVivo = true;
        p3.arma = "Daga";
        p3.esVenenoso = false;

        // 2. Mostrar la ficha de los tres
        System.out.println("=== FICHA DE LOS AVENTUREROS ===");
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
                + " | Bicho Coins: " + p1.bichoCoins + " | Estado: " + estado1);

        System.out.println("--- " + p2.nombre + " (" + p2.clase + ") ---");
        System.out.println("Nivel: " + p2.nivel + " | Vida: " + p2.vida + "/" + p2.vidaMaxima
                + " | Ataque: " + p2.ataque + " | Defensa: " + p2.defensa
                + " | Bicho Coins: " + p2.bichoCoins + " | Estado: " + estado2);

        System.out.println("--- " + p3.nombre + " (" + p3.clase + ") ---");
        System.out.println("Nivel: " + p3.nivel + " | Vida: " + p3.vida + "/" + p3.vidaMaxima
                + " | Ataque: " + p3.ataque + " | Defensa: " + p3.defensa
                + " | Bicho Coins: " + p3.bichoCoins + " | Estado: " + estado3);

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
        System.out.println("La batalla deja una leccion: el valor se mide en esfuerzo y no solo en fuerza.");
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
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                String entrada = JOptionPane.showInputDialog(mensaje);
                if (entrada == null) {
                    return 0;
                }
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingresa un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                String entrada = JOptionPane.showInputDialog(mensaje);
                if (entrada == null) {
                    return 0;
                }
                return Double.parseDouble(entrada.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingresa un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
