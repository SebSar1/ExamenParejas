package InteligenciaArtificial;

import java.util.Random;
import java.util.Scanner;

import EjercitoRuso.ExpertoIngles;
import EjercitoRuso.ExpertoRuso;
import EjercitoRuso.SAHormigaRusa;
import EjercitoRuso.Mecatronico;
import Exoesqueleto.AntBot;
import Exoesqueleto.FuentePoder;
import InteligenciaArtificial.IABOT;
import Exoesqueleto.Alas;

public class Rusia {
    String[] nombres = { "Zangano", "Soldado", "Rastreadora" };
    int numHormiga;

    public void iniciar() throws InterruptedException {

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        boolean ingresoCorrecto = false;
        Mecatronico mecatronico = new Mecatronico("mecatronico");
        int cantidadPelotones = 0;
        System.out.println("\u001B[38;5;208m" + "Creando la IA-BOT...");
        IABOT iaBot = IABOT.getInstancia("IA-BOT");
        System.out.println("La IABOT aprenderá idiomas");
        ExpertoRuso expertoRuso = new ExpertoRuso();
        ExpertoIngles expertoIngles = new ExpertoIngles();
        expertoRuso.ensenarRuso(iaBot);
        expertoIngles.ensenarIngles(iaBot);
        iaBot.aprenderIdiomaRuso();
        iaBot.aprenderIdiomaIngles();

        iaBot.mostrarIdiomasAprendidos();
        System.out.println("Presione enter para continuar");
        sc.nextLine();
        limpiarConsola();
        while (ingresoCorrecto == false || cantidadPelotones <= 0) {

            System.out.println("¿Cuántos pelotones de 5 soldados desea crear?" + "\u001B[0m");
            try {
                cantidadPelotones = Integer.parseInt(sc.nextLine());
                ingresoCorrecto = true;
            } catch (Exception e) {
                System.out.println("Solo enteros positivos por favor");
            }
        }
        int contadorHormigasRusasTotales = 1;
        Alas alas = new Alas();
        FuentePoder fuentePoder = new FuentePoder();

        for (int contadorPelotones = 0; contadorPelotones < cantidadPelotones; contadorPelotones++) {
            for (int contadorHormigas = 0; contadorHormigas < 5; contadorHormigas++) {

                numHormiga = rand.nextInt((3 - 1) + 1);
                System.out.println("\033[32m" + "Peloton " + (contadorPelotones + 1) + " :" + "\u001B[0m");
                String identificadorSoldado = "HormigaRusa " + (contadorHormigasRusasTotales);
                contadorHormigasRusasTotales++;
                SAHormigaRusa hormigaRusa = new SAHormigaRusa(identificadorSoldado, nombres[numHormiga]);
                AntBot antbot = new AntBot(iaBot);
                System.out.println("\033[35m" + identificadorSoldado + " :" + "\033[36m");
                mecatronico.ensamblar(hormigaRusa, antbot, iaBot);
                System.out.println("\033[31m" + "Presione enter para continuar" + "\u001B[0m");
                antbot.controlarAcciones();
                sc.nextLine();
                limpiarConsola();
                if (hormigaRusa.getClasificacion().equalsIgnoreCase("zangano")) {
                    System.out.println("Desea volar?");
                    String ssdecisionVolar = sc.nextLine();
                    if (ssdecisionVolar.toLowerCase().equals("si")) {

                        alas.volar();
                        System.out.println("Reemplazando batería de la fuente de poder ");
                        hormigaRusa.reemplazarBateriaFuente(fuentePoder);
                        System.out.println("Baterias al 100");
                    }
                }

            }
        }

    }

    public void limpiarConsola() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
    }
}