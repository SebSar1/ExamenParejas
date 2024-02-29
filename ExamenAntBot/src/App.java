import java.awt.SplashScreen;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatAllIJThemes;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkIJTheme;

import BusinessLogic.BL.HormigaBL;
import BusinessLogic.SAExamen.SAHervivoro;
import InteligenciaArtificial.Rusia;
import DataAccess.DTO.HormigaDTO;
import EjercitoRuso.SAHormigaRusa;
import UserInterface.Form.MainForm;
import UserInterface.Form.SplashScreenForm;

public class App {
    public static void main(String[] args) throws InterruptedException {
        saMostrarMensaje();
        saIniciarSistema();
    }
    public static void saMostrarMensaje() {
        String saMensaje = "Este programa se dividira en dos partes,la primera se mostrara en la terminal y la segunda se usara un interfaz";
        String saTitulo = "!Bienvenido PachaLover!";
        int saOpcion = JOptionPane.showConfirmDialog(null, saMensaje, saTitulo, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (saOpcion == JOptionPane.OK_OPTION || saOpcion == JOptionPane.CLOSED_OPTION) {
            return; 
        }
    }
    public static void saIniciarSistema() throws InterruptedException {
        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try {
            UIManager.setLookAndFeel(new FlatArcDarkContrastIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SplashScreenForm.show();
        Rusia oRusia = new Rusia();
        oRusia.iniciar();
        MainForm mainForm = new MainForm();
        JFrame saframe = new JFrame("AntBots");
        saframe.add(mainForm);
        saframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        saframe.pack();
        ImageIcon icon = new ImageIcon("Resource\\Icono.png");
        // Cambia
        // la ruta
        // logo
        saframe.setIconImage(icon.getImage());
        saframe.setSize(830, 750);
        saframe.setVisible(true);

    }
}
