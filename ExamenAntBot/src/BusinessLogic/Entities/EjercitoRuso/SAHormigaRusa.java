package EjercitoRuso;

import Exoesqueleto.FuentePoder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import BusinessLogic.SAExamen.ISAHormiga;
import BusinessLogic.SAExamen.ISAIA;
import BusinessLogic.SAExamen.SAAlimento;
import Exoesqueleto.Alas;

public class SAHormigaRusa extends Hormiga implements IhomigaExtremidad, ISAIA, ISAHormiga {
    private String clasificacion;

    public SAHormigaRusa(String nombre, String clasificacion) {
        super(nombre);
        this.clasificacion = clasificacion;
    }

    public SAHormigaRusa() {
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void reemplazarBateriaFuente(FuentePoder fuentePoder) {
        System.out.println("Recargando/ reemplazando batería");
        FuentePoder.nivelDeEnergia = 100;

    }

    // Método para buscar la primera línea que contenga "Herbivoro"
    @Override
    public boolean saBuscar(SAAlimento saAlimento) {
        boolean encontrado = false;
        try (BufferedReader br = new BufferedReader(new FileReader("src\\BusinessLogic\\SAExamen\\setAlimento.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().equalsIgnoreCase("Herbivoro")) {
                    encontrado = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encontrado;
    }

    // Método para eliminar la primera línea que contenga "Herbivoro"
    public boolean saComer(SAAlimento saAlimento) {
        boolean saEliminado = false;
        List<String> lineasArchivo = new ArrayList<>();

        // Leer el contenido del archivo original y almacenarlo en un ArrayList
        try (BufferedReader br = new BufferedReader(new FileReader("src\\BusinessLogic\\SAExamen\\setAlimento.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!saEliminado && linea.trim().equalsIgnoreCase("Herbivoro")) {
                    saEliminado = true;
                    continue; // Salta esta línea sin almacenarla en el ArrayList
                }
                lineasArchivo.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Si ocurre un error, devuelve false
        }

        // Eliminar el contenido del archivo original
        try (PrintWriter writer = new PrintWriter("src\\BusinessLogic\\SAExamen\\setAlimento.txt")) {
            writer.print("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false; // Si ocurre un error, devuelve false
        }

        // Escribir el contenido del ArrayList de nuevo en el archivo original
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\BusinessLogic\\SAExamen\\setAlimento.txt"))) {
            for (String linea : lineasArchivo) {
                bw.write(linea);
                bw.newLine();
            }
            if (saEliminado) {
                return true; // Devuelve true si se eliminó la línea "Herbivoro"
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Si ocurre un error, devuelve false
        }

        return false; // Si no se eliminó la línea "Herbivoro", devuelve false
    }

}
