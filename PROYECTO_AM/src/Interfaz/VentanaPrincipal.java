package Interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel panelCentral;
    private JPanel panelRonda;// Panel con CardLayout para cambiar subpaneles
    private CardLayout cardLayout;
    private Connection connection;


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VentanaPrincipal frame = new VentanaPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public VentanaPrincipal() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\oscar\\2ºDAM\\PROYECTO\\IMG-APPS\\IMG-App-Icono App.jpg"));
        // Configurar conexión a la base de datos
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdamf1", "root", "#Oscar_2005");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.");
            System.exit(1);
        }

        setTitle("ASTON MARTIN ARAMCO FORMULA ONE TEAM - Inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1062, 757);

        // Configurar contentPane
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 102, 94));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // Crear Panel Central con CardLayout
        cardLayout = new CardLayout();
        panelCentral = new JPanel(cardLayout);
        contentPane.add(panelCentral, BorderLayout.CENTER);

        // Crear Panel Izquierdo (Menú Lateral)
        JPanel menuLateral = new JPanel();
        menuLateral.setBackground(new Color(240, 240, 240));
        menuLateral.setPreferredSize(new Dimension(200, 0));
        contentPane.add(menuLateral, BorderLayout.WEST);
        menuLateral.setLayout(null);
        // Botón para Temporadas
        JButton btnTemporadas = new JButton("Temporadas");
        btnTemporadas.setBounds(22, 181, 136, 49);
        btnTemporadas.setFont(new Font("SansSerif", Font.BOLD, 12));
        menuLateral.add(btnTemporadas);

        // Menú emergente para Temporadas
        JPopupMenu menuTemporadas = new JPopupMenu();
        JMenu menu2024 = new JMenu("Temporada 2024");
        JMenu menu2025 = new JMenu("Temporada 2025");
        menuTemporadas.add(menu2024);
        menuTemporadas.add(menu2025);
        panelRonda = crearPanelRonda(1); // Crear un panel inicial para la ronda 1
        panelCentral.add(panelRonda, "Ronda_Default"); // Añadirlo al CardLayout
        cardLayout.show(panelCentral, "Ronda_Default"); // Mostrar el panel por defecto
        // Agregar 24 rondas al menú 2024
        for (int i = 1; i <= 24; i++) {
            JMenuItem rondaItem = new JMenuItem("Ronda " + i);
            menu2024.add(rondaItem);
            int rondaId = i;

            // Crear dinámicamente paneles para cada ronda
            rondaItem.addActionListener(e -> {
                JPanel nuevoPanelRonda = crearPanelRonda(rondaId);
                panelCentral.add(nuevoPanelRonda, "2024_Ronda" + rondaId);
                cardLayout.show(panelCentral, "2024_Ronda" + rondaId);
            });
        }
    

        // Agregar 24 rondas al menú 2025
        for (int i = 1; i <= 24; i++) {
            JMenuItem rondaItem = new JMenuItem("Ronda " + i);
            menu2025.add(rondaItem);
            int rondaId = i;

            // Crear dinámicamente paneles para cada ronda
            rondaItem.addActionListener(e -> {
                JPanel nuevoPanelRonda = crearPanelRonda(rondaId);
                panelCentral.add(nuevoPanelRonda, "2025_Ronda" + rondaId);
                cardLayout.show(panelCentral, "2025_Ronda" + rondaId);
            });
        }

        // Mostrar el menú emergente al hacer clic en el botón
        btnTemporadas.addActionListener(e -> menuTemporadas.show(btnTemporadas, 0, btnTemporadas.getHeight()));

        // Botón para Pilotos
        JButton btnPilotos = new JButton("Pilotos");
        btnPilotos.setBounds(22, 277, 136, 49);
        btnPilotos.setFont(new Font("SansSerif", Font.BOLD, 12));
        menuLateral.add(btnPilotos);

        // Menú emergente para Pilotos
        JPopupMenu menuPilotos = new JPopupMenu();
        JMenuItem menuFernando = new JMenuItem("Fernando Alonso");
        JMenuItem menuLance = new JMenuItem("Lance Stroll");
        menuPilotos.add(menuFernando);
        menuPilotos.add(menuLance);

        // Mostrar el menú emergente al hacer clic en el botón Pilotos
        btnPilotos.addActionListener(e -> menuPilotos.show(btnPilotos, 0, btnPilotos.getHeight()));
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\oscar\\2ºDAM\\PROYECTO\\IMG-APPS\\icono_usuario.png"));
        lblNewLabel_4.setBounds(10, 23, 82, 81);
        menuLateral.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Bienvenido:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_5.setBounds(102, 48, 75, 13);
        menuLateral.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Admin");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_6.setBounds(102, 71, 53, 13);
        menuLateral.add(lblNewLabel_6);
        
        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnCerrarSesion.setBounds(22, 380, 136, 37);
        btnCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana actual
                dispose();

                // Muestra la ventana de login
                VentanaLogin ventanaLogin = new VentanaLogin();
                ventanaLogin.setVisible(true);
            }
        });
        menuLateral.add(btnCerrarSesion);


        // ActionListeners para las opciones de pilotos
        menuFernando.addActionListener(e -> mostrarDetallePiloto(14)); // Fernando Alonso tiene ID 14
        menuLance.addActionListener(e -> mostrarDetallePiloto(18));    // Lance Stroll tiene ID 18
        // Subpanel inicial
        JPanel panelInicio = new JPanel();
        panelInicio.setBackground(new Color(0, 102, 94));
        panelInicio.setLayout(null);
        JLabel labelInicio = new JLabel("Bienvenido al Sistema de Gestión de la aplicacion oficial de Aston Martin Aramco Formula One Team\r\n", SwingConstants.CENTER);
        labelInicio.setBounds(110, 134, 635, 56);
        labelInicio.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelInicio.setForeground(new Color(206, 220, 0));
        panelInicio.add(labelInicio);

        panelCentral.add(panelInicio, "Inicio");
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\oscar\\2ºDAM\\PROYECTO\\IMG-APPS\\IMG-App-escritorio-Imagen Principal_2.0.png"));
        lblNewLabel.setBounds(233, 221, 450, 300);
        panelInicio.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\oscar\\2ºDAM\\PROYECTO\\IMG-APPS\\amf1-logo-2024-white_-_Website_header_pequeño.png"));
        lblNewLabel_1.setBounds(10, 0, 221, 143);
        panelInicio.add(lblNewLabel_1);
        cardLayout.show(panelCentral, "Inicio");
    }
    
    private JPanel crearPanelRonda(int rondaId) {
        JPanel panelRonda = new JPanel();
        panelRonda.setBackground(new Color(0, 102, 94));

        JTextField nombreGP = new JTextField();
        nombreGP.setBounds(424, 119, 376, 41);
        JTextField fecha = new JTextField();
        fecha.setBounds(424, 217, 376, 41);
        JTextField posicionFernando = new JTextField();
        posicionFernando.setBounds(424, 319, 376, 41);
        JTextField posicionLance = new JTextField();
        posicionLance.setBounds(424, 439, 376, 41);
        panelRonda.setLayout(null);

        JLabel label = new JLabel("Nombre GP:");
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setForeground(new Color(206, 220, 0));
        label.setBounds(53, 78, 112, 120);
        panelRonda.add(label);
        panelRonda.add(nombreGP);
        JLabel label_1 = new JLabel("Fecha:");
        label_1.setForeground(new Color(206, 220, 0));
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_1.setBounds(53, 175, 112, 120);
        panelRonda.add(label_1);
        panelRonda.add(fecha);
        JLabel label_2 = new JLabel("Posición Fernando:");
        label_2.setForeground(new Color(206, 220, 0));
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_2.setBounds(53, 277, 132, 120);
        panelRonda.add(label_2);
        panelRonda.add(posicionFernando);
        JLabel label_3 = new JLabel("Posición Lance:");
        label_3.setForeground(new Color(206, 220, 0));
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_3.setBounds(53, 397, 132, 120);
        panelRonda.add(label_3);
        panelRonda.add(posicionLance);

        // Cargar datos de la base de datos
        cargarDatosRonda(rondaId, nombreGP, fecha, posicionFernando, posicionLance);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBackground(new Color(206, 220, 0));
        btnModificar.setBorderPainted(false);
        btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnModificar.setBounds(176, 584, 206, 59);
        btnModificar.addActionListener(e -> modificarDatosRonda(rondaId, nombreGP, fecha, posicionFernando, posicionLance));

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBorderPainted(false);
        btnCerrar.setBackground(new Color(206, 220, 0));
        btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCerrar.setBounds(549, 584, 206, 59);
        btnCerrar.addActionListener(e -> cardLayout.show(panelCentral, "Inicio"));

        panelRonda.add(btnModificar);
        panelRonda.add(btnCerrar);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\oscar\\2ºDAM\\PROYECTO\\IMG-APPS\\amf1-logo-2024-white_-_Website_header_pequeño.png"));
        lblNewLabel_3.setBounds(28, 25, 191, 64);
        panelRonda.add(lblNewLabel_3);

        return panelRonda;
    }
    
    private void cargarDatosRonda(int rondaId, JTextField nombreGP, JTextField fecha, JTextField posFernando, JTextField posLance) {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT nombreGP, fecha FROM carreras WHERE numeroCarrera = ?")) {
            stmt.setInt(1, rondaId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nombreGP.setText(rs.getString("nombreGP"));
                fecha.setText(rs.getString("fecha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        cargarPosicion(rondaId, 14, posFernando);
        cargarPosicion(rondaId, 18, posLance);
    }

    private void cargarPosicion(int rondaId, int pilotoId, JTextField campoPosicion) {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT posicion FROM posiciones WHERE idPiloto = ? AND numeroCarrera = ?")) {
            stmt.setInt(1, pilotoId);
            stmt.setInt(2, rondaId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                campoPosicion.setText(rs.getString("posicion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void modificarDatosRonda(int rondaId, JTextField nombreGP, JTextField fecha, JTextField posFernando, JTextField posLance) {
        try (PreparedStatement stmt = connection.prepareStatement("UPDATE carreras SET nombreGP = ?, fecha = ? WHERE numeroCarrera = ?")) {
            stmt.setString(1, nombreGP.getText());
            stmt.setString(2, fecha.getText());
            stmt.setInt(3, rondaId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        actualizarPosicion(rondaId, 14, posFernando.getText());
        actualizarPosicion(rondaId, 18, posLance.getText());

        JOptionPane.showMessageDialog(this, "Datos actualizados.");
    }

    private void actualizarPosicion(int rondaId, int pilotoId, String posicion) {
        try (PreparedStatement stmt = connection.prepareStatement("UPDATE posiciones SET posicion = ? WHERE idPiloto = ? AND numeroCarrera = ?")) {
            stmt.setString(1, posicion);
            stmt.setInt(2, pilotoId);
            stmt.setInt(3, rondaId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    

    private void mostrarDetallePiloto(int pilotoId) {
        JPanel panelPiloto = new JPanel();
        panelPiloto.setBackground(new Color(0, 102, 94));

        JTextField nombre = new JTextField();
        nombre.setBounds(424, 132, 309, 25);
        JTextField edad = new JTextField();
        edad.setBounds(424, 172, 309, 25);
        JTextField ciudadNacimiento = new JTextField();
        ciudadNacimiento.setBounds(424, 223, 309, 25);
        JTextField paisNacimiento = new JTextField();
        paisNacimiento.setBounds(424, 279, 309, 25);
        JTextField peso = new JTextField();
        peso.setBounds(424, 328, 309, 25);
        JTextField altura = new JTextField();
        altura.setBounds(424, 383, 309, 25);
        JTextField gpDisputados = new JTextField();
        gpDisputados.setBounds(424, 433, 309, 25);
        JTextField podios = new JTextField();
        podios.setBounds(424, 493, 309, 25);
        JTextField victorias = new JTextField();
        victorias.setBounds(424, 547, 309, 25);
        JTextField puntosTotales = new JTextField();
        puntosTotales.setBounds(424, 597, 309, 25);
        panelPiloto.setLayout(null);

        JLabel label = new JLabel("Nombre:");
        label.setFont(new Font("Tahoma", Font.BOLD, 12));
        label.setForeground(new Color(206, 220, 0));
        label.setBackground(new Color(206, 220, 0));
        label.setBounds(129, 112, 110, 65);
        panelPiloto.add(label);
        panelPiloto.add(nombre);
        JLabel label_1 = new JLabel("Edad:");
        label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        label_1.setForeground(new Color(206, 220, 0));
        label_1.setBounds(129, 152, 66, 65);
        panelPiloto.add(label_1);
        panelPiloto.add(edad);
        JLabel label_2 = new JLabel("Ciudad Nacimiento:");
        label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        label_2.setForeground(new Color(206, 220, 0));
        label_2.setBounds(129, 207, 125, 55);
        panelPiloto.add(label_2);
        panelPiloto.add(ciudadNacimiento);
        JLabel label_3 = new JLabel("País Nacimiento:");
        label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        label_3.setForeground(new Color(206, 220, 0));
        label_3.setBounds(129, 258, 110, 65);
        panelPiloto.add(label_3);
        panelPiloto.add(paisNacimiento);
        JLabel label_4 = new JLabel("Peso:");
        label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
        label_4.setForeground(new Color(206, 220, 0));
        label_4.setBounds(129, 308, 80, 65);
        panelPiloto.add(label_4);
        panelPiloto.add(peso);
        JLabel label_5 = new JLabel("Altura:");
        label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
        label_5.setForeground(new Color(206, 220, 0));
        label_5.setBounds(129, 363, 91, 65);
        panelPiloto.add(label_5);
        panelPiloto.add(altura);
        JLabel label_6 = new JLabel("GP Disputados:");
        label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
        label_6.setForeground(new Color(206, 220, 0));
        label_6.setBounds(129, 412, 110, 65);
        panelPiloto.add(label_6);
        panelPiloto.add(gpDisputados);
        JLabel label_7 = new JLabel("Podios:");
        label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
        label_7.setForeground(new Color(206, 220, 0));
        label_7.setBounds(129, 472, 91, 65);
        panelPiloto.add(label_7);
        panelPiloto.add(podios);
        JLabel label_8 = new JLabel("Victorias:");
        label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
        label_8.setForeground(new Color(206, 220, 0));
        label_8.setBounds(129, 527, 91, 65);
        panelPiloto.add(label_8);
        panelPiloto.add(victorias);
        JLabel label_9 = new JLabel("Puntos Totales:");
        label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
        label_9.setForeground(new Color(206, 220, 0));
        label_9.setBounds(129, 582, 110, 55);
        panelPiloto.add(label_9);
        panelPiloto.add(puntosTotales);

        cargarDatosPiloto(pilotoId, nombre, edad, ciudadNacimiento, paisNacimiento, peso, altura, gpDisputados, podios, victorias, puntosTotales);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnModificar.setBackground(new Color(206, 220, 0));
        btnModificar.setBorderPainted(false);
        btnModificar.setBounds(189, 663, 147, 42);
        btnModificar.addActionListener(e -> modificarDatosPiloto(pilotoId, nombre, edad, ciudadNacimiento, paisNacimiento, peso, altura, gpDisputados, podios, victorias, puntosTotales));

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBackground(new Color(206, 220, 0));
        btnCerrar.setBorderPainted(false);
        btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCerrar.setBounds(479, 663, 157, 42);
        btnCerrar.addActionListener(e -> cardLayout.show(panelCentral, "Inicio"));

        panelPiloto.add(btnModificar);
        panelPiloto.add(btnCerrar);

        panelCentral.add(panelPiloto, "DetallePiloto" + pilotoId);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\oscar\\2ºDAM\\PROYECTO\\IMG-APPS\\amf1-logo-2024-white_-_Website_header_pequeño.png"));
        lblNewLabel_2.setBounds(10, 31, 210, 71);
        panelPiloto.add(lblNewLabel_2);
        cardLayout.show(panelCentral, "DetallePiloto" + pilotoId);
    }

    private void cargarDatosPiloto(int pilotoId, JTextField nombre, JTextField edad, JTextField ciudadNacimiento, JTextField paisNacimiento, JTextField peso, JTextField altura, JTextField gpDisputados, JTextField podios, JTextField victorias, JTextField puntosTotales) {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pilotos WHERE idPiloto = ?")) {
            stmt.setInt(1, pilotoId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nombre.setText(rs.getString("nombre"));
                edad.setText(rs.getString("edad"));
                ciudadNacimiento.setText(rs.getString("ciudadNacimiento"));
                paisNacimiento.setText(rs.getString("paisNacimiento"));
                peso.setText(rs.getString("peso"));
                altura.setText(rs.getString("altura"));
                gpDisputados.setText(rs.getString("gpDisputados"));
                podios.setText(rs.getString("podios"));
                victorias.setText(rs.getString("victorias"));
                puntosTotales.setText(rs.getString("puntosTotales"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void modificarDatosPiloto(int pilotoId, JTextField nombre, JTextField edad, JTextField ciudadNacimiento, JTextField paisNacimiento, JTextField peso, JTextField altura, JTextField gpDisputados, JTextField podios, JTextField victorias, JTextField puntosTotales) {
        try (PreparedStatement stmt = connection.prepareStatement(
                "UPDATE pilotos SET nombre = ?, edad = ?, ciudadNacimiento = ?, paisNacimiento = ?, peso = ?, altura = ?, gpDisputados = ?, podios = ?, victorias = ?, puntosTotales = ? WHERE idPiloto = ?")) {
            stmt.setString(1, nombre.getText());
            stmt.setInt(2, Integer.parseInt(edad.getText()));
            stmt.setString(3, ciudadNacimiento.getText());
            stmt.setString(4, paisNacimiento.getText());
            stmt.setDouble(5, Double.parseDouble(peso.getText()));
            stmt.setDouble(6, Double.parseDouble(altura.getText()));
            stmt.setInt(7, Integer.parseInt(gpDisputados.getText()));
            stmt.setInt(8, Integer.parseInt(podios.getText()));
            stmt.setInt(9, Integer.parseInt(victorias.getText()));
            stmt.setInt(10, Integer.parseInt(puntosTotales.getText()));
            stmt.setInt(11, pilotoId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(this, "Datos actualizados.");
    }
}




