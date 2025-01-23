package capaPersistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import capaModel.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

    // Query buscar per nom
    List<Alumno> findByNombre(String nombre);
	
}
