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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import BusinessLogic.BL.HormigaBL;
import DataAccess.DTO.HormigaDTO;
import UserInterface.CustomerControl.SebButton;
import UserInterface.CustomerControl.SebLabel;

public class PnlReina extends JPanel {

    private Image backgroundImage;
    private SebButton btnRegresar;
    private SebButton btnCrear;
    private SebButton btnEliminar;
    private SebButton btnEditar;
    private JPanel pnlTabla = new JPanel();

    public PnlReina() {
        initializeComponents();
        setupLayout();
        setupActions();
        loadImage();
        showHormigasTabla();
    }

    private void initializeComponents() {
        btnRegresar = new SebButton("Regresar");
        btnCrear = new SebButton("Crear");
        btnEditar = new SebButton("Editar");
        btnEliminar = new SebButton("Eliminar");
    }

    private void showHormigasTabla() {
        try {
            String[] encabezado = { "IdHormiga", "IdHormigaTipo", "Codigo", "Nombre", "Estado", "FechaCrea" };

            // Obtener los datos de la base de datos
            ArrayList<HormigaDTO> Hormigas = HormigaBL.getAll();

            // Crear un array bidimensional para almacenar los datos
            Object[][] data = new Object[Hormigas.size()][encabezado.length];

            // Llenar el array con los datos obtenidos de la base de datos
            for (int i = 0; i < Hormigas.size(); i++) {
                HormigaDTO Hormiga = Hormigas.get(i);
                data[i][0] = Hormiga.getIdHormiga();
                data[i][1] = Hormiga.getIdHormigaTipo();
                data[i][2] = Hormiga.getCodigo();
                data[i][3] = Hormiga.getNombre();
                data[i][4] = Hormiga.getEstado();
                data[i][5] = Hormiga.getFechaCrea();
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
        // Panel para los botones de manipulacion
        JPanel panelBotonera = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotonera.setOpaque(false);
        panelBotonera.add(btnCrear);
        panelBotonera.add(btnEditar);
        panelBotonera.add(btnEliminar);
        add(panelBotonera, BorderLayout.NORTH);
        // Panel para el botón "Regresar"
        JPanel panelRegresar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelRegresar.setOpaque(false);
        panelRegresar.add(btnRegresar);

        add(panelRegresar, BorderLayout.SOUTH);
    }

    private void setupActions() {
        btnRegresar.addActionListener(e -> MainForm());
        btnCrear.addActionListener(e -> VentanaCrear());
        btnEditar.addActionListener(e -> {
            VentanaEditar();
        });
        btnEliminar.addActionListener(e -> VentanaEliminar());
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

    private void VentanaCrear() {
        JPanel panerCrear = new JPanel(new GridLayout(6, 2, 5, 5)); // Ajusta el GridLayout para acomodar el nuevo
                                                                    // componente
        panerCrear.setPreferredSize(new Dimension(400, 200));
        SebLabel lblNombre = new SebLabel("Nombre:");
        JTextField txtNombre = new JTextField(20);

        SebLabel lblcodigo = new SebLabel("Código:");
        JTextField txtcodigo = new JTextField(10);

        SebLabel lblTipoHormiga = new SebLabel("Tipo de Hormiga:");
        String[] opcionesTipoHormiga = { "Rastreador", "Larva", "Soldado", "Zángano" };
        JComboBox<String> cmbTipoHormiga = new JComboBox<>(opcionesTipoHormiga);

        panerCrear.add(lblNombre);
        panerCrear.add(txtNombre);
        panerCrear.add(lblcodigo);
        panerCrear.add(txtcodigo);

        panerCrear.add(lblTipoHormiga); // Agrega el JLabel para el tipo de hormiga
        panerCrear.add(cmbTipoHormiga); // Agrega el JComboBox para el tipo de hormiga

        // Mostrar la ventana emergente de entrada con los componentes
        int opcion = JOptionPane.showConfirmDialog(null, panerCrear, "Crear Usuario", JOptionPane.OK_CANCEL_OPTION);

        // Verificar si se ha presionado "OK"
        if (opcion == JOptionPane.OK_OPTION) {
            // Verificar que los campos no estén vacíos
            if (txtNombre.getText().isEmpty() || txtcodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Los campos Nombre y código no pueden estar vacíos", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return; // Salir del método sin procesar los datos
            }

            // Aquí puedes procesar los datos ingresados por el usuario
            String nombre = txtNombre.getText();
            String codigo = txtcodigo.getText();
            String tipoHormiga = cmbTipoHormiga.getSelectedItem().toString();

            // Convertir el tipo de hormiga seleccionado en un formato numérico adecuado
            Integer idHormigaTipo;
            switch (tipoHormiga) {
                case "Rastreador":
                    idHormigaTipo = 1;
                    break;
                case "Larva":
                    idHormigaTipo = 2;
                    break;
                case "Soldado":
                    idHormigaTipo = 3;
                    break;
                case "Zángano":
                    idHormigaTipo = 4;
                    break;
                default:
                    idHormigaTipo = 1; // Por defecto, asigna Rastreador
                    break;
            }

            HormigaBL hormigaNueva = new HormigaBL();
            try {
                if (HormigaBL.codigoExiste(codigo)) {
                    hormigaNueva.add(nombre, idHormigaTipo, codigo);
                    JOptionPane.showMessageDialog(null, "Hormiga creada con éxito", "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Codigo existente", "Pobre",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                // Crear una nueva instancia de AdminPanel y mostrarla
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                frame.dispose();
                JFrame newFrame = new JFrame("Admin Panel");
                newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newFrame.add(new PnlReina());
                newFrame.pack();
                newFrame.setSize(700, 700);
                newFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void VentanaEditar() {
        // Crear un panel para solicitar el ID de la hormiga a editar
        JPanel panelId = new JPanel();
        JTextField txtId = new JTextField(10);
        panelId.add(new SebLabel("ID de la Hormiga:"));
        panelId.add(txtId);
        // Mostrar un diálogo para que el usuario ingrese el ID de la hormiga a editar
        int opcionId = JOptionPane.showConfirmDialog(null, panelId, "Ingrese el ID de la Hormiga a Editar",
                JOptionPane.OK_CANCEL_OPTION);

        // Verificar si se ha presionado "OK" y si el campo de ID no está vacío
        if (opcionId == JOptionPane.OK_OPTION && !txtId.getText().isEmpty()) {
            try {
                int idHormiga = Integer.parseInt(txtId.getText()); // Convertir el texto del campo ID a un entero

                // Obtener la información de la hormiga a editar usando el ID
                HormigaDTO hormiga = HormigaBL.getBy(idHormiga);

                // Verificar si la hormiga existe
                if (hormiga == null || HormigaBL.idHormigaExiste(idHormiga + "") == false) {
                    JOptionPane.showMessageDialog(null, "La hormiga con el ID especificado no existe", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return; // Salir del método si la hormiga no existe
                }

                // Utilizar JOptionPane para crear una ventana emergente con los componentes
                // necesarios
                JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));

                SebLabel lblNombre = new SebLabel("Nombre:");
                JTextField txtNombre = new JTextField(hormiga.getNombre(), 20); // Establecer el nombre de la hormiga en
                                                                                // el campo de texto

                SebLabel lblCodigo = new SebLabel("Código:");
                JTextField txtCodigo = new JTextField(hormiga.getCodigo(), 10); // Establecer el código de la hormiga en
                                                                                // el campo de texto

                SebLabel lblTipoHormiga = new SebLabel("Tipo de Hormiga:");
                String[] opcionesTipoHormiga = { "Rastreador", "Larva", "Soldado", "Zángano" };
                JComboBox<String> cmbTipoHormiga = new JComboBox<>(opcionesTipoHormiga);
                cmbTipoHormiga.setSelectedItem(hormiga.getIdHormigaTipo()); // Establecer el tipo de hormiga en el
                                                                            // ComboBox

                panel.add(lblNombre);
                panel.add(txtNombre);
                panel.add(lblCodigo);
                panel.add(txtCodigo);
                panel.add(lblTipoHormiga);
                panel.add(cmbTipoHormiga);

                // Mostrar la ventana emergente de entrada con los componentes
                int opcion = JOptionPane.showConfirmDialog(null, panel, "Editar Hormiga", JOptionPane.OK_CANCEL_OPTION);

                // Verificar si se ha presionado "OK"
                if (opcion == JOptionPane.OK_OPTION) {
                    // Verificar que los campos no estén vacíos
                    if (txtNombre.getText().isEmpty() || txtCodigo.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Los campos Nombre y Código no pueden estar vacíos",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Salir del método sin procesar los datos
                    }

                    // Obtener los nuevos valores ingresados por el usuario
                    String nombre = txtNombre.getText();
                    String codigo = txtCodigo.getText();
                    String tipoHormiga = cmbTipoHormiga.getSelectedItem().toString();

                    // Convertir el tipo de hormiga seleccionado en un formato numérico adecuado
                    int idHormigaTipo;
                    switch (tipoHormiga) {
                        case "Rastreador":
                            idHormigaTipo = 1;
                            break;
                        case "Larva":
                            idHormigaTipo = 2;
                            break;
                        case "Soldado":
                            idHormigaTipo = 3;
                            break;
                        case "Zángano":
                            idHormigaTipo = 4;
                            break;
                        default:
                            idHormigaTipo = 1; // Por defecto, asigna Rastreador
                            break;
                    }

                    // Crear un nuevo objeto HormigaBL con los valores actualizados
                    HormigaBL hormigaNueva = new HormigaBL();

                    hormigaNueva.update(idHormiga, nombre, idHormigaTipo, codigo);
                    // Cerrar la ventana actual
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    frame.dispose();
                    // Crear una nueva instancia de AdminPanel y mostrarla
                    JFrame newFrame = new JFrame("Admin Panel");
                    newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    newFrame.add(new PnlReina());
                    newFrame.pack();
                    newFrame.setSize(700, 700);
                    newFrame.setVisible(true);

                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El ID ingresado no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al editar hormiga", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void VentanaEliminar() {
        // Crear un panel para solicitar el ID de la hormiga a eliminar
        JPanel panelId = new JPanel();
        JTextField txtId = new JTextField(10);
        panelId.add(new SebLabel("ID de la Hormiga:"));
        panelId.add(txtId);
        // Mostrar un diálogo para que el usuario ingrese el ID de la hormiga a eliminar
        int opcionId = JOptionPane.showConfirmDialog(null, panelId, "Ingrese el ID de la Hormiga a Eliminar",
                JOptionPane.OK_CANCEL_OPTION);

        // Verificar si se ha presionado "OK" y si el campo de ID no está vacío
        if (opcionId == JOptionPane.OK_OPTION && !txtId.getText().isEmpty()) {
            try {
                int idHormiga = Integer.parseInt(txtId.getText()); // Convertir el texto del campo ID a un entero
                System.out.println(idHormiga);
                // Obtener la información de la hormiga a eliminar usando el ID
                HormigaDTO hormiga = HormigaBL.getBy(idHormiga);

                // Verificar si la hormiga existe
                if (hormiga == null || HormigaBL.idHormigaExiste(idHormiga + "") == false) {
                    JOptionPane.showMessageDialog(null, "La hormiga con el ID especificado no existe", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return; // Salir del método si la hormiga no existe
                }

                // Preguntar al usuario si está seguro de eliminar la hormiga
                int confirmacion = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro de eliminar la hormiga con ID " + idHormiga + "?", "Confirmar Eliminación",
                        JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    // Eliminar la hormiga
                    HormigaBL hormigaNueva = new HormigaBL();
                    hormigaNueva.delete(idHormiga);
                    JOptionPane.showMessageDialog(null, "Hormiga eliminada exitosamente", "Eliminación Exitosa",
                            JOptionPane.INFORMATION_MESSAGE);

                    // Cerrar la ventana actual
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    frame.dispose();
                    // Crear una nueva instancia de AdminPanel y mostrarla
                    JFrame newFrame = new JFrame("Admin Panel");
                    newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    newFrame.add(new PnlReina());
                    newFrame.pack();
                    newFrame.setSize(700, 700);
                    newFrame.setVisible(true);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El ID ingresado no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar la hormiga", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
