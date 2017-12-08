package mvc_everything.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "song")
public class Song {
	@Id
	@Column(length=16)
	private String id_song;
	
	@Column(name="name", length=128,nullable=false)
	private String song_name;
	
	@Column(name="avgrating",length=2,nullable=false)
	private Integer avgrating;
	
	@Column(name="timesplayed",length=15,nullable=false)
	private Integer timesplayed;
	
	@Column(name="timesrated",length=15,nullable=false)
	private Integer timesrated;
	
	@Column(name="duration",length=7,nullable=false)
	private Double duration;
	
	@Column(name="file",length=256,nullable=false)
	private String file;
	
	@Column(name="active",length=1,nullable=false)
	private Boolean active=true;
	
	@ManyToMany(mappedBy="songs")
	private List<PlayList> playlists;
	
	
	@ManyToOne
	@JoinColumn(name="id_album")
	private Album album;

	public String getId_song() {
		return id_song;
	}

	public void setId_song(String id_song) {
		this.id_song = id_song;
	}

	public String getSong_name() {
		return song_name;
	}

	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}

	public Integer getAvgrating() {
		return avgrating;
	}

	public void setAvgrating(Integer avgrating) {
		this.avgrating = avgrating;
	}

	public Integer getTimesplayed() {
		return timesplayed;
	}

	public void setTimesplayed(Integer timesplayed) {
		this.timesplayed = timesplayed;
	}

	public Integer getTimesrated() {
		return timesrated;
	}

	public void setTimesrated(Integer timesrated) {
		this.timesrated = timesrated;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
}