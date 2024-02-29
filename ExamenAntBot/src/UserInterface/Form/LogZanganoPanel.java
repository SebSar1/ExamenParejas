package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BusinessLogic.BL.HormigaBL;
import BusinessLogic.BL.UsuarioSistemaBL;
import DataAccess.DTO.UsuarioSistemaDTO;
import UserInterface.CustomerControl.SebButton;
import UserInterface.CustomerControl.SebLabel;

public class LogZanganoPanel extends JPanel {

    private JTextField usuarioField;
    private JPasswordField passwordField;
    private SebButton loginButton;
    private Image backgroundImage;
    private SebButton btnRegresar;

    public LogZanganoPanel() {
        initializeComponents();
        setupLayout();
        setupActions();
        loadImage();
    }

    private void initializeComponents() {
        usuarioField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new SebButton("Login");
        loginButton.setPreferredSize(new Dimension(200, 50));
        btnRegresar = new SebButton("Regresar");

    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        JPanel panerIncicioSesion = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,
                200));
        panerIncicioSesion.setOpaque(false);
        panerIncicioSesion.add(new SebLabel("Usuario:"));
        panerIncicioSesion.add(usuarioField);
        panerIncicioSesion.add(new SebLabel("Contraseña:"));
        panerIncicioSesion.add(passwordField);
        panerIncicioSesion.add(loginButton);

        add(panerIncicioSesion, BorderLayout.CENTER);
        JPanel panelRegresar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelRegresar.setOpaque(false); // Hacer transparente el panel

        panelRegresar.add(btnRegresar); // Agregar el botón "Regresar" al panel
        add(panelRegresar, BorderLayout.SOUTH);
    }

    private void setupActions() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                char[] passwordChars = passwordField.getPassword();
                String contrasena = new String(passwordChars);

                // Aquí debes incluir la lógica para verificar el usuario y la contraseña
                if (validarUsuario(usuario, contrasena)) {
                    JOptionPane.showMessageDialog(LogZanganoPanel.this, "Login Exitoso",
                            "Bienvenido",
                            JOptionPane.INFORMATION_MESSAGE);
                    // Si la validación es exitosa, pasas al siguiente panel
                    PnlZangano();
                } else {
                    JOptionPane.showMessageDialog(LogZanganoPanel.this, "Usuario o Contraseña incorrectos", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                usuarioField.setText("");
                passwordField.setText("");
            }

        });
        btnRegresar.addActionListener(e -> RolPanel());
    }

    private void PnlZangano() {
        try {
            removeAll();
            add(new PnlZangano());
            revalidate();
            repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar PatPnlPersonaSexo",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para verificar el usuario y contraseña en la base de datos
    private boolean validarUsuario(String usuario, String clave) {
        try {

            if (usuario.equals("5")) {
                // Obtener la lista de usuarios de la base de datos
                ArrayList<UsuarioSistemaDTO> listaUsuarios = UsuarioSistemaBL.getUsuario();

                // Iterar sobre la lista de usuarios
                for (UsuarioSistemaDTO usuarioGuardado : listaUsuarios) {
                    Integer idClaveBuscada = Integer.parseInt(usuarioGuardado.toStringIdPersona());
                    // Obtener la contraseña almacenada para el usuario actual
                    // Validar si el usuario ingresado coincide con algún usuario de la lista
                    if (usuario.equals(usuarioGuardado.toStringIdPersona())
                            && clave.equals(UsuarioSistemaBL.getClave(idClaveBuscada).toStringClave())) {
                        // Si el usuario coincide y la contraseña es correcta, devolver true
                        return true;
                    }
                }
            } else {
                System.out.println("algo salio mal ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Si no se encontró ninguna coincidencia o la contraseña no es correcta,
        // devolver false
        return false;
    }

    private void RolPanel() {
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

    private void loadImage() {
        ImageIcon imagenFondo = new ImageIcon(
                "Resource\\FondoPanelesGenerales.png");
        backgroundImage = imagenFondo.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    // @Override
    // public Dimension getPreferredSize() {
    // return new Dimension(600, 400); // Establece el tamaño preferido del panel
    // }
}
