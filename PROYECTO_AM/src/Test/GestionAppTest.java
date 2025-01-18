package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Logica.GestionApp;

class GestionAppTest {

	@Test
    public void testSetYGetUsuarioActual() {
        GestionApp.setUsuarioActual("u001");
        assertEquals("u001", GestionApp.getUsuarioActual());
    }

	@Test
	void testCerrarSesion() {
		GestionApp.setUsuarioActual("u001");
        GestionApp.cerrarSesion();
        assertNull(GestionApp.getUsuarioActual());
	}

}
