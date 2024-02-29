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

import BusinessLogic.BL.UsuarioSistemaBL;
import DataAccess.DTO.UsuarioSistemaDTO;
import DataAccess.DTO.UsuarioSistemaDTO;
import UserInterface.CustomerControl.SebButton;

public class PnlZangano extends JPanel {

    private Image backgroundImage;
    private SebButton btnRegresar;
    private JPanel pnlTabla = new JPanel();

    public PnlZangano() {
        initializeComponents();
        setupLayout();
        setupActions();
        loadImage();
        showHormigasTabla();
    }

    private void initializeComponents() {
        btnRegresar = new SebButton("Regresar");
    }

    private void showHormigasTabla() {
        try {
            String[] encabezado = { "IdUsuarioSistema", "IdHormigaTipo", "Contraseña", "Estado", "FechaCrea",
                    "FechaModifica" };

            // Obtener los datos de la base de datos
            ArrayList<UsuarioSistemaDTO> Hormigas = UsuarioSistemaBL.getAll();

            // Crear un array bidimensional para almacenar los datos
            Object[][] data = new Object[Hormigas.size()][encabezado.length];

            // Llenar el array con los datos obtenidos de la base de datos
            for (int i = 0; i < Hormigas.size(); i++) {
                UsuarioSistemaDTO Hormiga = Hormigas.get(i);
                data[i][0] = Hormiga.getIdUsuarioSistema();
                data[i][1] = Hormiga.getIdHormigaTipo();
                data[i][2] = Hormiga.getContraseña();
                data[i][3] = Hormiga.getEstado();
                data[i][4] = Hormiga.getFechaCrea();
                data[i][5] = Hormiga.getFechaModifica();
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
            JOptionPane.showMessageDialog(this, "Error al cargar PatPnlHormigaSexo",
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
