package capaServei;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capaModel.Alumno;
import capaPersistencia.AlumnoRepository;

@Service
public class AlumnoService {

	 @Autowired
	 private AlumnoRepository alumnoRepository;
	
	public List<Alumno> obtenirTots() {	
			return alumnoRepository.findAll();
	}

	public Alumno obtenirPerId(Long id) {
		 return alumnoRepository.findById(id).orElse(null);
	}

	public Alumno crear(Alumno alumno) {
		 return alumnoRepository.save(alumno);
	}

	  public Optional<Alumno> actualitzar(Long id, Alumno alumno) {
	        return alumnoRepository.findById(id).map(existingAlumno -> {
	            existingAlumno.setNom(alumno.getNom()); 
	            existingAlumno.setEmail(alumno.getEmail());
	            return alumnoRepository.save(existingAlumno);
	        });
	    }

	public boolean eliminar(Long id) {
		if (alumnoRepository.existsById(id)) {
            alumnoRepository.deleteById(id);
            return true;
        }
        return false;
    }

	 public List<Alumno> buscarPorNombre(String nombre) {
	        return alumnoRepository.findByNombre(nombre);
	    }
 
}
