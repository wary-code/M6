package capaPresentacio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import capaModel.Alumno;
import capaModel.AlumnoDTO;
import capaModel.AlumnoMapper;
import capaSeguretat.AlumnoNotFoundException;
import capaServei.AlumnoService;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	// mètode GET per obtenir tots els usuaris
	@GetMapping
	public List<Alumno> obtenirTotsElsAlumnes() {
		return alumnoService.obtenirTots();
	}

	// mètode GET per obtenir un usuari per ID
	@GetMapping("/{id}")
	public Alumno obtenirAlumnePerId(@PathVariable Long id) {
		Alumno alumno = alumnoService.obtenirPerId(id);
		if (alumno == null) {
			throw new AlumnoNotFoundException("Alumno not found with id: " + id);
		} else {
			return alumno;
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<AlumnoDTO> obtenirAlumno(@PathVariable Long id) {
		Alumno alumno = alumnoService.obtenirPerId(id);
		if (alumno == null) {
			throw new AlumnoNotFoundException("Alumno not found with id: " + id);
		} else {
			AlumnoDTO alumnoDTO = AlumnoMapper.toDTO(alumno);
			return ResponseEntity.ok(alumnoDTO);
		}

	}

	// mètode POST per crear un nou usuari
	@SuppressWarnings("unused")
	@PostMapping
	public ResponseEntity<Alumno> crearAlumno(@RequestBody Alumno alumno) {
		Alumno alumnoCreat = alumnoService.crear(alumno);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// mètode PUT per actualitzar un usuari existent
	@PutMapping("/{id}")
	public Optional<Object> actualitzarUsuari(@PathVariable Long id, @RequestBody Alumno alumno) {
		Alumno alumnoActualizar = alumnoService.obtenirPerId(id);

		if (alumnoActualizar != null) {
			Optional<Alumno> alumnoActualitzat = alumnoService.actualitzar(id, alumno);
			return alumnoActualitzat.map(ResponseEntity::ok);
		} else {
			throw new AlumnoNotFoundException("Alumno not found with id: " + id);
		}
	}

	// mètode DELETE per eliminar un usuari per ID
	@DeleteMapping("/{id}")
	public boolean eliminarAlumno(@PathVariable Long id) {
		Alumno alumno = alumnoService.obtenirPerId(id);
		if (alumno == null) {
			throw new AlumnoNotFoundException("Alumno not found with id: " + id);
		} else {
			alumnoService.eliminar(id);
			return alumnoService.eliminar(id);
		}
	}

	// Buscar alumnes per nom
	@GetMapping("/buscar/nom")
	public List<Alumno> buscarPorNombre(@RequestParam String nom) {
		return alumnoService.buscarPorNombre(nom);
	}

}
