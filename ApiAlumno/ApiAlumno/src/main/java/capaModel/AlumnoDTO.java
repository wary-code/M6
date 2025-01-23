package capaModel;

public class AlumnoDTO {

	private Long id;
	private String nom;
	private String email;
	
	public AlumnoDTO(String nom, String email) {
		this.setId(id);
		this.setNom(nom);
		this.setEmail(email);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
