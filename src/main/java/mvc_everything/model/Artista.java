package mvc_everything.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "artista")
public class Artista {
	@Id
	@Column
    private Integer id;
	@Column(length = 128, nullable = false)
	private String nombre;
	@Column
	private boolean activo;
	///
	@OneToMany
	public List<Album> albunes;
	  
	public List<Album> getAlbunes() {
		return albunes;
	}
	public void setAlbunes(List<Album> albunes) {
		this.albunes = albunes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	  
	  

}
