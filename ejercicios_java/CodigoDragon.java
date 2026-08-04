package ejercicios_java;

import java.util.Locale;
import java.util.Scanner;


public class CodigoDragon {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        Personaje[] equipo = new Personaje[0]; // se reemplaza al crear el escuadron
        boolean escuadronCreado = false;

        int opcion;
        do {
            System.out.println();
            System.out.println("=========================================");
            System.out.println("           CODIGO DRAGON v1.0           ");
            System.out.println("=========================================");
            System.out.println("1. Crear escuadron");
            System.out.println("2. Ver escuadron");
            System.out.println("3. Combate");
            System.out.println("4. Tienda");
            System.out.println("5. Estadisticas");
            System.out.println("6. Buscar heroe por nombre");
            System.out.println("7. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiamos el Enter pendiente de nextInt()

            if (opcion == 1) {
                System.out.print("¿Cuantos heroes tendra tu escuadron? ");
                int cantidad = sc.nextInt();
                sc.nextLine();

                if (cantidad <= 0) {
                    System.out.println("El escuadron necesita al menos 1 heroe.");
                } else {
                    equipo = new Personaje[cantidad];

                    for (int i = 0; i < equipo.length; i++) {
                        equipo[i] = new Personaje();

                        System.out.println();
                        System.out.println("--- Heroe " + (i + 1) + " ---");

                        System.out.print("Nombre: ");
                        equipo[i].nombre = sc.nextLine();

                        System.out.print("Clase: ");
                        equipo[i].clase = sc.nextLine();

                        System.out.print("Nivel: ");
                        equipo[i].nivel = sc.nextInt();

                        System.out.print("Vida maxima: ");
                        equipo[i].vidaMaxima = sc.nextInt();
                        equipo[i].vida = equipo[i].vidaMaxima;

                        System.out.print("Ataque: ");
                        equipo[i].ataque = sc.nextInt();

                        System.out.print("Defensa: ");
                        equipo[i].defensa = sc.nextInt();

                        System.out.print("Bicho Coins inicial: ");
                        equipo[i].bichoCoins = sc.nextDouble();
                        sc.nextLine();

                        equipo[i].estaVivo = true;
                    }

                    escuadronCreado = true;
                    System.out.println();
                    System.out.println("Escuadron creado con " + equipo.length + " heroes.");
                }

            } else if (opcion == 2) {
                if (!escuadronCreado) {
                    System.out.println("Primero debes crear el escuadron (opcion 1).");
                } else {
                    System.out.println();
                    System.out.println("========= ESCUADRON =========");
                    for (int i = 0; i < equipo.length; i++) {
                        String estado = "CAIDO";
                        if (equipo[i].estaVivo) {
                            estado = "VIVO";
                        }
                        System.out.println("[" + i + "] " + equipo[i].nombre
                                + " (" + equipo[i].clase + ") - Nivel " + equipo[i].nivel
                                + " | Vida " + equipo[i].vida + "/" + equipo[i].vidaMaxima
                                + " | Ataque " + equipo[i].ataque
                                + " | Defensa " + equipo[i].defensa
                                + " | Bicho Coins " + equipo[i].bichoCoins
                                + " | " + estado);
                    }
                }

            } else if (opcion == 3) {
                if (!escuadronCreado) {
                    System.out.println("Primero debes crear el escuadron (opcion 1).");
                } else {
                    System.out.print("Elige el indice del heroe que combatira (0 a "
                            + (equipo.length - 1) + "): ");
                    int idx = sc.nextInt();

                    if (idx < 0 || idx >= equipo.length) {
                        System.out.println("Ese heroe no existe en el escuadron.");
                    } else if (!equipo[idx].estaVivo) {
                        System.out.println(equipo[idx].nombre
                                + " ya cayo en combate y no puede pelear.");
                    } else {
                        System.out.print("Vida del enemigo: ");
                        int vidaEnemigo = sc.nextInt();
                        System.out.print("Ataque del enemigo: ");
                        int ataqueEnemigo = sc.nextInt();

                        System.out.println();
                        System.out.println("=== ¡COMIENZA EL COMBATE! ===");
                        int turno = 1;

                        while (equipo[idx].vida > 0 && vidaEnemigo > 0) {
                            System.out.println();
                            System.out.println("--- Turno " + turno + " ---");

                            vidaEnemigo -= equipo[idx].ataque;
                            if (vidaEnemigo < 0) {
                                vidaEnemigo = 0;
                            }
                            System.out.println(equipo[idx].nombre + " golpea por "
                                    + equipo[idx].ataque + ". Vida del enemigo: " + vidaEnemigo);

                            if (vidaEnemigo > 0) {
                                equipo[idx].vida -= ataqueEnemigo;
                                if (equipo[idx].vida < 0) {
                                    equipo[idx].vida = 0;
                                }
                                System.out.println("El enemigo contraataca por " + ataqueEnemigo
                                        + ". Vida de " + equipo[idx].nombre + ": " + equipo[idx].vida);
                            }

                            turno++;
                        }

                        System.out.println();
                        if (equipo[idx].vida > 0) {
                            System.out.println("¡VICTORIA! " + equipo[idx].nombre
                                    + " vencio al enemigo.");
                        } else {
                            equipo[idx].vida = 0;
                            equipo[idx].estaVivo = false;
                            System.out.println("DERROTA. " + equipo[idx].nombre + " ha caido.");
                        }
                    }
                }

            } else if (opcion == 4) {
                if (!escuadronCreado) {
                    System.out.println("Primero debes crear el escuadron (opcion 1).");
                } else {
                    System.out.print("Elige el indice del heroe que comprara (0 a "
                            + (equipo.length - 1) + "): ");
                    int idx = sc.nextInt();

                    if (idx < 0 || idx >= equipo.length) {
                        System.out.println("Ese heroe no existe en el escuadron.");
                    } else {
                        System.out.println();
                        System.out.println("===== TIENDA =====");
                        System.out.println("1. Pocion pequeña   (20 Bicho Coins, +30 vida)");
                        System.out.println("2. Pocion grande     (50 Bicho Coins, +80 vida)");
                        System.out.println("3. Elixir de fuerza   (120 Bicho Coins, +10 ataque)");
                        System.out.println("4. Salir de la tienda");
                        System.out.print("Opcion: ");
                        int compra = sc.nextInt();

                        double precio = 0;
                        switch (compra) {
                            case 1:
                                precio = 20;
                                break;
                            case 2:
                                precio = 50;
                                break;
                            case 3:
                                precio = 120;
                                break;
                            case 4:
                                precio = 0;
                                break;
                            default:
                                System.out.println("Opcion no valida.");
                        }

                        if (compra == 4) {
                            System.out.println("Sales de la tienda.");
                        } else if (compra >= 1 && compra <= 3) {
                            if (equipo[idx].bichoCoins < precio) {
                                double faltante = precio - equipo[idx].bichoCoins;
                                System.out.println("Bicho Coins insuficiente. Te faltan " + faltante + " monedas.");
                            } else {
                                equipo[idx].bichoCoins -= precio;

                                if (compra == 1) {
                                    equipo[idx].vida += 30;
                                } else if (compra == 2) {
                                    equipo[idx].vida += 80;
                                } else if (compra == 3) {
                                    equipo[idx].ataque += 10;
                                }

                                if (equipo[idx].vida > equipo[idx].vidaMaxima) {
                                    equipo[idx].vida = equipo[idx].vidaMaxima;
                                    System.out.println("Vida al maximo.");
                                }

                                System.out.println("Compra realizada. Bicho Coins restante: " + equipo[idx].bichoCoins);
                            }
                        }
                    }
                }

            } else if (opcion == 5) {
                if (!escuadronCreado) {
                    System.out.println("Primero debes crear el escuadron (opcion 1).");
                } else {
                    double bichoCoinsTotal = 0;
                    int sumaVida = 0;
                    int posMasFuerte = 0;
                    int posMasDebil = 0;
                    int vivos = 0;

                    for (int i = 0; i < equipo.length; i++) {
                        bichoCoinsTotal += equipo[i].bichoCoins;
                        sumaVida += equipo[i].vida;

                        if (equipo[i].ataque > equipo[posMasFuerte].ataque) {
                            posMasFuerte = i;
                        }
                        if (equipo[i].ataque < equipo[posMasDebil].ataque) {
                            posMasDebil = i;
                        }
                        if (equipo[i].estaVivo) {
                            vivos++;
                        }
                    }

                    double vidaPromedio = (double) sumaVida / equipo.length;

                    System.out.println();
                    System.out.println("===== ESTADISTICAS DEL GREMIO =====");
                    System.out.println("Bicho Coins total       : " + bichoCoinsTotal);
                    System.out.println("Vida promedio   : " + vidaPromedio);
                    System.out.println("Mas fuerte      : " + equipo[posMasFuerte].nombre
                            + " (ataque " + equipo[posMasFuerte].ataque + ")");
                    System.out.println("Mas debil       : " + equipo[posMasDebil].nombre
                            + " (ataque " + equipo[posMasDebil].ataque + ")");
                    System.out.println("Heroes vivos    : " + vivos + " de " + equipo.length);
                }

            } else if (opcion == 6) {
                if (!escuadronCreado) {
                    System.out.println("Primero debes crear el escuadron (opcion 1).");
                } else {
                    System.out.print("¿A quien buscas? ");
                    String buscado = sc.nextLine();

                    int posicion = -1;
                    for (int i = 0; i < equipo.length; i++) {
                        if (equipo[i].nombre.equalsIgnoreCase(buscado)) {
                            posicion = i;
                            break;
                        }
                    }

                    if (posicion != -1) {
                        String estado = "CAIDO";
                        if (equipo[posicion].estaVivo) {
                            estado = "VIVO";
                        }
                        System.out.println();
                        System.out.println("===== FICHA =====");
                        System.out.println("Nombre  : " + equipo[posicion].nombre);
                        System.out.println("Clase   : " + equipo[posicion].clase);
                        System.out.println("Nivel   : " + equipo[posicion].nivel);
                        System.out.println("Vida    : " + equipo[posicion].vida + "/" + equipo[posicion].vidaMaxima);
                        System.out.println("Ataque  : " + equipo[posicion].ataque);
                        System.out.println("Defensa : " + equipo[posicion].defensa);
                        System.out.println("Bicho Coins     : " + equipo[posicion].bichoCoins);
                        System.out.println("Estado  : " + estado);
                    } else {
                        System.out.println("Ese heroe no pertenece al escuadron.");
                    }
                }

            } else if (opcion == 7) {
                System.out.println();
                System.out.println("===== RESUMEN DE LA PARTIDA =====");
                if (escuadronCreado) {
                    int vivosFinal = 0;
                    double bichoCoinsFinal = 0;
                    for (int i = 0; i < equipo.length; i++) {
                        if (equipo[i].estaVivo) {
                            vivosFinal++;
                        }
                        bichoCoinsFinal += equipo[i].bichoCoins;
                    }
                    System.out.println("Heroes en el escuadron : " + equipo.length);
                    System.out.println("Heroes vivos           : " + vivosFinal);
                    System.out.println("Bicho Coins total del gremio   : " + bichoCoinsFinal);
                } else {
                    System.out.println("No llegaste a crear un escuadron.");
                }
                System.out.println("Gracias por jugar CODIGO DRAGON v1.0");

            } else {
                System.out.println("Opcion no valida. Elige un numero del 1 al 7.");
            }

        } while (opcion != 7);

        sc.close();
    }
}
