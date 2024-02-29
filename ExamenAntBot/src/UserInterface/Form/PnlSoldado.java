package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import BusinessLogic.BL.AntBotBL;
import DataAccess.DTO.AntBotDTO;
import DataAccess.DTO.AntBotDTO;
import UserInterface.CustomerControl.SebButton;

public class PnlSoldado extends JPanel {

    private Image backgroundImage;
    private SebButton btnRegresar;
    private SebButton btnHormigaIdioma;
    
    private JPanel pnlTabla = new JPanel();

    public PnlSoldado() {
        initializeComponents();
        setupLayout();
        setupActions();
        loadImage();
        showHormigasTabla();
    }

    private void initializeComponents() {
        btnRegresar = new SebButton("Regresar");
        btnHormigaIdioma = new SebButton("Hormigas e idiomas");

    }

    private void showHormigasTabla() {
        try {
            String[] encabezado = { "IdAntBot", "IdIABot", "Nombre", "Serie", "Estado" };

            // Obtener los datos de la base de datos
            ArrayList<AntBotDTO> Hormigas = AntBotBL.getAll();

            // Crear un array bidimensional para almacenar los datos
            Object[][] data = new Object[Hormigas.size()][encabezado.length];

            // Llenar el array con los datos obtenidos de la base de datos
            for (int i = 0; i < Hormigas.size(); i++) {
                AntBotDTO Hormiga = Hormigas.get(i);
                data[i][0] = Hormiga.getIdAntBot();
                data[i][1] = Hormiga.getIdIABot();
                data[i][2] = Hormiga.getNombre();
                data[i][3] = Hormiga.getSerie();
                data[i][4] = Hormiga.getEstado();
            }

            // Crear una nueva tabla con los datos obtenidos
            JTable table = new JTable(data, encabezado);
            table.setShowHorizontalLines(true);
            table.setGridColor(Color.pink);
            table.setRowSelectionAllowed(true);
            table.setColumnSelectionAllowed(false);

            // Configurar la vista de la tabla
            table.setPreferredScrollableViewportSize(new Dimension(600, 300));
            table.setFillsViewportHeight(true);

            // Agregar la tabla a un JScrollPane y mostrarlo en tu panel
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(600, 300)); // Establecer tamaño preferido
            pnlTabla.removeAll();
            pnlTabla.add(scrollPane);
            // Asegúrate de agregar el panel que contiene la tabla al panel principal
            add(pnlTabla, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        // Crear panel para la tabla y centrarla en la ventana
        JPanel panelTablaCentral = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelTablaCentral.setOpaque(false);

        // Agregar la tabla al panel central y al panel principal
        panelTablaCentral.add(pnlTabla);
        add(panelTablaCentral, BorderLayout.CENTER);

        // Panel para el botón "Regresar"
        JPanel panelSouth = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Nuevo panel para el botón "Regresar"

        panelSouth.setOpaque(false);
        panelSouth.add(btnRegresar);
        panelSouth.add(btnHormigaIdioma);
        add(panelSouth, BorderLayout.SOUTH); // Agregar el panel de "Regresar" en la parte inferior

    }

    private void setupActions() {
        btnRegresar.addActionListener(e -> MainForm());
        btnHormigaIdioma.addActionListener(e -> PnlHormigaIdioma());

    }

    private void MainForm() {
        try {
            removeAll();
            add(new MainForm());
            revalidate();
            repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar PatPnlHormigaSexo",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void PnlHormigaIdioma() {
        try {
            removeAll();
            add(new PnlHormigaIdioma());
            revalidate();
            repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar PnlHormigaIidoma",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadImage() {
        ImageIcon imagenFondo = new ImageIcon(
                "Resource\\FondoPnl.png");
        backgroundImage = imagenFondo.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

}
