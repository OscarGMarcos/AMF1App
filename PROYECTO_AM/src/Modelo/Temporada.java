package Modelo;
/**
 * Representa una temporada de Fórmula 1.
 */
public class Temporada {
	private int year;
	/**
     * Constructor de la clase Temporada.
     *
     * @param year Año de la temporada.
     */
	public Temporada(int year) {
		this.year = year;
	}
	/**
     * Obtiene el año de la temporada.
     *
     * @return Año de la temporada.
     */
	public int getYear() {
		return year;
	}
	/**
     * Establece el año de la temporada.
     *
     * @param year Año de la temporada.
     */
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Temporada [year=" + year + "]";
	}
}
