package mvc_everything.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mvc_everything.model.Artista;

@Entity
@Table(name = "album")
public class Album {
	@Id
	@Column
	private Integer id;
	@Column(length = 128, nullable = false)
	private String name;
	@Column(length = 128)
	private boolean active;
	@ManyToOne
	@JoinColumn(name = "id_artist")
	private Artista artist;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Artista getArtist() {
		return artist;
	}
	public void setArtist(Artista artist) {
		this.artist = artist;
	}

	
	
}
