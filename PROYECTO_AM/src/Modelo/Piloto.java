package Modelo;
/**
 * Representa un piloto de Fórmula 1.
 */
public class Piloto {
	private int idPiloto;
	private String nombre;
	private int edad;
	private String ciudadNacimiento;
	private String paisNacimiento;
	private double peso;
	private double altura;
	private int gpDisputados;
	private int podios;
	private int victorias;
	private int puntosTotales;
	/**
     * Constructor de la clase Piloto.
     *
     * @param idPiloto        Identificador único del piloto.
     * @param nombre          Nombre del piloto.
     * @param edad            Edad del piloto.
     * @param ciudadNacimiento Ciudad de nacimiento del piloto.
     * @param paisNacimiento  País de nacimiento del piloto.
     * @param peso            Peso del piloto en kilogramos.
     * @param altura          Altura del piloto en metros.
     * @param gpDisputados    Número de grandes premios disputados.
     * @param podios          Número de podios logrados.
     * @param victorias       Número de victorias obtenidas.
     * @param puntosTotales   Puntos totales acumulados en su carrera.
     */
	public Piloto(int idPiloto, String nombre, int edad, String ciudadNacimiento, String paisNacimiento, double peso,
			double altura, int gpDisputados, int podios, int victorias, int puntosTotales) {
		this.idPiloto = idPiloto;
		this.nombre = nombre;
		this.edad = edad;
		this.ciudadNacimiento = ciudadNacimiento;
		this.paisNacimiento = paisNacimiento;
		this.peso = peso;
		this.altura = altura;
		this.gpDisputados = gpDisputados;
		this.podios = podios;
		this.victorias = victorias;
		this.puntosTotales = puntosTotales;
	}
	/**
     * Obtiene el identificador del piloto.
     *
     * @return Identificador del piloto.
     */
	public int getIdPiloto() {
		return idPiloto;
	}
	/**
     * Establece el identificador del piloto.
     *
     * @param idPiloto Identificador del piloto.
     */
	public void setIdPiloto(int idPiloto) {
		this.idPiloto = idPiloto;
	}
	/**
     * Obtiene el nombre del piloto
     *
     * @return Nombre del piloto.
     */
	public String getNombre() {
		return nombre;
	}
	/**
     * Establece el nombre del piloto.
     *
     * @param nombre Nombre del piloto.
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
     * Obtiene la edad del piloto.
     *
     * @return Edad del piloto.
     */
	public int getEdad() {
		return edad;
	}
	/**
     * Establece la edad del piloto.
     *
     * @param edad Edad del piloto.
     */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	/**
     * Obtiene la ciudad de nacimiento del piloto.
     *
     * @return Ciudad de nacimiento del piloto.
     */
	public String getCiudadNacimiento() {
		return ciudadNacimiento;
	}
	/**
     * Establece la ciudad de nacimiento del piloto.
     *
     * @param ciudadNacimiento Ciudad de nacimiento del piloto.
     */
	public void setCiudadNacimiento(String ciudadNacimiento) {
		this.ciudadNacimiento = ciudadNacimiento;
	}
	/**
     * Obtiene el pais de nacimiento del piloto.
     *
     * @return Pais de nacimiento del piloto.
     */
	public String getPaisNacimiento() {
		return paisNacimiento;
	}
	/**
     * Establece el pais de nacimiento del piloto.
     *
     * @param paisNacimiento Pais de nacimiento del piloto.
     */
	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}
	/**
     * Obtiene el peso del piloto.
     *
     * @return Peso del piloto.
     */
	public double getPeso() {
		return peso;
	}
	/**
     * Establece el peso del piloto.
     *
     * @param peso Peso del piloto.
     */
	public void setPeso(double peso) {
		this.peso = peso;
	}
	/**
     * Obtiene la altura del piloto.
     *
     * @return Altura del piloto.
     */
	public double getAltura() {
		return altura;
	}
	/**
     * Establece la altura del piloto.
     *
     * @param altura Altura del piloto.
     */
	public void setAltura(double altura) {
		this.altura = altura;
	}
	/**
     * Obtiene el numero de GPs disputados del piloto.
     *
     * @return GPs disputados del piloto.
     */
	public int getGpDisputados() {
		return gpDisputados;
	}
	/**
     * Establece el numero de GPs disputados por el piloto.
     *
     * @param GpDisputados Numero de GPs disputados por el piloto.
     */
	public void setGpDisputados(int gpDisputados) {
		this.gpDisputados = gpDisputados;
	}
	/**
     * Obtiene el numero de podios del piloto.
     *
     * @return Numero de podios del piloto.
     */
	public int getPodios() {
		return podios;
	}
	public void setPodios(int podios) {
		this.podios = podios;
	}
	/**
     * Obtiene el numero de victorias del piloto.
     *
     * @return Numero de victorias del piloto.
     */
	public int getVictorias() {
		return victorias;
	}
	/**
     * Establece el numero de victorias del piloto.
     *
     * @param victorias Victorias totales del piloto.
     */
	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}
	/**
     * Obtiene los puntos totales obtenidos del piloto.
     *
     * @return Puntos totales obtenidos del piloto.
     */
	public int getPuntosTotales() {
		return puntosTotales;
	}
	/**
     * Establece los puntos totales del piloto.
     *
     * @param puntosTotales Puntos totales obtenidos del piloto.
     */
	public void setPuntosTotales(int puntosTotales) {
		this.puntosTotales = puntosTotales;
	}
	@Override
	public String toString() {
		return "Piloto [idPiloto=" + idPiloto + ", nombre=" + nombre + ", edad=" + edad + ", ciudadNacimiento="
				+ ciudadNacimiento + ", paisNacimiento=" + paisNacimiento + ", peso=" + peso + ", altura=" + altura
				+ ", gpDisputados=" + gpDisputados + ", podios=" + podios + ", victorias=" + victorias
				+ ", puntosTotales=" + puntosTotales + "]";
	}	
}
