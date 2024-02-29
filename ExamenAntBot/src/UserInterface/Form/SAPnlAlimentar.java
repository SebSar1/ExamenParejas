package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import BusinessLogic.BL.saHormigaComidaBL;
import BusinessLogic.SAExamen.SAHervivoro;
import BusinessLogic.BL.saHormigaComidaBL;
import DataAccess.DTO.saHormigaComidaDTO;
import EjercitoRuso.SAHormigaRusa;
import DataAccess.DTO.saHormigaComidaDTO;
import UserInterface.CustomerControl.SebButton;
import UserInterface.CustomerControl.SebLabel;

public class SAPnlAlimentar extends JPanel {

    private Image saBackgroundImage;
    private SebButton saBtnRegresar;
    private SebButton saBtnIdHormiga;
    private JPanel saPnlTabla = new JPanel();

    public SAPnlAlimentar() {
        initializeComponents();
        setupLayout();
        setupActions();
        loadImage();
        showHormigasTabla();
    }

    private void initializeComponents() {
        saBtnRegresar = new SebButton("Regresar");
        saBtnIdHormiga = new SebButton("IdHormiga");
    }

    private void showHormigasTabla() {
        try {
            String[] encabezado = { "IdHormiga", "HormigaTipo", "CodigoHormiga", "Estado", "Comio", "Region" };

            // Obtener los datos de la base de datos
            ArrayList<saHormigaComidaDTO> Hormigas = saHormigaComidaBL.getAll();

            // Crear un array bidimensional para almacenar los datos
            Object[][] data = new Object[Hormigas.size()][encabezado.length];

            // Llenar el array con los datos obtenidos de la base de datos
            for (int i = 0; i < Hormigas.size(); i++) {
                saHormigaComidaDTO Hormiga = Hormigas.get(i);
                data[i][0] = Hormiga.getSaIdHormiga();
                data[i][1] = Hormiga.getSaHormigaTipo();
                data[i][2] = Hormiga.getSaCodigoHormiga();
                data[i][3] = Hormiga.getSaEstado();
                data[i][4] = Hormiga.getSaComio();
                data[i][5] = Hormiga.getSaRegion();
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

            // Crear una etiqueta para el título de la tabla
            JLabel saLblTituloTabla = new JLabel("Hormigas del Ejército");
            // Establecer la alineación del título al centro
            saLblTituloTabla.setHorizontalAlignment(JLabel.CENTER);

            // Crear un nuevo panel para contener la tabla y el título
            JPanel saPanelTablaConTitulo = new JPanel(new BorderLayout());
            saPanelTablaConTitulo.add(saLblTituloTabla, BorderLayout.NORTH); // Agregar el título en la parte superior
            saPanelTablaConTitulo.add(new JScrollPane(table), BorderLayout.CENTER); // Agregar la tabla en el centro

            // Limpiar el panel de la tabla antes de agregar la nueva tabla con título
            saPnlTabla.removeAll();
            // Agregar el panel que contiene la tabla y el título al panel principal
            saPnlTabla.add(saPanelTablaConTitulo);

            // Asegúrate de agregar el panel que contiene la tabla al panel principal
            add(saPnlTabla, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        // Crear panel para la tabla y centrarla en la ventana
        JPanel saPanelTablaCentral = new JPanel(new FlowLayout(FlowLayout.CENTER));
        saPanelTablaCentral.setOpaque(false);

        // Agregar la tabla al panel central y al panel principal
        saPanelTablaCentral.add(saPnlTabla);
        add(saPanelTablaCentral, BorderLayout.CENTER);
        // Panel para los botones de manipulacion
        JPanel saPanelBotonera = new JPanel(new FlowLayout(FlowLayout.CENTER));
        saPanelBotonera.setOpaque(false);
        saPanelBotonera.add(saBtnIdHormiga);
        add(saPanelBotonera, BorderLayout.NORTH);
        // Panel para el botón "Regresar"
        JPanel panelRegresar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelRegresar.setOpaque(false);
        panelRegresar.add(saBtnRegresar);

        add(panelRegresar, BorderLayout.SOUTH);
    }

    private void setupActions() {
        saBtnRegresar.addActionListener(e -> MainForm());
        saBtnIdHormiga.addActionListener(e -> mostrarVentanaEmergente());
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
        saBackgroundImage = imagenFondo.getImage();
    }

    private void mostrarVentanaEmergente() {
        // Aquí creas y muestras la ventana emergente
        String idHormiga = JOptionPane.showInputDialog(this, "Ingrese el IdHormiga:");
        try {
            if (idHormiga == null) {
                // Si el usuario cancela, salir del método
                return;
            }

            // Validar si el IdHormiga es un número válido
            int id = 0;
            try {
                id = Integer.parseInt(idHormiga);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El IdHormiga debe ser un número entero", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            saHormigaComidaBL hormigaValidar = new saHormigaComidaBL();
            if (hormigaValidar.getBy(id) == null) {
                JOptionPane.showMessageDialog(this, "Esa hormiga no existe", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                SAHormigaRusa hormigaComer = new SAHormigaRusa();
                SAHervivoro hierva = new SAHervivoro();
                if (hormigaComer.saBuscar(hierva)) {
                    hormigaComer.saComer(hierva);
                    JOptionPane.showMessageDialog(this, "Genial, la hormiga comió", "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                    hormigaValidar.update(id, "Soldado",
                            "Hierba");
                    // Cerrar la ventana AdminPanel actual
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    frame.dispose();
                    // Crear una nueva instancia de SAPnlReina y mostrarla
                    JFrame newFrame = new JFrame("Admin Panel");
                    newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    newFrame.add(new SAPnlAlimentar());
                    newFrame.pack();
                    newFrame.setSize(700, 700);
                    frame.setLocationRelativeTo(null);
                    newFrame.setVisible(true);
                } else {
                    // Aquí puedes agregar un mensaje o acción si la hormiga no encontró nada para
                    // comer
                }
            }
        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(saBackgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

}