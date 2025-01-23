package capaTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import capaModel.Alumno;
import capaServei.AlumnoService;


public class AlumnoServiceTest {

	@Autowired
	private AlumnoService alumnoService;
	
	@Test
	public void testObtenirAlumno() {
		alumnoService.obtenirPerId((long) 1);
	}
}
