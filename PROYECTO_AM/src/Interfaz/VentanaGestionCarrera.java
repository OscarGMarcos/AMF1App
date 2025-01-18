package Interfaz;

import javax.swing.*;
import java.awt.*;

public class VentanaGestionCarrera extends JPanel {

    private static final long serialVersionUID = 1L;

    public VentanaGestionCarrera(String temporada, String carrera) {
        setLayout(new BorderLayout());
        add(new JLabel("Gestión de " + carrera + " en Temporada " + temporada, SwingConstants.CENTER), BorderLayout.NORTH);

        // Aquí puedes agregar campos específicos para gestionar la carrera
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new GridLayout(0, 2));
        panelContenido.add(new JLabel("Datos de la carrera:"));
        panelContenido.add(new JTextField(20));
        add(panelContenido, BorderLayout.CENTER);
    }
}

