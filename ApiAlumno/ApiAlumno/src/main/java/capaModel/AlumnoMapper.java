package capaModel;

public class AlumnoMapper {

	public static AlumnoDTO toDTO(Alumno alumno) {
	    return new AlumnoDTO(alumno.getNom(), alumno.getEmail());
}

}
