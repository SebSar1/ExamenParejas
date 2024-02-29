import java.awt.SplashScreen;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import BusinessLogic.BL.HormigaBL;
import InteligenciaArtificial.Rusia;
import DataAccess.DTO.HormigaDTO;
import UserInterface.Form.MainForm;
import UserInterface.Form.SplashScreenForm;

public class App {
    public static void main(String[] args) throws InterruptedException {

        iniciarSistema();
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
