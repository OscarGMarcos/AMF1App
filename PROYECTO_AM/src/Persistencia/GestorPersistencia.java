package Persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modelo.Piloto;

public class GestorPersistencia {
    private static final String URL = "jdbc:mysql://localhost:3306/bdamf1";
    private static final String USER = "root"; // Cambia según tu configuración
    private static final String PASSWORD = "#Oscar_2005"; // Cambia según tu configuración

    private Connection conexion;

    // Constructor para establecer conexión
    public GestorPersistencia() {
        this.conexion = conectar();
    }

    public Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean validarCredenciales(String usuario, String contrasena) {
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM administradores WHERE usuario = ? AND contraseña = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contrasena);

            ResultSet resultado = preparedStatement.executeQuery();
            return resultado.next(); // Retorna true si hay coincidencias
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para obtener la lista de pilotos
    public List<Piloto> obtenerPilotos() throws SQLException {
        List<Piloto> pilotos = new ArrayList<>();
        String query = "SELECT * FROM pilotos";
        PreparedStatement ps = conexion.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Piloto piloto = new Piloto(
                rs.getInt("idPiloto"),
                rs.getString("nombre"),
                rs.getInt("edad"),
                rs.getString("ciudadNacimiento"),
                rs.getString("paisNacimiento"),
                rs.getDouble("peso"),
                rs.getDouble("altura"),
                rs.getInt("gpDisputados"),
                rs.getInt("podios"),
                rs.getInt("victorias"),
                rs.getInt("puntosTotales")
            );
            pilotos.add(piloto);
        }
        return pilotos;
    }

    // Método para obtener un piloto por ID
    public Piloto obtenerPilotoPorId(int idPiloto) throws SQLException {
        String query = "SELECT * FROM pilotos WHERE idPiloto = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, idPiloto);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Piloto(
                rs.getInt("idPiloto"),
                rs.getString("nombre"),
                rs.getInt("edad"),
                rs.getString("ciudadNacimiento"),
                rs.getString("paisNacimiento"),
                rs.getDouble("peso"),
                rs.getDouble("altura"),
                rs.getInt("gpDisputados"),
                rs.getInt("podios"),
                rs.getInt("victorias"),
                rs.getInt("puntosTotales")
            );
        }
        return null;
    }

    // Método para agregar un nuevo piloto
    public boolean agregarPiloto(Piloto piloto) throws SQLException {
        String query = "INSERT INTO pilotos (nombre, edad, ciudadNacimiento, paisNacimiento, peso, altura, gpDisputados, podios, victorias, puntosTotales) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, piloto.getNombre());
        ps.setInt(2, piloto.getEdad());
        ps.setString(3, piloto.getCiudadNacimiento());
        ps.setString(4, piloto.getPaisNacimiento());
        ps.setDouble(5, piloto.getPeso());
        ps.setDouble(6, piloto.getAltura());
        ps.setInt(7, piloto.getGpDisputados());
        ps.setInt(8, piloto.getPodios());
        ps.setInt(9, piloto.getVictorias());
        ps.setInt(10, piloto.getPuntosTotales());

        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;
    }

    // Método para actualizar los datos de un piloto
    public boolean actualizarPiloto(Piloto piloto) throws SQLException {
        String query = "UPDATE pilotos SET nombre=?, edad=?, ciudadNacimiento=?, paisNacimiento=?, peso=?, altura=?, gpDisputados=?, podios=?, victorias=?, puntosTotales=? WHERE idPiloto=?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, piloto.getNombre());
        ps.setInt(2, piloto.getEdad());
        ps.setString(3, piloto.getCiudadNacimiento());
        ps.setString(4, piloto.getPaisNacimiento());
        ps.setDouble(5, piloto.getPeso());
        ps.setDouble(6, piloto.getAltura());
        ps.setInt(7, piloto.getGpDisputados());
        ps.setInt(8, piloto.getPodios());
        ps.setInt(9, piloto.getVictorias());
        ps.setInt(10, piloto.getPuntosTotales());
        ps.setInt(11, piloto.getIdPiloto());

        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;
    }

    // Método para eliminar un piloto por ID
    public boolean eliminarPiloto(int idPiloto) throws SQLException {
        String query = "DELETE FROM pilotos WHERE idPiloto=?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, idPiloto);

        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;
    }

    // Métodos para gestionar las posiciones (ya implementados)
    public ResultSet obtenerPosiciones(int year, int numeroCarrera) throws SQLException {
        String query = "SELECT idPiloto, posicion FROM posiciones WHERE year=? AND numeroCarrera=?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, year);
        ps.setInt(2, numeroCarrera);
        return ps.executeQuery();
    }

    public void actualizarPosicion(int year, int numeroCarrera, int idPiloto, int posicion) throws SQLException {
        String query = "UPDATE posiciones SET posicion=? WHERE year=? AND numeroCarrera=? AND idPiloto=?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, posicion);
        ps.setInt(2, year);
        ps.setInt(3, numeroCarrera);
        ps.setInt(4, idPiloto);
        ps.executeUpdate();
    }
   
}



