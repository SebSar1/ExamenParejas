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
        SAHormigaRusa hormifa = new SAHormigaRusa("sebas", "prueba");
        if (hormifa.saBuscar(new SAHervivoro()))
            System.out.println("se encontro");
        hormifa.saComer(new SAHervivoro());
        // iniciarSistema();
    }

    public static void iniciarSistema() throws InterruptedException {
        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try {
            UIManager.setLookAndFeel(new FlatArcDarkContrastIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        // SplashScreenForm.show();
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
