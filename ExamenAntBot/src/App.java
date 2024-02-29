import java.awt.SplashScreen;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import BusinessLogic.BL.HormigaBL;
import DataAccess.DTO.HormigaDTO;
import UserInterface.Form.MainForm;
import UserInterface.Form.SplashScreenForm;

public class App {
    public static void main(String[] args) throws InterruptedException {
        mostrarMensaje();
        iniciarSistema();
    }
    
    public static void mostrarMensaje() {
        String mensaje = "Este programa se dividira en dos partes,la primera se mostrara en la terminal y la segunda se usara un interfaz";
        String titulo = "!Bienvenido PachaLover!";
        int opcion = JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (opcion == JOptionPane.OK_OPTION || opcion == JOptionPane.CLOSED_OPTION) {
            return; 
        }
    }
    public static void iniciarSistema() throws InterruptedException {
        SplashScreenForm.show();
        // Rusia oRusia = new Rusia();
        // oRusia.iniciar();
        MainForm mainForm = new MainForm();
        JFrame frame = new JFrame("AntBots");
        frame.add(mainForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        ImageIcon icon = new ImageIcon("Resource\\Icono.png");
        // Cambia
        // la ruta
        // logo
        frame.setIconImage(icon.getImage());
        frame.setSize(830, 750);
        frame.setVisible(true);

    }
}
