package mvc_everything.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "songList")

public class SongList {
    @Id
    private Long id;

    @ManyToMany//Una cancion en varias songlist - Una songlist con varias canciones
    @JoinTable(name = "songListSongs",
    joinColumns = @JoinColumn(name = "songListID", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "songID", referencedColumnName = "id"))
    private List<Song>songs;

    public List<Song> getSongs() {
        return songs;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
    

    //void addSong(Song nSong){}
    //void removeSong(Song nSong){}
    //void addAlbum(Album nAlbum){}

}