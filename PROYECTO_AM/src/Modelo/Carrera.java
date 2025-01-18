package Modelo;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa una carrera de un Gran Premio.
 */
public class Carrera {
    private int year;
    private int numeroCarrera;
    private String nombreGP;
    private String fecha;
    private Map<Integer, Posicion> posiciones;

    /**
     * Constructor de la clase Carrera.
     *
     * @param year         Año de la carrera.
     * @param numeroCarrera Número de la carrera en la temporada.
     * @param nombreGP      Nombre del Gran Premio.
     * @param fecha         Fecha de la carrera.
     * @param posiciones    Mapa de posiciones de los pilotos.
     */
    public Carrera(int year, int numeroCarrera, String nombreGP, String fecha, Map<Integer, Posicion> posiciones) {
        this.year = year;
        this.numeroCarrera = numeroCarrera;
        this.nombreGP = nombreGP;
        this.fecha = fecha;
        posiciones = new HashMap<Integer, Posicion>();
    }
}

