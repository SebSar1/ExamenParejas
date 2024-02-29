package EjercitoRuso;

import Exoesqueleto.FuentePoder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
    @Override
    public boolean saComer(SAAlimento saAlimento) {
        boolean saEliminado = false;
        try (BufferedReader br = new BufferedReader(new FileReader("src\\BusinessLogic\\SAExamen\\setAlimento.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("archivo_temp.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!saEliminado && linea.trim().equalsIgnoreCase("Herbivoro")) {
                    saEliminado = true;
                    continue; // Salta esta línea sin escribirla en el nuevo archivo
                }
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Cerrar el archivo temporal antes de realizar el cambio de nombre
        // Renombrar el archivo temporal al original
        if (saEliminado) {
            File archivo = new File("src\\BusinessLogic\\SAExamen\\setAlimento.txt");
            File tempArchivo = new File("archivo_temp.txt");
            if (tempArchivo.renameTo(archivo)) {
                System.out.println("Archivo original actualizado correctamente.");
            } else {
                System.err.println("Error al actualizar el archivo original.");
            }
        }

        return saEliminado;
    }

}
