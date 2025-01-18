package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import Persistencia.GestorPersistencia;

public class GestorPersistenciaTest {
	private static final String URL = "jdbc:mysql://localhost:3306/bdamf1";
    @Test
    public void testValidarCredenciales_Correctas() {
        // Credenciales válidas según los datos de prueba en la tabla 'administradores'
        boolean resultado = GestorPersistencia.validarCredenciales("u001", "U1Oscar");
        assertTrue("Las credenciales deberían ser válidas", resultado);
    }

    @Test
    public void testValidarCredenciales_Incorrectas() {
        // Credenciales inválidas
        boolean resultado = GestorPersistencia.validarCredenciales("u001", "wrongPassword");
        assertFalse("Las credenciales no deberían ser válidas", resultado);
    }

    @Test
    public void testValidarCredenciales_UsuarioNoExistente() {
        // Usuario que no existe en la base de datos
        boolean resultado = GestorPersistencia.validarCredenciales("usuarioNoExiste", "password123");
        assertFalse("El usuario no debería existir", resultado);
    }

    @Test
    public void testValidarCredenciales_CamposVacios() {
        // Caso de campos vacíos
        boolean resultado = GestorPersistencia.validarCredenciales("", "");
        assertFalse("No debería aceptar credenciales vacías", resultado);
    }
}

