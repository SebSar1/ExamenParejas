package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import UserInterface.CustomerControl.SebButton;

public class SAPnlLarva extends JPanel {

    private Image backgroundImage;
    private SebButton btnRegresar;

    public SAPnlLarva() {
        initializeComponents();
        setupLayout();
        setupActions();
        loadImage();
    }

    private void initializeComponents() {
        btnRegresar = new SebButton("Regresar");
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        // Panel para el botón "Regresar"
        JPanel panelRegresar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelRegresar.setOpaque(false);
        panelRegresar.add(btnRegresar);

        add(panelRegresar, BorderLayout.SOUTH);
    }

    private void setupActions() {
        btnRegresar.addActionListener(e -> MainForm());
    }

    private void MainForm() {
        try {
            removeAll();
            add(new MainForm());
            revalidate();
            repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar PatPnlHormigaSexo", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadImage() {
        ImageIcon imagenFondo = new ImageIcon("Resource\\SALarvaCuteFondo.png");
        backgroundImage = imagenFondo.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
