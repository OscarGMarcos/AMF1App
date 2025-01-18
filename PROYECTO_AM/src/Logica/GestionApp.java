package Logica;

import Excepciones.ProyectoExcepcion;
import Persistencia.GestorPersistencia;

public class GestionApp {
	 // Atributo para almacenar el usuario actual
	 private static String usuarioActual;

	    // Método para establecer el usuario actual
	    public static void setUsuarioActual(String usuario) {
	        usuarioActual = usuario;
	    }

	    // Método para obtener el usuario actual
	    public static String getUsuarioActual() {
	        return usuarioActual;
	    }

	    // Limpia el usuario al cerrar sesión
	    public static void cerrarSesion() {
	        usuarioActual = null;
	    }
	}