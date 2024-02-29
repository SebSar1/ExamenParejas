package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import BusinessLogic.BL.HormigaBL;
import UserInterface.CustomerControl.SebButton;
import UserInterface.CustomerControl.SebLabel;

public class MainForm extends JPanel {
    SebButton btnIniciarSesion = new SebButton("Iniciar Sesión"),
            btnCrearCuenta = new SebButton("Crear Cuenta");
    private JLabel background; // Etiqueta para la imagen de fondo

    public MainForm() {

        cusromizarPanel();
        btnIniciarSesion.addActionListener(e -> rolPanelIniciar());

        btnCrearCuenta.addActionListener(e -> btnCrearCuentaClick());
    }

    private void rolPanelIniciar() {
        try {
            removeAll();
            add(new RolPanel());
            revalidate();
            repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar PatPnlPersonaSexo",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnCrearCuentaClick() {
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
                    switch (tipoHormiga) {
                        case "Rastreador":
                            JOptionPane.showMessageDialog(null,
                                    "Rastreador creado con éxito. Usuario:2 . Contraseña: contrasena2", "Éxito",
                                    JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Larva":
                            JOptionPane.showMessageDialog(null,
                                    "Larva creada con éxito. Usuario:3 . Contraseña: contrasena3", "Éxito",
                                    JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Soldado":
                            JOptionPane.showMessageDialog(null,
                                    "Soldado creado con éxito. Usuario:4 . Contraseña: contrasena4", "Éxito",
                                    JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Zángano":
                            JOptionPane.showMessageDialog(null,
                                    "Zangano creado con éxito. Usuario:5 . Contraseña: contrasena5", "Éxito",
                                    JOptionPane.INFORMATION_MESSAGE);
                            break;
                        default:
                            break;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Codigo existente", "Pobre",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void cusromizarPanel() {
        setLayout(new BorderLayout()); // Establece el diseño del MainForm como BorderLayout

        // Carga la imagen de fondo
        ImageIcon backgroundImage = new ImageIcon(
                "Resource\\FondoMainPanel.png"); // Cambia la
        // ruta por
        // la
        // ubicación
        // de tu imagen
        background = new JLabel(backgroundImage);

        // Establece el tamaño del fondo para que coincida con el tamaño del MainForm
        background.setPreferredSize(new Dimension(getWidth(), getHeight()));

        // Establece el diseño del fondo como BorderLayout para que cubra todo el
        // MainForm
        background.setLayout(new BorderLayout());

        // Agrega los botones al fondo
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false); // Hace que el panel de botones sea transparente
        buttonsPanel.add(btnIniciarSesion);
        buttonsPanel.add(btnCrearCuenta);

        // Agrega el panel de botones al centro del fondo
        background.add(buttonsPanel, BorderLayout.CENTER);

        // Agrega el fondo al MainForm
        add(background);
    }
}
