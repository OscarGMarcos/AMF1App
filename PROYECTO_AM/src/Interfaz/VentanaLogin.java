package Interfaz;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Persistencia.GestorPersistencia;
import Logica.GestionApp;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private GestionApp gestorApp = new GestionApp();
    private JPanel contentPane;
    private JTextField tfUsuario;
    private JPasswordField passwordField;
    private JButton btnAceptar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaLogin frame = new VentanaLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VentanaLogin() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\oscar\\2ºDAM\\PROYECTO\\IMG-APPS\\IMG-App-Icono App.jpg"));
        setTitle("ASTON MARTIN ARAMCO FORMULA ONE TEAM - Ingreso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 901, 693);

        // Panel principal
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 102, 94));
        contentPane.setBorder(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Dimensiones deseadas para el JLabel
        int anchoDeseado = 297;
        int altoDeseado = 222;

        // Cargar y redimensionar la imagen
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\oscar\\2ºDAM\\PROYECTO\\IMG-APPS\\IMG-App-logo_blanco_removebg_preview.png");
        Image imagenOriginal = originalIcon.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);

        // Crear un ImageIcon con la imagen redimensionada
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        
        tfUsuario = new JTextField();
        tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfUsuario.setBounds(410, 299, 278, 41);
        contentPane.add(tfUsuario);
        tfUsuario.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        passwordField.setBounds(410, 387, 278, 41);
        contentPane.add(passwordField);
        
        JLabel lblNewLabel = new JLabel("Usuario:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setForeground(new Color(206, 220, 0));
        lblNewLabel.setBounds(76, 299, 202, 41);
        contentPane.add(lblNewLabel);
        
        JLabel lblIntroduceTu = new JLabel("Contraseña:");
        lblIntroduceTu.setForeground(new Color(206, 220, 0));
        lblIntroduceTu.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblIntroduceTu.setBounds(76, 387, 202, 41);
        contentPane.add(lblIntroduceTu);
        
        JLabel lblBienvenido = new JLabel("Bienvenido, introduce su usuario y contraseña:\r\n");
        lblBienvenido.setForeground(new Color(206, 220, 0));
        lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblBienvenido.setBounds(244, 223, 421, 41);
        contentPane.add(lblBienvenido);
        
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String usuario = tfUsuario.getText();
                String contrasena = new String(passwordField.getPassword());

                // Validar que no estén vacíos los campos
                if (usuario.isEmpty() || contrasena.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos", "Advertencia",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Validar credenciales llamando al método en GestorPersistencia
                boolean credencialesValidas = GestorPersistencia.validarCredenciales(usuario, contrasena);

                if (credencialesValidas) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");

                    // Guardar el usuario actual en GestorApp
                    GestionApp.setUsuarioActual(usuario);

                    // Abrir la VentanaPrincipal
                    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                    ventanaPrincipal.setVisible(true);

                    // Cerrar la VentanaLogin
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnAceptar.setBorderPainted(false);
        btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAceptar.setBorder(new LineBorder(new Color(206, 220, 0), 5, true));
        btnAceptar.setBackground(new Color(206, 220, 0));
        btnAceptar.setBounds(365, 506, 138, 48);
        contentPane.add(btnAceptar);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\oscar\\2ºDAM\\PROYECTO\\IMG-APPS\\IMG-App-escritorio-logo_blanco_removebg_preview.png"));
        lblNewLabel_1.setBounds(331, 30, 233, 183);
        contentPane.add(lblNewLabel_1);
        
    }
}



